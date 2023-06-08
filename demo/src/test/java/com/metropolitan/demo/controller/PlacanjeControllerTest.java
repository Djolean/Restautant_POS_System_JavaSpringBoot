package com.metropolitan.demo.controller;

import com.metropolitan.demo.controller.PlacanjeController;
import com.metropolitan.demo.service.PlacanjeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PlacanjeControllerTest {
    @InjectMocks
    private PlacanjeController placanjeController;

    @Mock
    private PlacanjeService placanjeService;

    @Test
    void naplatiTest() {
        MockitoAnnotations.openMocks(this); // Initialize mocks

        Integer narudzbinaId = 1;

        String result = placanjeController.naplati(narudzbinaId);

        verify(placanjeService).naplati(narudzbinaId);
        assertEquals("redirect:/stos", result);
    }
}
