package br.com.zolp.estudozolp.converters;

import br.com.zolp.estudozolp.bean.Medicamento;
import br.com.zolp.estudozolp.entity.TbMedicamento;
import br.com.zolp.estudozolp.util.Eval;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Classe reponsável por efetuar a conversão dos objetos
 * {@link Medicamento} para o objeto {@link TbMedicamento}.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Component
public class MedicamentoToEntity implements Converter<Medicamento, TbMedicamento> {

    @Override
    public final TbMedicamento convert(final Medicamento source) {

        TbMedicamento doc = new TbMedicamento();

        if (source != null) {

            doc.setIdMedicamento(source.getIdMedicamento());
            doc.setIdGrupoMedicamento(source.getIdGrupoMedicamento());
            doc.setDsMedicamento(source.getDsMedicamento());

        }

        return doc;
    }

    /**
     * Atualiza o objeto com os dados para update.
     *
     * @param source
     * @return
     */
    public final TbMedicamento populate(final Medicamento source) {

        TbMedicamento doc = new TbMedicamento();

        if(Eval.isNotEmpty(source.getIdMedicamento())) {
            doc.setIdMedicamento(source.getIdMedicamento());
        }

        if(Eval.isNotEmpty(source.getIdGrupoMedicamento())) {
            doc.setIdGrupoMedicamento(source.getIdGrupoMedicamento());
        }

        if(Eval.isNotEmpty(source.getDsMedicamento())) {
            doc.setDsMedicamento(source.getDsMedicamento());
        }

        return doc;
    }

}
