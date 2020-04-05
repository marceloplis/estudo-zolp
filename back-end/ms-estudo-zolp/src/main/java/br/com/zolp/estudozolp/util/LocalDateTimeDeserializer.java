package br.com.zolp.estudozolp.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Classe responsavel em converter String to LocalDateTime.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
public class LocalDateTimeDeserializer extends StdDeserializer<LocalDateTime> {

    private static final long serialVersionUID = -6096202699623471019L;

    /**
     * Construtor.
     */
    protected LocalDateTimeDeserializer() {
        super(LocalDateTime.class);
    }

    /**
     * Metodo para converter String to LocalDateTime.
     *
     * @param parser parser
     * @param context context
     * @return LocalDateTime
     * @throws IOException IOException
     */
    @Override
    public final LocalDateTime deserialize(final JsonParser parser, final DeserializationContext context)
            throws IOException {
        return LocalDateTime.parse(parser.readValueAs(String.class));
    }
}
