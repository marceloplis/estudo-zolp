package br.com.grupostp.authzero.types;

/**
 * Enumerator responsável por armazenar as constantes utilizadas
 * pelos tipos de dados do dominio da aplicacao.
 *
 *
 */
public final class DomainConstants {

    /**
     * Impede criacao de instancias, para utilizacao apenas como static.
     */
    private DomainConstants() {
        super();
    }

    // --- STATIC -------------------------------------------------------------

    // Constantes relacionadas aos dominios de valores:
    static final int

        // Flag Aprovado
        NAO_APROVADO = 0,
        APROVADO = 1,

        // Classes dos dominios (tipos):
        CLASSE_TIPO_ORIGEM_AUTHZERO = 230,

        // Tipo Origem
        AUTHZERO = 1,
        RESERVA = 2;

}
