package com.clean.architecture.introduction.infrastructure.gateway;

public interface PagamentosGateway {
    Status checkout(Metadata metadata);

    class Metadata {
        private final String id;
        private final String algumaCoisa;
        private final String outraCoisa;

        public Metadata(String id, String algumaCoisa, String outraCoisa) {
            this.id = id;
            this.algumaCoisa = algumaCoisa;
            this.outraCoisa = outraCoisa;
        }
    }

    enum Status {
        PENDENTE,
        APROVADO,
        REJEITADO
    }
}


