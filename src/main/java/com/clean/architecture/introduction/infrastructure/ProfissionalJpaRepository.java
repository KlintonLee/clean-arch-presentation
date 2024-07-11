package com.clean.architecture.introduction.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfissionalJpaRepository extends JpaRepository<ProfissionalJpa, String> {
}
