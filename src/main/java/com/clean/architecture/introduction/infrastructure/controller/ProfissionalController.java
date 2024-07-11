package com.clean.architecture.introduction.infrastructure.controller;

import com.clean.architecture.introduction.application.profissional.CriaProfissionalUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("profissionais")
public class ProfissionalController {

    private final CriaProfissionalUseCase criaProfissionalUseCase;

    public ProfissionalController(
        CriaProfissionalUseCase criaProfissionalUseCase
    ) {
        this.criaProfissionalUseCase = criaProfissionalUseCase;
    }

    @PostMapping
    public ResponseEntity<String> criaProfissional(@RequestBody ProfissionalDto dto) {
        var profissional = criaProfissionalUseCase.execute(
            dto.nome(),
            dto.cargo(),
            dto.cpf()
        );

        return ResponseEntity
                .created(URI.create("/profissionais/" + profissional.getId()))
                .body(profissional.getId());
    }

    // curl -X POST http://localhost:8080/profissionais -d '{"nome": "Fulano", "cargo": "engenheiro", "cpf": "123456789"}' -H 'Content-Type: application/json'
}
