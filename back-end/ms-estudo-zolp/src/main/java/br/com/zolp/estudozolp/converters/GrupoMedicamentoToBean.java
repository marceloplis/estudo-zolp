package br.com.zolp.estudozolp.converters;

import br.com.zolp.estudozolp.bean.GrupoMedicamento;
import br.com.zolp.estudozolp.entity.TbGrupoMedicamento;
import br.com.zolp.estudozolp.util.Numbers;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Classe reponsável por efetuar a conversão dos objetos
 * {@link TbGrupoMedicamento} para o objeto {@link GrupoMedicamento}.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Component
public class GrupoMedicamentoToBean implements Converter<TbGrupoMedicamento, GrupoMedicamento> {

    private static final int
            CAMPO_1 = 0,
            CAMPO_2 = 1,

    // Numero de colunas da query executada:
    SQL_CONT_COLUNAS = 2;

    public final GrupoMedicamento convert(final Object[] source) {

        final GrupoMedicamento doc = new GrupoMedicamento();

        if (source != null && source.length >= SQL_CONT_COLUNAS) {

            if (source[CAMPO_1] != null) {
                doc.setIdGrupoMedicamento(Numbers.longValue(source[CAMPO_1]));
            }

            if (source[CAMPO_2] != null) {
                doc.setDsGrupoMedicamento((String) source[CAMPO_2]);
            }

        }

        return doc;
    }

    @Override
    public final GrupoMedicamento convert(final TbGrupoMedicamento source) {

        GrupoMedicamento doc = new GrupoMedicamento();

        if (source != null) {

            doc.setIdGrupoMedicamento(source.getIdGrupoMedicamento());
            doc.setDsGrupoMedicamento(source.getDsGrupoMedicamento());

        }

        return doc;
    }

}
