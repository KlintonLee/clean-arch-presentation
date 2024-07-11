package com.clean.architecture.introduction.infrastructure.gateway;

import com.clean.architecture.introduction.entity.Contato;

import java.util.List;
import java.util.Optional;

public interface ContatoGateway {

    Contato create(Contato contato);

    Optional<Contato> findById(String id);

    Contato update(Contato contato);

    List<Contato> findAllByProfissional(String idProfissional);

    boolean existsById(String id);

    void deleteById(String id);

}
