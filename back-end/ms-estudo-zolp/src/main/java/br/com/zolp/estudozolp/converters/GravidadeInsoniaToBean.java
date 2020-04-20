package br.com.zolp.estudozolp.converters;

import br.com.zolp.estudozolp.bean.GravidadeInsonia;
import br.com.zolp.estudozolp.entity.TbGravidadeInsonia;
import br.com.zolp.estudozolp.util.Numbers;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Classe reponsável por efetuar a conversão do objeto
 * {@link TbGravidadeInsonia} para o objeto {@link GravidadeInsonia}.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Component
public class GravidadeInsoniaToBean implements Converter<TbGravidadeInsonia, GravidadeInsonia> {

    private static final int
            CAMPO_1 = 0,
            CAMPO_2 = 1,

    // Numero de colunas da query executada:
    SQL_CONT_COLUNAS = 2;

    public final GravidadeInsonia convert(final Object[] source) {

        final GravidadeInsonia doc = new GravidadeInsonia();

        if (source != null && source.length >= SQL_CONT_COLUNAS) {

            if (source[CAMPO_1] != null) {
                doc.setIdGravidadeInsonia(Numbers.longValue(source[CAMPO_1]));
            }

            if (source[CAMPO_2] != null) {
                doc.setIdPaciente(Numbers.longValue(source[CAMPO_2]));
            }

        }

        return doc;
    }

    @Override
    public final GravidadeInsonia convert(final TbGravidadeInsonia source) {

        GravidadeInsonia doc = new GravidadeInsonia();

        if (source != null) {

            doc.setIdGravidadeInsonia(source.getIdGravidadeInsonia());
            doc.setIdPaciente(source.getIdPaciente());
            doc.setGravidadeInsonia(source.getGravidadeInsonia());
            doc.setTipoGravidadeInsonia(source.getTipoGravidadeInsonia());
            doc.setSatisfacaoPadraoSono(source.getSatisfacaoPadraoSono());
            doc.setInterferenciaAtividadeDiaria(source.getInterferenciaAtividadeDiaria());
            doc.setPercepcaoExterna(source.getPercepcaoExterna());
            doc.setNivelPreocupacao(source.getNivelPreocupacao());

        }

        return doc;
    }

}
