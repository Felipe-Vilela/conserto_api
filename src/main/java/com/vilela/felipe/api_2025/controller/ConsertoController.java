package com.vilela.felipe.api_2025.controller;

import com.vilela.felipe.api_2025.model.entity.Conserto;
import com.vilela.felipe.api_2025.repository.ConsertoRepository;
import com.vilela.felipe.api_2025.model.dto.DadosConserto;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conserto")
public class ConsertoController {

    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosConserto dados) {
        repository.save(new Conserto(dados));
    }

    @GetMapping
    public List<Conserto> listar(){
        return repository.findAll();
    }

    // apenas as datas, o nome do mecânico,a marca e o modelo
    //do veículo

    
}
