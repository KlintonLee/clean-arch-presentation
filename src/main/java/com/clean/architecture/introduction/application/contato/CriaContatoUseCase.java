package com.clean.architecture.introduction.application.contato;

import com.clean.architecture.introduction.entity.Contato;
import com.clean.architecture.introduction.infrastructure.gateway.ContatoGateway;
import com.clean.architecture.introduction.infrastructure.gateway.ProfissionalGateway;

public class CriaContatoUseCase {

    private final ContatoGateway contatoGateway;

    private final ProfissionalGateway profissionalGateway;

    public CriaContatoUseCase(ContatoGateway contatoGateway, ProfissionalGateway profissionalGateway) {
        this.contatoGateway = contatoGateway;
        this.profissionalGateway = profissionalGateway;
    }

    public void execute(String nome, String email, String telefone, String idProfissional) {
        if (profissionalGateway.existsById(idProfissional)) {
            var contato = Contato.newContato(nome, email, telefone);
            // Validações
            contatoGateway.create(contato);
        }
    }
}
