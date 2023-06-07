package com.metropolitan.demo.controller;

import com.metropolitan.demo.entity.Jelo;
import com.metropolitan.demo.service.JeloService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/jelos")
@RequiredArgsConstructor
public class JeloController {
	private final JeloService jeloService;

	@GetMapping
	public String getAllJelos(Model model) {
		List<Jelo> jelos = jeloService.findAll();
		model.addAttribute("jelos", jelos);
		return "jelo/jela";
	}

	@GetMapping("/{jeloId}")
	public String getJeloById(@PathVariable Integer jeloId, Model model) {
		Jelo jelo = jeloService.findById(jeloId);
		model.addAttribute("jelo", jelo);
		return "jela";
	}

	@GetMapping("/create")
	public String showCreateForm(Model model) {
		Jelo jelo = new Jelo();
		model.addAttribute("jelo", jelo);
		return "jelo/create-jelo";
	}

	@PostMapping("/createJelo")
	public String saveJelo(@ModelAttribute("jelo") Jelo jelo) {
		jeloService.save(jelo);
		return "redirect:/jelos";
	}

	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable Integer id, Model model) {
		Jelo jelo = jeloService.findById(id);
		model.addAttribute("jelo", jelo);
		return "jelo/update-jelo";
	}

	@PostMapping("/update/{id}")
	public String updateJelo(@PathVariable("id") Integer id, @Valid Jelo jelo, BindingResult result, Model model) {
		if (result.hasErrors()) {
			jelo.setId(id);
			return "jelo/update-jelo";
		}
		jeloService.save(jelo);
		model.addAttribute("jelos", jeloService.findAll());
		return "redirect:/jelos";
	}


	@GetMapping("/delete/{jeloId}")
	public String deleteJeloById(@PathVariable Integer jeloId) {
		jeloService.deleteById(jeloId);
		return "redirect:/jelos";
	}

	@GetMapping("/sortJeloByPriceDesc")
	public String sortJeloByPriceDesc(Model model) {
		List<Jelo> jelos = jeloService.findAll();
		jelos = jeloService.sortJeloByPriceDesc(jelos);
		model.addAttribute("jelos", jelos);
		return "jelo/jela";
	}

	@GetMapping("/sortJeloByPriceAsc")
	public String sortJeloByPriceAsc(Model model) {
		List<Jelo> jelos = jeloService.findAll();
		jelos = jeloService.sortJeloByPriceAsc(jelos);
		model.addAttribute("jelos", jelos);
		return "jelo/jela";
	}

	@GetMapping("/sortJeloByNameAsc")
	public String sortJeloByStringAsc(Model model) {
		List<Jelo> j = jeloService.findAll();
		j = jeloService.sortJeloByNameAsc(j);
		model.addAttribute("jelos", j);

		return "jelo/jela";
	}

	@GetMapping("/sortJeloByNameDesc")
	public String sortJeloByStringDesc(Model model) {
		List<Jelo> j = jeloService.findAll();
		j = jeloService.sortJeloByNameDesc(j);
		model.addAttribute("jelos", j);

		return "jelo/jela";
	}

}