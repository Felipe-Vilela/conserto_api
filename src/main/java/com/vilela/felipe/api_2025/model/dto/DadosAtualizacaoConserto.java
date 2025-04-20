package com.vilela.felipe.api_2025.model.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoConserto(
        @NotNull
        Long id,
        String dataSaida,
        DadosMecanico mecanico) { }
