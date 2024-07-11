package com.clean.architecture.introduction.application.contato;

import com.clean.architecture.introduction.application.profissional.BuscaProfissionalUseCase;

public class ContatoService {

    private final CriaContatoUseCase criaContatoUseCase;

    private final BuscaProfissionalUseCase buscaProfissionalUseCase;

    public ContatoService(
            CriaContatoUseCase criaContatoUseCase,
            BuscaProfissionalUseCase buscaProfissionalUseCase
    ) {
        this.criaContatoUseCase = criaContatoUseCase;
        this.buscaProfissionalUseCase = buscaProfissionalUseCase;
    }

    public void criaContato(String nome, String email, String telefone, String idProfissional) {
        buscaProfissionalUseCase.execute(idProfissional);
        criaContatoUseCase.execute(nome, email, telefone, idProfissional);
    }
}
