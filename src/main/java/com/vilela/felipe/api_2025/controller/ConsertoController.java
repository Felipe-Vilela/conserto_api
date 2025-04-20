package com.vilela.felipe.api_2025.controller;

import com.vilela.felipe.api_2025.model.dto.DadosConsertoResumo;
import com.vilela.felipe.api_2025.model.entity.Conserto;
import com.vilela.felipe.api_2025.repository.ConsertoRepository;
import com.vilela.felipe.api_2025.model.dto.DadosConserto;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("conserto")
public class ConsertoController {

    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosConserto dados) {
        repository.save(new Conserto(dados));
    }

    @GetMapping
    public Page<Conserto> listar(Pageable pageable){
        return repository.findAll(pageable);
    }

    @GetMapping("resumo")
    public List<DadosConsertoResumo> listarResumo(){
        return repository.findAllByAtivoTrue().stream().map(DadosConsertoResumo::new).toList();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        Conserto conserto = repository.getReferenceById(id);
        conserto.excluir();
    }

}
