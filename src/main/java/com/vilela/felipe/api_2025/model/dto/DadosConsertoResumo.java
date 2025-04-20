package com.vilela.felipe.api_2025.model.dto;

import com.vilela.felipe.api_2025.model.entity.Conserto;

public record DadosConsertoResumo(String dataEntrada, String dataSaida, String nome, String marca, String modelo) {

    public DadosConsertoResumo(Conserto conserto) {
        this(conserto.getDataEntrada(), conserto.getDataSaida(), conserto.getMecanico().getNome(),
                conserto.getVeiculo().getMarca(), conserto.getVeiculo().getModelo());
    }
}
