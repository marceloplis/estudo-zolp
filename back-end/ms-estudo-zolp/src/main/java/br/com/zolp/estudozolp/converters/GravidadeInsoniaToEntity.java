package br.com.zolp.estudozolp.converters;

import br.com.zolp.estudozolp.bean.GravidadeInsonia;
import br.com.zolp.estudozolp.entity.TbGravidadeInsonia;
import br.com.zolp.estudozolp.util.Eval;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Classe reponsável por efetuar a conversão dos objetos
 * {@link GravidadeInsonia} para o objeto {@link TbGravidadeInsonia}.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Component
public class GravidadeInsoniaToEntity implements Converter<GravidadeInsonia, TbGravidadeInsonia> {

    @Override
    public final TbGravidadeInsonia convert(final GravidadeInsonia source) {

        TbGravidadeInsonia doc = new TbGravidadeInsonia();

        if (source != null) {

            doc.setIdGravidadeInsonia(source.getIdGravidadeInsonia());
            doc.setIdPaciente(source.getIdPaciente());
            doc.setGravidadeInsonia(source.getGravidadeInsonia());
            doc.setTipoGravidadeInsonia(source.getTipoGravidadeInsonia());
            doc.setSatisfacaoPadraoSono(source.getSatisfacaoPadraoSono());
            doc.setInterferenciaAtividadeDiaria(source.getInterferenciaAtividadeDiaria());
            doc.setPercepcaoExterna(source.getPercepcaoExterna());
            doc.setNivelPreocupacao(source.getNivelPreocupacao());

        }

        return doc;
    }

    /**
     * Atualiza o objeto com os dados para update.
     *
     * @param source
     * @return
     */
    public final TbGravidadeInsonia populate(final GravidadeInsonia source) {

        TbGravidadeInsonia doc = new TbGravidadeInsonia();

        if(Eval.isNotNull(source.getIdGravidadeInsonia())) {
            doc.setIdGravidadeInsonia(source.getIdGravidadeInsonia());
        }

        if(Eval.isNotNull(source.getIdPaciente())) {
            doc.setIdPaciente(source.getIdPaciente());
        }

        if(Eval.isNotNull(source.getGravidadeInsonia())) {
            doc.setGravidadeInsonia(source.getGravidadeInsonia());
        }

        if(Eval.isNotNull(source.getTipoGravidadeInsonia())) {
            doc.setTipoGravidadeInsonia(source.getTipoGravidadeInsonia());
        }

        if(Eval.isNotNull(source.getSatisfacaoPadraoSono())) {
            doc.setSatisfacaoPadraoSono(source.getSatisfacaoPadraoSono());
        }

        if(Eval.isNotNull(source.getInterferenciaAtividadeDiaria())) {
            doc.setInterferenciaAtividadeDiaria(source.getInterferenciaAtividadeDiaria());
        }

        if(Eval.isNotNull(source.getPercepcaoExterna())) {
            doc.setPercepcaoExterna(source.getPercepcaoExterna());
        }

        if(Eval.isNotNull(source.getNivelPreocupacao())) {
            doc.setNivelPreocupacao(source.getNivelPreocupacao());
        }

        return doc;
    }
}
