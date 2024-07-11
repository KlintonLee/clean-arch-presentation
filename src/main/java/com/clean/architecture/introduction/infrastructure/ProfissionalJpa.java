package com.clean.architecture.introduction.infrastructure;

import com.clean.architecture.introduction.entity.Profissional;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "Profissional")
@Table(name = "profissionais")
public class ProfissionalJpa {

    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "cargo", nullable = false)
    private String cargo;
    @Column(name = "cpf", nullable = false)
    private String cpf;
    @Column(name = "ativo", nullable = false)
    private boolean ativo;

    public ProfissionalJpa() {
    }

    private ProfissionalJpa(
            final String id,
            final String nome,
            final String cargo,
            final String cpf,
            final boolean ativo
    ) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.cpf = cpf;
        this.ativo = ativo;
    }

    public static ProfissionalJpa from(Profissional profissional) {
        return new ProfissionalJpa(
                profissional.getId(),
                profissional.getNome(),
                profissional.getCargo(),
                profissional.getCpf(),
                profissional.isAtivo()
        );
    }

    public Profissional toProfissional() {
        return Profissional.of(id, nome, cargo, cpf, ativo);
    }
}
