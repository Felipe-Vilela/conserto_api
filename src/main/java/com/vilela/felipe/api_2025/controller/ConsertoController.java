package com.vilela.felipe.api_2025.controller;

import com.vilela.felipe.api_2025.model.dto.DadosAtualizacaoConserto;
import com.vilela.felipe.api_2025.model.dto.DadosConsertoResumo;
import com.vilela.felipe.api_2025.model.dto.DadosDetalhadosConserto;
import com.vilela.felipe.api_2025.model.entity.Conserto;
import com.vilela.felipe.api_2025.repository.ConsertoRepository;
import com.vilela.felipe.api_2025.model.dto.DadosCadastroConserto;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("conserto")
public class ConsertoController {

    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhadosConserto> cadastrar(@RequestBody @Valid DadosCadastroConserto dados, UriComponentsBuilder uriBuilder) {
        var conserto = new Conserto(dados);
        repository.save(conserto);
        var uri = uriBuilder.path("/conserto/{id}").buildAndExpand(conserto.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhadosConserto(conserto));
    }

    @GetMapping
    public ResponseEntity<Page<Conserto>> listar(Pageable pageable){
        return ResponseEntity.ok(repository.findAll(pageable));
    }

    @GetMapping("resumo")
    public ResponseEntity<List<DadosConsertoResumo>> listarResumo(){
        var pagina = repository.findAllByAtivoTrue().stream().map(DadosConsertoResumo::new).toList();
        return ResponseEntity.ok(pagina);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhadosConserto> getConsertoById(@PathVariable Long id){
        Optional<Conserto> consertoOptional = repository.findById(id);

        if (consertoOptional.isPresent()){
            Conserto conserto = consertoOptional.get();
            return ResponseEntity.ok(new DadosDetalhadosConserto(conserto));
        }else {
           return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping
    @Transactional
    public ResponseEntity<DadosDetalhadosConserto> atualizar(@RequestBody @Valid DadosAtualizacaoConserto dados) {
        Optional<Conserto> consertoOptional = repository.findById(dados.id());

        if (consertoOptional.isPresent()) {
            Conserto conserto = consertoOptional.get();
            conserto.atualizarInformacoes(dados);
            return ResponseEntity.ok(new DadosDetalhadosConserto(conserto));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        Optional<Conserto> consertoOptional = repository.findById(id);

        if (consertoOptional.isPresent()) {
            Conserto conserto = consertoOptional.get();
            conserto.excluir();
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
