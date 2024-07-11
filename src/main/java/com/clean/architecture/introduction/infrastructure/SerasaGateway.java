package com.clean.architecture.introduction.infrastructure;

import com.clean.architecture.introduction.infrastructure.gateway.CreditoGateway;
import org.springframework.stereotype.Component;

@Component
public class SerasaGateway implements CreditoGateway {
    @Override
    public boolean autorizado(String cpf) {
        return cpf.contains("1");
    }
}
