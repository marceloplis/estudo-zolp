package br.com.zolp.estudozolp.converters;

import br.com.zolp.estudozolp.bean.SaidaEstudo;
import br.com.zolp.estudozolp.entity.TbSaidaEstudo;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Classe reponsável por efetuar a conversão dos objetos da consulta dos Usuarios
 * {@link TbSaidaEstudo} para o objeto {@link SaidaEstudo}.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Component
public class SaidaEstudoToBean implements Converter<TbSaidaEstudo, SaidaEstudo> {

    @Override
    public final SaidaEstudo convert(final TbSaidaEstudo source) {

        SaidaEstudo doc = new SaidaEstudo();

        if (source != null) {

            doc.setIdSaidaEstudo(source.getIdSaidaEstudo());
            doc.setIdPaciente(source.getIdPaciente());
            doc.setDtInclusao(source.getDtInclusao());
            doc.setNuVisita(source.getNuVisita());
            doc.setDtSaida(source.getDtSaida());
            doc.setDtOcorrencia(source.getDtOcorrencia());
            doc.setMotivo(source.getMotivo());
            doc.setFlEvolucaoObito(source.getFlEvolucaoObito());
            doc.setStAprovacao(source.getStAprovacao());
            doc.setAssinatura(source.getAssinatura());
            doc.setDtAssinatura(source.getDtAssinatura());
            doc.setObservacao(source.getObservacao());

        }

        return doc;
    }

}
