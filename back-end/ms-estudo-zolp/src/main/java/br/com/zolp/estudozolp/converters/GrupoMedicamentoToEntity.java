package br.com.zolp.estudozolp.converters;

import br.com.zolp.estudozolp.bean.GrupoMedicamento;
import br.com.zolp.estudozolp.entity.TbGrupoMedicamento;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Classe reponsável por efetuar a conversão dos objetos da consulta dos Usuarios
 * {@link GrupoMedicamento} para o objeto {@link TbGrupoMedicamento}.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Component
public class GrupoMedicamentoToEntity implements Converter<GrupoMedicamento, TbGrupoMedicamento> {

    @Override
    public final TbGrupoMedicamento convert(final GrupoMedicamento source) {

        TbGrupoMedicamento doc = new TbGrupoMedicamento();

        if (source != null) {

            doc.setIdGrupoMedicamento(source.getIdGrupoMedicamento());
            doc.setDsGrupoMedicamento(source.getDsGrupoMedicamento());

        }

        return doc;
    }

}
