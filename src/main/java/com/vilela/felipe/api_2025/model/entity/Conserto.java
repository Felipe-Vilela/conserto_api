package com.vilela.felipe.api_2025.model.entity;

import com.vilela.felipe.api_2025.model.dto.DadosAtualizacaoConserto;
import com.vilela.felipe.api_2025.model.dto.DadosCadastroConserto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "consertos")
@Entity(name = "Conserto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conserto {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String dataEntrada;
    private String dataSaida;

    @Embedded
    private Mecanico mecanico;

    @Embedded
    private Veiculo veiculo;
    private Boolean ativo;

    public Conserto (DadosCadastroConserto dados){
        this.ativo = true;
        this.dataEntrada = dados.dataEntrada();
        this.dataSaida = dados.dataSaida();
        this.mecanico = new Mecanico(dados.mecanico());
        this.veiculo = new Veiculo(dados.veiculo());
    }

    public void excluir(){
        this.ativo = false;
    }

    public void atualizarInformacoes(DadosAtualizacaoConserto dados) {
        if (dados.dataSaida() != null){
            this.dataSaida = dados.dataSaida();
        }

        if (dados.mecanico() != null){
            this.mecanico.atualizarInformacoes(dados.mecanico());
        }

    }
}
