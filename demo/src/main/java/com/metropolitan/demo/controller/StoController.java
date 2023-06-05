package com.metropolitan.demo.controller;

import com.metropolitan.demo.entity.Role;
import com.metropolitan.demo.entity.Sto;
import com.metropolitan.demo.repository.StoRepository;
import com.metropolitan.demo.service.StoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("/stos")
public class StoController {

    private final StoService stoService;
    private final StoRepository stoRepository;

//    @GetMapping("/sto/{id}")
//    public String openStoPage(@PathVariable("id") Integer id, Model model) {
//        Sto sto = stoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ne postoji id"));
//        model.addAttribute("sto", sto);
//        return "narudzbina/narudzbina";
//    }

    @GetMapping
    public String getAllStos(Model model) {
        List<Sto> stos = stoService.findAll();
        model.addAttribute("stos", stos);
        return "klijent/klijenti";
    }
}
