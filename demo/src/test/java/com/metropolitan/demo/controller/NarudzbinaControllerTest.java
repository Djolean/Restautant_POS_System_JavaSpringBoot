package com.metropolitan.demo.controller;

import com.metropolitan.demo.controller.NarudzbinaController;
import com.metropolitan.demo.entity.Jelo;
import com.metropolitan.demo.entity.Narudzbina;
import com.metropolitan.demo.entity.Sto;
import com.metropolitan.demo.repository.StoRepository;
import com.metropolitan.demo.service.JeloService;
import com.metropolitan.demo.service.KorisnikService;
import com.metropolitan.demo.service.NarudzbinaService;
import com.metropolitan.demo.service.StoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class NarudzbinaControllerTest {

    @Mock
    private NarudzbinaService narudzbinaService;

    @Mock
    private JeloService jeloService;

    @Mock
    private KorisnikService korisnikService;

    @Mock
    private StoService stoService;

    @Mock
    private StoRepository stoRepository;

    @InjectMocks
    private NarudzbinaController narudzbinaController;

    @Mock
    private Model model;

    @Mock
    private HttpServletRequest request;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllNarudzbinas() {
        List<Narudzbina> narudzbinas = new ArrayList<>();
        when(narudzbinaService.findAll()).thenReturn(narudzbinas);

        String viewName = narudzbinaController.getAllNarudzbinas(model);

        assertEquals("narudzbina-list", viewName);
        verify(model).addAttribute("narudzbinas", narudzbinas);
    }

    @Test
    void getNarudzbinaById() {
        Narudzbina narudzbina = new Narudzbina();
        Integer narudzbinaId = 1;
        when(narudzbinaService.findById(narudzbinaId)).thenReturn(narudzbina);

        String viewName = narudzbinaController.getNarudzbinaById(narudzbinaId, model);

        assertEquals("narudzbina-details", viewName);
        verify(model).addAttribute("narudzbina", narudzbina);
    }

    @Test
    void saveNarudzbina() {
        Narudzbina narudzbina = new Narudzbina();

        String viewName = narudzbinaController.saveNarudzbina(narudzbina);

        assertEquals("redirect:/narudzbinas", viewName);
        verify(narudzbinaService).save(narudzbina);
    }

    @Test
    void updateNarudzbina() {
        Narudzbina narudzbina = new Narudzbina();

        String viewName = narudzbinaController.updateNarudzbina(narudzbina);

        assertEquals("redirect:/narudzbinas", viewName);
        verify(narudzbinaService).update(narudzbina);
    }

    @Test
    void deleteNarudzbinaById() {
        Integer narudzbinaId = 1;

        String viewName = narudzbinaController.deleteNarudzbinaById(narudzbinaId);

        assertEquals("redirect:/narudzbinas", viewName);
        verify(narudzbinaService).deleteById(narudzbinaId);
    }


    @Test
    void deleteFromNarudzbina() {
        Integer narudzbinaBrisanjeId = 1;
        Integer jeloBrisanjeId = 1;
        String referer = "referer-url";

        when(request.getHeader("Referer")).thenReturn(referer);

        String viewName = narudzbinaController.deleteFromNarudzbina(narudzbinaBrisanjeId, jeloBrisanjeId, request);

        assertEquals("redirect:" + referer, viewName);
        verify(narudzbinaService).deleteFromNarudzbina(narudzbinaBrisanjeId, jeloBrisanjeId);
    }

}
