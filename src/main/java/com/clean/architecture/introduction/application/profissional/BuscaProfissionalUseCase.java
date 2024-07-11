package com.clean.architecture.introduction.application.profissional;

import com.clean.architecture.introduction.entity.Profissional;
import com.clean.architecture.introduction.infrastructure.gateway.ProfissionalGateway;

public class BuscaProfissionalUseCase {

    private final ProfissionalGateway gateway;

    public BuscaProfissionalUseCase(ProfissionalGateway gateway) {
        this.gateway = gateway;
    }

    public Profissional execute(String id) {
        return gateway.findById(id).orElseThrow();
    }
}
