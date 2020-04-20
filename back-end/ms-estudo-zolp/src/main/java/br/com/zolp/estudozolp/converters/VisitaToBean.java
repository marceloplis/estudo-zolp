package br.com.zolp.estudozolp.converters;

import br.com.zolp.estudozolp.bean.Visita;
import br.com.zolp.estudozolp.entity.TbVisita;
import br.com.zolp.estudozolp.util.Numbers;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Classe reponsável por efetuar a conversão dos objetos de
 * {@link TbVisita} para o objeto {@link Visita}.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Component
public class VisitaToBean implements Converter<TbVisita, Visita> {

    private static final int
            CAMPO_1 = 0,
            CAMPO_2 = 1,

    // Numero de colunas da query executada:
    SQL_CONT_COLUNAS = 2;

    public final Visita convert(final Object[] source) {

        final Visita doc = new Visita();

        if (source != null && source.length >= SQL_CONT_COLUNAS) {

            if (source[CAMPO_1] != null) {
                doc.setIdVisita(Numbers.longValue(source[CAMPO_1]));
            }

            if (source[CAMPO_2] != null) {
                doc.setIdPaciente(Numbers.longValue(source[CAMPO_2]));
            }

        }

        return doc;
    }

    @Override
    public final Visita convert(final TbVisita source) {

        Visita doc = new Visita();

        if (source != null) {

            doc.setIdVisita(source.getIdVisita());
            doc.setNuVisita(source.getNuVisita());
            doc.setIdPaciente(source.getIdPaciente());
            doc.setDtInclusao(source.getDtInclusao());
            doc.setDtRealizacao(source.getDtRealizacao());
            doc.setAssinaturaAprovador(source.getAssinaturaAprovador());
            doc.setDtAssinaturaAprovacao(source.getDtAssinaturaAprovacao());
            doc.setStAprovacao(source.getStAprovacao());

        }

        return doc;
    }

}
