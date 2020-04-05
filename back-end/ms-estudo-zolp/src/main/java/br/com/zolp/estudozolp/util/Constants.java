package br.com.zolp.estudozolp.util;

/**
 * Enumerator responsável por armazenar as constantes utilizadas na aplicacao.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
public final class Constants {

    /**
     * Impede criacao de instancias, para utilizacao apenas como static.
     */
    private Constants() {
        super();
    }

    // -------------------------------------------------------------------------

    public static final String CONFIG_FILE_NAME = "ms-estudo-zolp-config.properties";

    public static final String USER_DIR = "user.dir";

    public static final String PASTA_LOGS = "logs";
    public static final String STR_UUID = "UUID::";



    // Constantes numericas diversas:
    public static final int
        SUCESSO = 0,
        ERRO = -1;

    // Constantes de cartoes
    public static final String
            CARTAO_AMEX = "100001",
            CARTAO_ELO = "100001000",
            CARTAO_HIPERCARD = "100002",
            CARTAO_MASTERCARD = "100003",
            CARTAO_VISA = "100004";



}
