package br.com.zolp.estudozolp.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Classe responsavel em converter LocalDateTime to String.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
public class LocalDateTimeSerializer extends StdSerializer<LocalDateTime> {

    private static final long serialVersionUID = 7438717554953798981L;

    /**
     * Construtor.
     */
    public LocalDateTimeSerializer() {
        super(LocalDateTime.class);
    }

    /**
     * Metodo para converter LocalDateTime to String.
     *
     * @param value valor
     * @param generator generator
     * @param provider provider
     * @throws IOException IOException
     */
    @Override
    public final void serialize(final LocalDateTime value,
                                final JsonGenerator generator,
                                final SerializerProvider provider) throws IOException {
        generator.writeString(value.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    }
}
