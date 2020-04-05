package br.com.zolp.estudozolp.converters;

import br.com.zolp.estudozolp.bean.GrupoMedicamento;
import br.com.zolp.estudozolp.entity.TbGrupoMedicamento;
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
