package br.com.zolp.estudozolp.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDate;

/**
 * Classe responsavel em converter String to LocalDate.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
public class LocalDateDeserializer extends StdDeserializer<LocalDate> {

    private static final long serialVersionUID = 293000552067343067L;

    /**
     * Construtor.
     */
    protected LocalDateDeserializer() {
        super(LocalDate.class);
    }

    /**
     * Metodo para converter String to LocalDate.
     *
     * @param parser parser
     * @param context context
     * @return LocalDate
     * @throws IOException IOException
     */
    @Override
    public final LocalDate deserialize(final JsonParser parser, final DeserializationContext context)
            throws IOException {
        return LocalDate.parse(parser.readValueAs(String.class));
    }
}
