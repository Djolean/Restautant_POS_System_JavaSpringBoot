package com.metropolitan.demo.controller;

import com.metropolitan.demo.entity.Korisnik;
import com.metropolitan.demo.service.KorisnikService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class KorisnikControllerTest {

    @Mock
    private KorisnikService korisnikService;

    @InjectMocks
    private KorisnikController korisnikController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void showCreateForm() {
        Model model = mock(Model.class);

        String viewName = korisnikController.showCreateForm(model);

        assertEquals("korisnik/create-korisnik", viewName);
        verify(model).addAttribute(eq("korisnik"), any(Korisnik.class));
    }

    @Test
    void showEditForm() {
        Integer id = 1;
        Model model = mock(Model.class);
        Korisnik korisnik = new Korisnik();
        when(korisnikService.findById(id)).thenReturn(korisnik);

        String viewName = korisnikController.showEditForm(id, model);

        assertEquals("korisnik/update-korisnik", viewName);
        verify(model).addAttribute("korisnik", korisnik);
        verify(korisnikService).findById(id);
    }

    @Test
    void showKorisnici() {
        String viewName = korisnikController.showKorisnici();

        assertEquals("korisnik/korisnici", viewName);
    }
}
