package com.metropolitan.demo.controller;

import com.metropolitan.demo.entity.Jelo;
import com.metropolitan.demo.service.JeloService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class JeloControllerTest {

    @Mock
    private JeloService jeloService;

    @InjectMocks
    private JeloController jeloController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void showCreateForm() {
        Model model = mock(Model.class);
        Jelo jelo = new Jelo();

        String viewName = jeloController.showCreateForm(model);

        assertEquals("jelo/create-jelo", viewName);
        verify(model).addAttribute(eq("jelo"), any(Jelo.class));
    }


    @Test
    void showEditForm() {
        Integer id = 1;
        Model model = mock(Model.class);
        Jelo jelo = new Jelo();
        when(jeloService.findById(id)).thenReturn(jelo);

        String viewName = jeloController.showEditForm(id, model);

        assertEquals("jelo/update-jelo", viewName);
        verify(model).addAttribute("jelo", jelo);
        verify(jeloService).findById(id);
    }

    @Test
    void sortJeloByPriceDesc() {
        Model model = mock(Model.class);
        List<Jelo> jelos = new ArrayList<>();
        when(jeloService.findAll()).thenReturn(jelos);
        when(jeloService.sortJeloByPriceDesc(jelos)).thenReturn(jelos);

        String viewName = jeloController.sortJeloByPriceDesc(model);

        assertEquals("jelo/jela", viewName);
        verify(model).addAttribute("jelos", jelos);
        verify(jeloService).findAll();
        verify(jeloService).sortJeloByPriceDesc(jelos);
    }

    @Test
    void sortJeloByPriceAsc() {
        Model model = mock(Model.class);
        List<Jelo> jelos = new ArrayList<>();
        when(jeloService.findAll()).thenReturn(jelos);
        when(jeloService.sortJeloByPriceAsc(jelos)).thenReturn(jelos);

        String viewName = jeloController.sortJeloByPriceAsc(model);

        assertEquals("jelo/jela", viewName);
        verify(model).addAttribute("jelos", jelos);
        verify(jeloService).findAll();
        verify(jeloService).sortJeloByPriceAsc(jelos);
    }

    @Test
    void sortJeloByStringAsc() {
        Model model = mock(Model.class);
        List<Jelo> jelos = new ArrayList<>();
        when(jeloService.findAll()).thenReturn(jelos);
        when(jeloService.sortJeloByNameAsc(jelos)).thenReturn(jelos);

        String viewName = jeloController.sortJeloByStringAsc(model);

        assertEquals("jelo/jela", viewName);
        verify(model).addAttribute("jelos", jelos);
        verify(jeloService).findAll();
        verify(jeloService).sortJeloByNameAsc(jelos);
    }

    @Test
    void sortJeloByStringDesc() {
        Model model = mock(Model.class);
        List<Jelo> jelos = new ArrayList<>();
        when(jeloService.findAll()).thenReturn(jelos);
        when(jeloService.sortJeloByNameDesc(jelos)).thenReturn(jelos);

        String viewName = jeloController.sortJeloByStringDesc(model);

        assertEquals("jelo/jela", viewName);
        verify(model).addAttribute("jelos", jelos);
        verify(jeloService).findAll();
        verify(jeloService).sortJeloByNameDesc(jelos);
    }
}