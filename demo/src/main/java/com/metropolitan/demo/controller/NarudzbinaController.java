package com.metropolitan.demo.controller;

import com.metropolitan.demo.entity.Narudzbina;
import com.metropolitan.demo.service.NarudzbinaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/narudzbinas")
@RequiredArgsConstructor
public class NarudzbinaController {
    private final NarudzbinaService narudzbinaService;

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


	@PostMapping("/{narudzbinaId}/{jeloId}")
    public String addToNarudzbina(@PathVariable Integer narudzbinaId, @PathVariable Integer jeloId) {
        narudzbinaService.addToNarudzbina(narudzbinaId, jeloId);
        return "klijent/klijenti";
    }

    @DeleteMapping("/{narudzbinaId}/{jeloId}")
    public String deleteFromNarudzbina(@PathVariable Integer narudzbinaId, @PathVariable Integer jeloId) {
        narudzbinaService.deleteFromNarudzbina(narudzbinaId, jeloId);
        return "redirect:/klijent/klijenti";
    }

    @GetMapping("/klijenti")
    public String showStolovi() {
        return "klijent/klijenti";
    }
}

