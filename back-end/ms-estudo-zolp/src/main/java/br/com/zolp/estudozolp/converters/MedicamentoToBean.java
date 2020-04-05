package br.com.zolp.estudozolp.converters;

import br.com.zolp.estudozolp.bean.Medicamento;
import br.com.zolp.estudozolp.entity.TbMedicamento;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Classe reponsável por efetuar a conversão dos objetos
 * {@link TbMedicamento} para o objeto {@link Medicamento}.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Component
public class MedicamentoToBean implements Converter<TbMedicamento, Medicamento> {

    @Override
    public final Medicamento convert(final TbMedicamento source) {

        Medicamento doc = new Medicamento();

        if (source != null) {

            doc.setIdMedicamento(source.getIdMedicamento());
            doc.setIdGrupoMedicamento(source.getIdGrupoMedicamento());
            doc.setDsMedicamento(source.getDsMedicamento());

        }

        return doc;
    }

}
