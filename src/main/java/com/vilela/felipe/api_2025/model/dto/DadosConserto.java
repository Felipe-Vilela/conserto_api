package com.vilela.felipe.api_2025.model.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosConserto(

        @NotBlank(message = "É obrigatório informar o campo 'data-entrada'.")
        @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$" , message = "A data deve estar no formato DD/MM/AAAA.")
        String data_entrada,

        @NotBlank(message = "É obrigatório informar o campo 'data-saida'.")
        @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$" , message = "A data deve estar no formato DD/MM/AAAA.")
        String data_saida,

        @NotNull
        @Valid
        DadosMecanico mecanico,

        @NotNull
        @Valid
        DadosVeiculo veiculo) {
}
