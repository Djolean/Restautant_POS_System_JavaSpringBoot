package com.metropolitan.demo.controller;

import com.metropolitan.demo.entity.Jelo;
import com.metropolitan.demo.entity.Narudzbina;
import com.metropolitan.demo.entity.Sto;
import com.metropolitan.demo.repository.KorisnikRepository;
import com.metropolitan.demo.service.JeloService;
import com.metropolitan.demo.service.KorisnikService;
import com.metropolitan.demo.service.NarudzbinaService;
import com.metropolitan.demo.service.StoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Controller
@RequestMapping("/narudzbinas")
@RequiredArgsConstructor
public class NarudzbinaController {
    private final NarudzbinaService narudzbinaService;
    private final JeloService jeloService;
    private final KorisnikService korisnikService;
    private final StoService stoService;

    @GetMapping
    public String getAllNarudzbinas(Model model) {
        List<Narudzbina> narudzbinas = narudzbinaService.findAll();
        model.addAttribute("narudzbinas", narudzbinas);
        return "narudzbina-list";
    }

    @GetMapping("/{narudzbinaId}")
    public String getNarudzbinaById(@PathVariable Integer narudzbinaId, Model model) {
        Narudzbina narudzbina = narudzbinaService.findById(narudzbinaId);
        model.addAttribute("narudzbina", narudzbina);
        return "narudzbina-details";
    }

    @PostMapping
    public String saveNarudzbina(@ModelAttribute("narudzbina") Narudzbina narudzbina) {
        narudzbinaService.save(narudzbina);
        return "redirect:/narudzbinas";
    }

    @PutMapping
    public String updateNarudzbina(@ModelAttribute("narudzbina") Narudzbina narudzbina) {
        narudzbinaService.update(narudzbina);
        return "redirect:/narudzbinas";
    }

    @DeleteMapping("/{narudzbinaId}")
    public String deleteNarudzbinaById(@PathVariable Integer narudzbinaId) {
        narudzbinaService.deleteById(narudzbinaId);
        return "redirect:/narudzbinas";
    }


	@PostMapping("/sto/novaNarudzbina/{jeloId}")
    public String addToNarudzbina(@RequestParam Integer jeloId, @Valid Narudzbina narudzbina ) {
        Jelo jelo = jeloService.findById(jeloId);
        List<Jelo> jela = new ArrayList<>();
        jela.add(jelo);
        narudzbina.setJelos(jela);
        narudzbina.setDatum(LocalDate.from(LocalDateTime.now()));
        narudzbina.setKorisnikId(korisnikService.getLoggedInUser());
        narudzbina.setUkupnaCena(narudzbinaService.ukupnaCenaNarudzbine(jela));

        narudzbinaService.save(narudzbina);

        return "narudzbina/narudzbina";
    }



    @DeleteMapping("/{narudzbinaId}/{jeloId}")
    public String deleteFromNarudzbina(@PathVariable Integer narudzbinaId, @PathVariable Integer jeloId) {
        narudzbinaService.deleteFromNarudzbina(narudzbinaId, jeloId);
        return "redirect:/narudzbina/narudzbina";
    }
//
//    @GetMapping
//    public String getAllJelos(Model model) {
//        List<Jelo> jelos = jeloService.findAll();
//        model.addAttribute("jelos", jelos);
//        return "narudzbina/narudzbina";
//    }

    @GetMapping("/sto/novaNarudzbina")
    public String showNarudzbina(@RequestParam("id") Integer id, Jelo jelo, Model model) {
        Sto sto = stoService.findById(id);
        List<Jelo> jelos = jeloService.findAll();
        model.addAttribute("jelos", jelos);
        Narudzbina narudzbina = new Narudzbina();
        model.addAttribute("narudzbina", narudzbina);
        model.addAttribute("sto", sto);
        return "narudzbina/narudzbina";
    }
}

