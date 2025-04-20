package com.vilela.felipe.api_2025.controller;

import com.vilela.felipe.api_2025.model.dto.DadosAtualizacaoConserto;
import com.vilela.felipe.api_2025.model.dto.DadosConsertoResumo;
import com.vilela.felipe.api_2025.model.entity.Conserto;
import com.vilela.felipe.api_2025.repository.ConsertoRepository;
import com.vilela.felipe.api_2025.model.dto.DadosConserto;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

        return repository.findAllByAtivoTrue(pageable);
    }

    @GetMapping("resumo")
    public List<DadosConsertoResumo> listarResumo(){
        return repository.findAllByAtivoTrue().stream().map(DadosConsertoResumo::new).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conserto> getMedicoById(@PathVariable Long id){
        Optional<Conserto> consertoOptional = repository.findById(id);

        if (consertoOptional.isPresent()){
            Conserto conserto = consertoOptional.get();
            return ResponseEntity.ok(conserto);
        }else {
           return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoConserto dados){
        Conserto conserto = repository.getReferenceById(dados.id());
        conserto.atualizarInformacoes(dados);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        Conserto conserto = repository.getReferenceById(id);
        conserto.excluir();
    }

}
