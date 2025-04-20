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

    public void atualizarInformacoes(DadosMecanico dadosMecanico) {
        if (dadosMecanico.nome() != null){
            this.nome = dadosMecanico.nome();
        }

        if (dadosMecanico.anosXp() != null){
            this.anosXp = dadosMecanico.anosXp();
        }
    }
}
