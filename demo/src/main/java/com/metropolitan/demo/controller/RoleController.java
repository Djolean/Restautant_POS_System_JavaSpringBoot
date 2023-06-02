package com.metropolitan.demo.controller;

import com.metropolitan.demo.entity.Role;
import com.metropolitan.demo.service.RoleService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {
	private final RoleService roleService;

	@GetMapping
	public String getAllRoles(Model model) {
		List<Role> roles = roleService.findAll();
		model.addAttribute("roles", roles);
		return "role-list";
	}

	@GetMapping("/{roleId}")
	public String getRoleById(@PathVariable Integer roleId, Model model) {
		Role role = roleService.findById(roleId);
		model.addAttribute("role", role);
		return "role-details";
	}

	@PostMapping
	public String saveRole(@ModelAttribute("role") Role role) {
		roleService.save(role);
		return "redirect:/roles";
	}

	@PutMapping
	public String updateRole(@ModelAttribute("role") Role role) {
		roleService.update(role);
		return "redirect:/roles";
	}

	@DeleteMapping("/{roleId}")
	public String deleteRoleById(@PathVariable Integer roleId) {
		roleService.deleteById(roleId);
		return "redirect:/roles";
	}
}
