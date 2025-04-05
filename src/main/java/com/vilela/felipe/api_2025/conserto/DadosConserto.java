package com.vilela.felipe.api_2025.conserto;

import com.vilela.felipe.api_2025.mecanico.DadosMecanico;
import com.vilela.felipe.api_2025.veiculo.DadosVeiculo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosConserto(

        @NotBlank
        @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$")
        String data_entrada,

        @NotBlank
        @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$")
        String data_saida,

        @NotBlank
        @Valid
        DadosMecanico mecanico,

        @NotBlank
        @Valid
        DadosVeiculo veiculo) {
}
