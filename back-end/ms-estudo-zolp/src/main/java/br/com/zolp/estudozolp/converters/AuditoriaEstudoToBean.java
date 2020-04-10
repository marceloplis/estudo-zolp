package br.com.zolp.estudozolp.converters;

import br.com.zolp.estudozolp.bean.AuditoriaEstudo;
import br.com.zolp.estudozolp.entity.TbAuditoriaEstudo;
import br.com.zolp.estudozolp.util.Numbers;
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

    private static final int
            CAMPO_1 = 0,
            CAMPO_2 = 1,

    // Numero de colunas da query executada:
    SQL_CONT_COLUNAS = 2;

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
