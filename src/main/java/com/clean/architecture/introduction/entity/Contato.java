package com.clean.architecture.introduction.entity;

import java.util.UUID;

public class Contato {

    private String id;
    private String nome;
    private String email;
    private String telefone;
    private String idProfissional;

    private Contato(
            final String id,
            final String nome,
            final String email,
            final String telefone
    ) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public static Contato newContato(
            final String nome,
            final String email,
            final String telefone
    ) {
        final var id = UUID.randomUUID().toString();
        return new Contato(id, nome, email, telefone);
    }

    public Contato update(
            final String nome,
            final String email,
            final String telefone,
            final String idProfissional
    ) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.idProfissional = idProfissional;
        return this;
    }
}
