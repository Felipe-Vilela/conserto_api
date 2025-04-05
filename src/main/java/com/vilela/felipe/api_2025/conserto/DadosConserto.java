package com.vilela.felipe.api_2025.conserto;

import com.vilela.felipe.api_2025.mecanico.DadosMecanico;
import com.vilela.felipe.api_2025.veiculo.DadosVeiculo;

public record DadosConserto(
        String data_entrada, String data_saida, DadosMecanico mecanico, DadosVeiculo veiculo) {
}
