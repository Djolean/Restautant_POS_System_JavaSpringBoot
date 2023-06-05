package com.metropolitan.demo.controller;

import com.metropolitan.demo.entity.Jelo;
import com.metropolitan.demo.entity.Narudzbina;
import com.metropolitan.demo.entity.Sto;
import com.metropolitan.demo.service.JeloService;
import com.metropolitan.demo.service.KorisnikService;
import com.metropolitan.demo.service.NarudzbinaService;
import com.metropolitan.demo.service.StoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

    @PostMapping("/{narudzbinaId}")
    public String deleteNarudzbinaById(@PathVariable Integer narudzbinaId) {
        narudzbinaService.deleteById(narudzbinaId);
        return "redirect:/narudzbinas";
    }


    @PostMapping("/sto/novaNarudzbina")
    public String addToNarudzbina(@RequestParam("jeloId") Integer jeloId,
                                  @RequestParam("stoId") Integer stoId,
                                  Model model) {

        Narudzbina novaNarudzbina = narudzbinaService.addToNarudzbina(stoId, jeloId);
        List<Jelo> listaJela = novaNarudzbina.getJelos();
        model.addAttribute("listaJela", listaJela);
        model.addAttribute("jelos", jeloService.findAll());
        model.addAttribute("stoId", stoId);
        model.addAttribute("narudzbina", novaNarudzbina);
        return "narudzbina/narudzbina";
    }

    @PostMapping("/delete")
    public String deleteFromNarudzbina(@RequestParam("narudzbinaBrisanjeId") Integer narudzbinaBrisanjeId,
                                       @RequestParam("jeloBrisanjeId") Integer jeloBrisanjeId,
                                       HttpServletRequest request) {
        narudzbinaService.deleteFromNarudzbina(narudzbinaBrisanjeId, jeloBrisanjeId);
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }

    @GetMapping("/sto/novaNarudzbina")
    public String showNarudzbina(@RequestParam("id") Integer id, Model model) {
        Sto sto = stoService.findById(id);
        sto.setZauzeto(true);

        Optional<Narudzbina> narudzbina = Optional.ofNullable(stoService.findById(sto.getId()).getNarudzbina());
        if (narudzbina.isEmpty()) {
            Narudzbina novaNarudzbina = new Narudzbina();
            novaNarudzbina.setKorisnikId(korisnikService.getLoggedInUser());
            novaNarudzbina.setDatum(LocalDate.now());
            sto.setNarudzbina(novaNarudzbina);
            narudzbinaService.save(novaNarudzbina);
            stoService.update(sto);
            model.addAttribute("narudzbina", novaNarudzbina);
        } else {
            List<Jelo> listaJela = narudzbina.get().getJelos();
            model.addAttribute("listaJela", listaJela);
            model.addAttribute("narudzbina", narudzbina.get());
        }

        model.addAttribute("jelos", jeloService.findAll());
        model.addAttribute("stoId", sto.getId());

        return "narudzbina/narudzbina";
    }
}

