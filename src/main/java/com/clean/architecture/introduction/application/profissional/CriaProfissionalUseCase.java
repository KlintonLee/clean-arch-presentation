package com.clean.architecture.introduction.application.profissional;

import com.clean.architecture.introduction.entity.Profissional;
import com.clean.architecture.introduction.infrastructure.gateway.ProfissionalGateway;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class CriaProfissionalUseCase {

    private final ProfissionalGateway gateway;

    private final ProfissionalValidator validator;

    private final Jedis connection;

    public CriaProfissionalUseCase(ProfissionalGateway gateway, ProfissionalValidator validator) {
        this.gateway = gateway;
        this.validator = validator;
        connection = new JedisPool("localhost", 7000).getResource();
    }

    public Profissional execute(String nome, String cargo, String cpf) {
        ProfissionalValidator.validaNome(nome);
        validator.validaAlgumaCoisa();
        validator.analisaCredito(cpf);

        var profissional = Profissional.newProfissional(nome, cargo, cpf);
        connection.set(profissional.getId(), profissional.toString());
        return profissional;
    }
}
