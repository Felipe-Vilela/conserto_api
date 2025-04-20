package com.vilela.felipe.api_2025.model.entity;

import com.vilela.felipe.api_2025.model.dto.DadosMecanico;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mecanico {
    private String nome;
    private String anosXp;

    public Mecanico(DadosMecanico dados){
        this.nome = dados.nome();
        this.anosXp = dados.anosXp();
    }
}
