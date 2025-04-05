package com.vilela.felipe.api_2025.controller;

import com.vilela.felipe.api_2025.conserto.Conserto;
import com.vilela.felipe.api_2025.conserto.ConsertoRepository;
import com.vilela.felipe.api_2025.conserto.DadosConserto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conserto")
public class ConsertoController {

    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosConserto dados) {
        repository.save(new Conserto(dados));
    }

}
