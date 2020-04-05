package br.com.zolp.estudozolp.converters;

import br.com.zolp.estudozolp.bean.AuditoriaEstudo;
import br.com.zolp.estudozolp.entity.TbAuditoriaEstudo;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Classe reponsável por efetuar a conversão dos objetos da consulta
 * {@link TbAuditoriaEstudo} para o objeto {@link AuditoriaEstudo}.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Component
public class AuditoriaEstudoToBean implements Converter<TbAuditoriaEstudo, AuditoriaEstudo> {

    @Override
    public final AuditoriaEstudo convert(final TbAuditoriaEstudo source) {

        AuditoriaEstudo doc = new AuditoriaEstudo();

        if (source != null) {

            doc.setIdAuditoriaEstudo(source.getIdAuditoriaEstudo());
            doc.setUsername(source.getUsername());
            doc.setDtModificacao(source.getDtModificacao());
            doc.setTpModificacao(source.getTpModificacao());
            doc.setDsModificacao(source.getDsModificacao());
            doc.setTpEntidade(source.getTpEntidade());
            doc.setIdPaciente(source.getIdPaciente());

        }

        return doc;
    }

}
