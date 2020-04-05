package br.com.zolp.estudozolp.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Classe responsavel por disponibilizar funcoes utilitarias para
 * manipulacao de valores textuais: String, Char, CharSequence, etc.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
public final class Strings {

    /**
     * Impede criacao de instancias, para utilizacao apenas como static.
     */
    private Strings() {
        super();
    }

    // -------------------------------------------------------------------------

    /**
     * Metodo createStringWithLength.
     *
     * @param length
     * @return
     */
    public static String createStringWithLength(final int length) {
        StringBuilder builder = new StringBuilder();

        for (int index = 0; index < length; index++) {
            builder.append(' ');
        }

        return builder.toString();
    }

    // --- JSON ---------------------------------------------------------------

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
                                                                        MediaType.APPLICATION_JSON.getSubtype(),
                                                                        Charset.forName("utf8"));

    /**
     * Metodo convertObjectToJsonBytes.
     *
     * @param object
     * @return
     * @throws IOException
     */
    public static byte[] convertObjectToJsonBytes(final Object object) throws IOException {
        return getObjectMapper().writeValueAsBytes(object);
    }

    /**
     * Metodo convertObjectToJson.
     *
     * @param object
     * @return
     * @throws IOException
     */
    public static String convertObjectToJson(final Object object) throws IOException {
        return getObjectMapper().writeValueAsString(object);
    }

    /**
     * Metodo convertJsonToObject.
     *
     * @param <T>
     * @param json
     * @param objType
     * @return
     * @throws IOException
     */
    public static <T> T convertJsonToObject(final String json, final Class<T> objType) throws IOException {
        return getObjectMapper().readValue(json, objType);
    }

    /**
     * Metodo toJson.
     *
     * @param pojo
     * @return
     */
    public static String toJson(final Object pojo) {
        String json;
        try {
            if (pojo == null) {
                json = "null";
            } else {
                json = getObjectMapper().enable(SerializationFeature.INDENT_OUTPUT)
                                        .writeValueAsString(pojo);
            }

        } catch (IOException ioe) {
            json = "";
        }

        return json;
    }

    /**
     * Metodo getObjectMapper.
     *
     * @return
     */
    private static ObjectMapper getObjectMapper() {
        final ObjectMapper mapper = new ObjectMapper();

        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL)
              .registerModule(new JavaTimeModule().addSerializer(new LocalDateTimeSerializer()));

        return mapper;
    }

    // --- SQL ----------------------------------------------------------------

    /**
     * Metodo inClause.
     *
     * @param parms
     * @return
     */
    public static String inClause(final Object[] parms) {
        // se nao houver parametros, entao deixa a clausa vazia
        if (Eval.isEmpty(parms)) {
            return "";
        }

        // cria map na clausula in para os parametros fornecidos,
        final StringBuilder clause = new StringBuilder();

        // se os valores forem do tipo string, entao eh preciso delimitar
        if (parms[0] instanceof CharSequence) {
            for (Object o : parms) {
                clause.append("'")
                      .append(o)
                      .append("',");
            }
        } else {
            for (Object o : parms) {
                clause.append(o)
                      .append(",");
            }
        }
        // e ao final, o ultimo ',' eh ignorado
        final int len = clause.length();
        return clause.substring(0, len - 1);
    }

}
