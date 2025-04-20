package com.vilela.felipe.api_2025.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosVeiculo(

        @NotBlank(message = "É obrigatório informar o campo 'marca'.")
        String marca,

        @NotBlank(message = "É obrigatório informar o campo 'modelo'.")
        String modelo,

        @NotBlank(message = "É obrigatório informar o campo 'ano'.")
        @Pattern(regexp = "^\\d{4}$", message = "O campo 'ano' deve ter 4 números")
        String ano,

        String cor) {
}
