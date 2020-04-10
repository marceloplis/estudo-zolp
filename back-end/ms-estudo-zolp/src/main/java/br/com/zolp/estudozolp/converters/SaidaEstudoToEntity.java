package br.com.zolp.estudozolp.converters;

import br.com.zolp.estudozolp.bean.SaidaEstudo;
import br.com.zolp.estudozolp.entity.TbSaidaEstudo;
import br.com.zolp.estudozolp.util.Eval;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Classe reponsável por efetuar a conversão dos objetos
 * {@link SaidaEstudo} para o objeto {@link TbSaidaEstudo}.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Component
public class SaidaEstudoToEntity implements Converter<SaidaEstudo, TbSaidaEstudo> {

    @Override
    public final TbSaidaEstudo convert(final SaidaEstudo source) {

        TbSaidaEstudo doc = new TbSaidaEstudo();

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

    /**
     * Atualiza o objeto com os dados para update.
     *
     * @param source
     * @return
     */
    public final TbSaidaEstudo populate(final SaidaEstudo source) {

        TbSaidaEstudo doc = new TbSaidaEstudo();

        if(Eval.isNotEmpty(source.getIdSaidaEstudo())) {
            doc.setIdSaidaEstudo(source.getIdSaidaEstudo());
        }

        if(Eval.isNotEmpty(source.getIdPaciente())) {
            doc.setIdPaciente(source.getIdPaciente());
        }

        if(Eval.isNotEmpty(source.getDtInclusao())) {
            doc.setDtInclusao(source.getDtInclusao());
        }

        if(Eval.isNotEmpty(source.getNuVisita())) {
            doc.setNuVisita(source.getNuVisita());
        }

        if(Eval.isNotEmpty(source.getDtSaida())) {
            doc.setDtSaida(source.getDtSaida());
        }

        if(Eval.isNotEmpty(source.getDtOcorrencia())) {
            doc.setDtOcorrencia(source.getDtOcorrencia());
        }

        if(Eval.isNotEmpty(source.getMotivo())) {
            doc.setMotivo(source.getMotivo());
        }

        if(Eval.isNotEmpty(source.getFlEvolucaoObito())) {
            doc.setFlEvolucaoObito(source.getFlEvolucaoObito());
        }

        if(Eval.isNotEmpty(source.getStAprovacao())) {
            doc.setStAprovacao(source.getStAprovacao());
        }

        if(Eval.isNotEmpty(source.getAssinatura())) {
            doc.setAssinatura(source.getAssinatura());
        }

        if(Eval.isNotEmpty(source.getDtAssinatura())) {
            doc.setDtAssinatura(source.getDtAssinatura());
        }

        if(Eval.isNotEmpty(source.getObservacao())) {
            doc.setObservacao(source.getObservacao());
        }

        return doc;
    }
}
