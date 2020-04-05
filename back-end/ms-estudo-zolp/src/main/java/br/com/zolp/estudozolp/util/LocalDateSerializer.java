package br.com.zolp.estudozolp.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Classe responsavel em converter LocalDate to String.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
public class LocalDateSerializer extends StdSerializer<LocalDate> {

    private static final long serialVersionUID = -1207276404202108735L;

    /**
     * Construtor.
     */
    public LocalDateSerializer() {
        super(LocalDate.class);
        }

    /**
     * Metodo para converter LocalDate to String.
     *
     * @param value valor
     * @param generator generator
     * @param provider provider
     * @throws IOException IOException
     */
    @Override
    public final void serialize(final LocalDate value,
                                final JsonGenerator generator,
                                final SerializerProvider provider) throws IOException {
        generator.writeString(value.format(DateTimeFormatter.ISO_LOCAL_DATE));
        }
}
