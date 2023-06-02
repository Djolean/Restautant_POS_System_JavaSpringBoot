package com.metropolitan.demo.service.impl;

import ch.qos.logback.core.html.IThrowableRenderer;
import com.metropolitan.demo.entity.Sto;
import com.metropolitan.demo.repository.StoRepository;
import com.metropolitan.demo.service.StoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoServiceImpl implements StoService {

    private final StoRepository stoRepository;

    @Override
    public List<Sto> findAll() {
        return stoRepository.findAll();
    }

    @Override
    public Sto save(Sto sto) {
        return stoRepository.save(sto);
    }

    @Override
    public Sto update(Sto sto) {
        return stoRepository.save(sto);
    }

    @Override
    public Sto findById(Integer stoId) {
        return stoRepository.findById(stoId).orElseThrow(() -> new RuntimeException("Sto nije pronadjen"));
    }

    @Override
    public void deleteById(Integer stoId) {
        stoRepository.deleteById(stoId);
    }
}
