package com.clean.architecture.introduction.application.profissional;

import com.clean.architecture.introduction.infrastructure.gateway.CreditoGateway;

public class ProfissionalValidator {

    private CreditoGateway creditoGateway;

    public ProfissionalValidator(CreditoGateway creditoGateway) {
        this.creditoGateway = creditoGateway;
    }

    public static void validaNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
    }

    public void validaAlgumaCoisa() {
        System.out.println("Validando alguma coisa");
    }

    public boolean analisaCredito(String cpf) {
        return creditoGateway.autorizado(cpf);
    }
}
