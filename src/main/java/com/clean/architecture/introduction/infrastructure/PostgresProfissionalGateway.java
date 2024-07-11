package com.clean.architecture.introduction.infrastructure;

import com.clean.architecture.introduction.entity.Profissional;
import com.clean.architecture.introduction.infrastructure.gateway.ProfissionalGateway;
import org.springframework.stereotype.Component;

import java.util.Optional;

//@Component
public class PostgresProfissionalGateway implements ProfissionalGateway {

    private final ProfissionalJpaRepository repository;

    public PostgresProfissionalGateway(ProfissionalJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Profissional create(Profissional profissional) {
        return save(profissional);
    }

    @Override
    public Optional<Profissional> findById(String id) {
        return repository.findById(id).map(ProfissionalJpa::toProfissional);
    }

    @Override
    public Profissional update(Profissional profissional) {
        return save(profissional);
    }

    @Override
    public boolean existsById(String id) {
        return repository.existsById(id);
    }

    private Profissional save(Profissional profissional) {
        return repository.save(ProfissionalJpa.from(profissional)).toProfissional();
    }
}
