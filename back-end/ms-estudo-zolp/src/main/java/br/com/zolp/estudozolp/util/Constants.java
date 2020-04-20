package br.com.zolp.estudozolp.util;

import org.springframework.http.MediaType;

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


    // Constantes de MediaType
    public static final MediaType
        MT_APP_CSV = MediaType.parseMediaType("application/csv");



}
