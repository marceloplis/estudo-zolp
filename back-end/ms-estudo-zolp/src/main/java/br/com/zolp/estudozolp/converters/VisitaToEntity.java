package br.com.zolp.estudozolp.converters;

import br.com.zolp.estudozolp.bean.Visita;
import br.com.zolp.estudozolp.entity.TbVisita;
import br.com.zolp.estudozolp.util.Eval;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Classe reponsável por efetuar a conversão dos objetos
 * {@link Visita} para o objeto {@link TbVisita}.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Component
public class VisitaToEntity implements Converter<Visita, TbVisita> {

    @Override
    public final TbVisita convert(final Visita source) {

        TbVisita doc = new TbVisita();

        if (source != null) {

            doc.setIdVisita(source.getIdVisita());
            doc.setNuVisita(source.getNuVisita());
            doc.setIdPaciente(source.getIdPaciente());
            doc.setDtInclusao(source.getDtInclusao());
            doc.setDtRealizacao(source.getDtRealizacao());
            doc.setAssinaturaAprovador(source.getAssinaturaAprovador());
            doc.setDtAssinaturaAprovacao(source.getDtAssinaturaAprovacao());
            doc.setStAprovacao(source.getStAprovacao());
        }

        return doc;
    }

    /**
     * Atualiza o objeto com os dados para update.
     *
     * @param source
     * @return
     */
    public final TbVisita populate(final Visita source) {

        TbVisita doc = new TbVisita();

        if(Eval.isNotNull(source.getIdVisita())) {
            doc.setIdVisita(source.getIdVisita());
        }

        if(Eval.isNotNull(source.getNuVisita())) {
            doc.setNuVisita(source.getNuVisita());
        }

        if(Eval.isNotNull(source.getIdPaciente())) {
            doc.setIdPaciente(source.getIdPaciente());
        }

        if(Eval.isNotNull(source.getDtInclusao())) {
            doc.setDtInclusao(source.getDtInclusao());
        }

        if(Eval.isNotNull(source.getDtRealizacao())) {
            doc.setDtRealizacao(source.getDtRealizacao());
        }

        if(Eval.isNotNull(source.getAssinaturaAprovador())) {
            doc.setAssinaturaAprovador(source.getAssinaturaAprovador());
        }

        if(Eval.isNotNull(source.getDtAssinaturaAprovacao())) {
            doc.setDtAssinaturaAprovacao(source.getDtAssinaturaAprovacao());
        }

        if(Eval.isNotNull(source.getStAprovacao())) {
            doc.setStAprovacao(source.getStAprovacao());
        }

        return doc;
    }
}
