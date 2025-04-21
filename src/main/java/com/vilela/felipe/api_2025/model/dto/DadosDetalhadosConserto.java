package com.vilela.felipe.api_2025.model.dto;

import com.vilela.felipe.api_2025.model.entity.Conserto;
import com.vilela.felipe.api_2025.model.entity.Mecanico;
import com.vilela.felipe.api_2025.model.entity.Veiculo;

public record DadosDetalhadosConserto(Long id, String dataEntrada, String dataSaida, Mecanico mecanico, Veiculo veiculo) {

    public DadosDetalhadosConserto(Conserto conserto){
        this(conserto.getId(), conserto.getDataEntrada(), conserto.getDataSaida(),
                conserto.getMecanico(), conserto.getVeiculo());
    }
}