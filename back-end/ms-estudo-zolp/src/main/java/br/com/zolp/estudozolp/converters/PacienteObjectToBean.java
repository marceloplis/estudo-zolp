package br.com.zolp.estudozolp.converters;

import br.com.zolp.estudozolp.bean.Paciente;
import br.com.zolp.estudozolp.util.Numbers;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Classe reponsável por efetuar a conversão dos objetos da consulta
 * de usuarios para o objeto {@link Paciente}.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Component
public class PacienteObjectToBean implements Converter<Object[], Paciente> {

    private static final int
        CAMPO_1 = 0,
        CAMPO_2 = 1,

        // Numero de colunas da query executada:
        SQL_CONT_COLUNAS = 2;

    @Override
    public final Paciente convert(final Object[] source) {

        final Paciente doc = new Paciente();

        if (source != null && source.length >= SQL_CONT_COLUNAS) {

            if (source[CAMPO_1] != null) {
                doc.setIdPaciente(Numbers.longValue(source[CAMPO_1]));
            }

            if (source[CAMPO_2] != null) {
                doc.setNome((String) source[CAMPO_2]);
            }

        }

        return doc;
    }

}