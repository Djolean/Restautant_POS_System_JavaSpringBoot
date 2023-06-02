package com.metropolitan.demo.controller;
import com.metropolitan.demo.entity.Korisnik;
import com.metropolitan.demo.service.KorisnikService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalControllerAdvice {
    private final KorisnikService korisnikService;

    // ATTRIBUTE
    @ModelAttribute("isAdmin")
    public boolean isAdmin() {
        return korisnikService.isUserAdmin();
    }

    @ModelAttribute("user")
    public Korisnik getLoggedInUser() {
        return korisnikService.getLoggedInUser();
    }

}