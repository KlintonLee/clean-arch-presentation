package com.clean.architecture.introduction.infrastructure.gateway;

import com.clean.architecture.introduction.entity.Profissional;

import java.util.Optional;

public interface ProfissionalGateway {

    Profissional create(Profissional profissional);

    Optional<Profissional> findById(String id);

    Profissional update(Profissional profissional);

    boolean existsById(String id);

}
