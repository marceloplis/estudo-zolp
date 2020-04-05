package br.com.zolp.estudozolp.converters;

import br.com.zolp.estudozolp.bean.AuditoriaEstudo;
import br.com.zolp.estudozolp.util.Numbers;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Classe reponsável por efetuar a conversão dos objetos de consulta
 * para o objeto {@link AuditoriaEstudo}.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Component
public class AuditoriaEstudoObjectToBean implements Converter<Object[], AuditoriaEstudo> {

    private static final int
        CAMPO_1 = 0,
        CAMPO_2 = 1,

        // Numero de colunas da query executada:
        SQL_CONT_COLUNAS = 2;

    @Override
    public final AuditoriaEstudo convert(final Object[] source) {

        final AuditoriaEstudo doc = new AuditoriaEstudo();

        if (source != null && source.length >= SQL_CONT_COLUNAS) {

            if (source[CAMPO_1] != null) {
                doc.setIdAuditoriaEstudo(Numbers.longValue(source[CAMPO_1]));
            }

            if (source[CAMPO_2] != null) {
                doc.setDsModificacao((String) source[CAMPO_2]);
            }

        }

        return doc;
    }

}