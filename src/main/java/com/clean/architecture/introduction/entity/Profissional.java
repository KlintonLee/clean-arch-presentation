package com.clean.architecture.introduction.entity;

import java.util.UUID;

public class Profissional {

    private final String id;
    private String nome;
    private String cargo;
    private final String cpf;
    private boolean ativo;

    private Profissional(
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

    public static Profissional newProfissional(
            final String nome,
            final String cargo,
            final String cpf
    ) {
        final var id = UUID.randomUUID().toString();
        final var ativo = true;
        return new Profissional(id, nome, cargo, cpf, ativo);
    }

    public static Profissional of(
            final String id,
            final String nome,
            final String cargo,
            final String cpf,
            final boolean ativo
    ) {
        return new Profissional(id, nome, cargo, cpf, ativo);
    }

    public Profissional update(
            final String nome,
            final String cargo
    ) {
        this.nome = nome;
        this.cargo = cargo;
        return this;
    }

    public Profissional ativar() {
        this.ativo = true;
        return this;
    }

    public Profissional desativar() {
        this.ativo = false;
        return this;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public String getCpf() {
        return cpf;
    }

    public boolean isAtivo() {
        return ativo;
    }
}
