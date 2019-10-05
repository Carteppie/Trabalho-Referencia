package br.es.senac.trabalho_referencia.model;

public enum Status {
    ENVIADA{
        @Override
        public String toString(){
            return "Enviada";
        }
    },
    NAOENVIADA{
        @Override
        public String toString(){
            return "Não Enviada";
        }
    }
}
