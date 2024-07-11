package com.clean.architecture.introduction.infrastructure.config;

import com.clean.architecture.introduction.application.profissional.CriaProfissionalUseCase;
import com.clean.architecture.introduction.application.profissional.ProfissionalValidator;
import com.clean.architecture.introduction.infrastructure.gateway.CreditoGateway;
import com.clean.architecture.introduction.infrastructure.gateway.ProfissionalGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProfissionalUseCaseConfig {

    private final ProfissionalGateway profissionalGateway;

    private final ProfissionalValidator profissionalValidator;

    public ProfissionalUseCaseConfig(ProfissionalGateway profissionalGateway, CreditoGateway creditoGateway) {
        this.profissionalGateway = profissionalGateway;
        this.profissionalValidator = new ProfissionalValidator(creditoGateway);
    }

    @Bean
    public CriaProfissionalUseCase criaProfissionalUseCase() {
        return new CriaProfissionalUseCase(profissionalGateway, profissionalValidator);
    }
}
