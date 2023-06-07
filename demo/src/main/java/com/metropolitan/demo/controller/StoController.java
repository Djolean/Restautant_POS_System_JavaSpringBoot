package com.metropolitan.demo.controller;

import com.metropolitan.demo.entity.Role;
import com.metropolitan.demo.entity.Sto;
import com.metropolitan.demo.repository.StoRepository;
import com.metropolitan.demo.service.StoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("/stos")
public class StoController {

    private final StoService stoService;
    private final StoRepository stoRepository;

    @GetMapping
    public String getAllStos(Model model) {
        List<Sto> stos = stoService.findAll();
        model.addAttribute("stos", stos);
        return "klijent/klijenti";
    }

//    @GetMapping
//    public boolean isZauzeto(@RequestParam("stoId") Integer stoId, Model model) {
//        boolean zauzeto = stoRepository.getZauzetoValueById(stoService.findById(stoId));
//        model.addAttribute("stos", zauzeto);
//        return zauzeto;
//    }
}
