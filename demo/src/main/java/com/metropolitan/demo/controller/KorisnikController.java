package com.metropolitan.demo.controller;

import com.metropolitan.demo.entity.Korisnik;
import com.metropolitan.demo.service.KorisnikService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/korisniks")
@RequiredArgsConstructor
public class KorisnikController {
    private final KorisnikService korisnikService;

    @GetMapping
    public String getAllKorisniks(Model model) {
        List<Korisnik> korisniks = korisnikService.findAll();
        model.addAttribute("korisniks", korisniks);
        return "korisnik/korisnici";
    }

    @GetMapping("/{id}")
    public String getKorisnikById(@PathVariable Integer id, Model model) {
        Korisnik korisnik = korisnikService.findById(id);
        model.addAttribute("korisnik", korisnik);
        return "korisniks";
    }

    @PostMapping("/createKorisnik")
    public String saveKorisnik(@ModelAttribute("korisnik") Korisnik korisnik) {
        korisnikService.save(korisnik);
        return "redirect:/korisniks";
    }

    @PostMapping("/update/{id}")
    public String updateKorisnik(@PathVariable("id") Integer id, @Valid Korisnik korisnik, BindingResult result, Model model) {
        if (result.hasErrors()) {
            korisnik.setId(id);
            return "korisnik/update-korisnik";
        }
        korisnikService.save(korisnik);
        model.addAttribute("korisniks", korisnikService.findAll());
        return "redirect:/korisniks";
    }
    @GetMapping("/delete/{id}")
    public String deleteKorisnikById(@PathVariable Integer id) {
        korisnikService.deleteById(id);
        return "redirect:/korisniks";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        Korisnik korisnik = new Korisnik();
        model.addAttribute("korisnik", korisnik);
        return "korisnik/create-korisnik";
    }


    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Korisnik korisnik = korisnikService.findById(id);
        model.addAttribute("korisnik", korisnik);
        return "korisnik/update-korisnik";
}


    @GetMapping("/korisnici")
    public String showKorisnici() {
        return "korisnik/korisnici";
    }
    }


