package com.clean.architecture.introduction.application.contato;

import com.clean.architecture.introduction.application.profissional.BuscaProfissionalUseCase;
import com.clean.architecture.introduction.entity.Contato;
import com.clean.architecture.introduction.infrastructure.gateway.ContatoGateway;

public class AltCriaContatoUseCase {

    private final ContatoGateway contatoGateway;

    private final BuscaProfissionalUseCase buscaProfissionalUseCase;

    public AltCriaContatoUseCase(ContatoGateway contatoGateway, BuscaProfissionalUseCase buscaProfissionalUseCase) {
        this.contatoGateway = contatoGateway;
        this.buscaProfissionalUseCase = buscaProfissionalUseCase;
    }

    public void execute(String nome, String email, String telefone, String idProfissional) {
        buscaProfissionalUseCase.execute(idProfissional);

        var contato = Contato.newContato(nome, email, telefone);
        // Validações
        contatoGateway.create(contato);
    }
}
