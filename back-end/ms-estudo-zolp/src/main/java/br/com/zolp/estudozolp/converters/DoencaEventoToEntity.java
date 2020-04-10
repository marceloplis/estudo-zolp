package br.com.zolp.estudozolp.converters;

import br.com.zolp.estudozolp.bean.DoencaEvento;
import br.com.zolp.estudozolp.entity.TbDoencaEvento;
import br.com.zolp.estudozolp.util.Eval;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Classe reponsável por efetuar a conversão dos objetos
 * {@link DoencaEvento} para o objeto {@link TbDoencaEvento}.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Component
public class DoencaEventoToEntity implements Converter<DoencaEvento, TbDoencaEvento> {

    @Override
    public final TbDoencaEvento convert(final DoencaEvento source) {

        TbDoencaEvento doc = new TbDoencaEvento();

        if (source != null) {

            doc.setIdDoencaEvento(source.getIdDoencaEvento());
            doc.setDsDoenca(source.getDsDoenca());
            doc.setSiglaDoenca(source.getSiglaDoenca());

        }

        return doc;
    }


    /**
     * Atualiza o objeto com os dados para update.
     *
     * @param source
     * @return
     */
    public final TbDoencaEvento populate(final DoencaEvento source) {

        TbDoencaEvento doc = new TbDoencaEvento();

        if(Eval.isNotEmpty(source.getIdDoencaEvento())) {
            doc.setIdDoencaEvento(source.getIdDoencaEvento());
        }

        if(Eval.isNotEmpty(source.getDsDoenca())) {
            doc.setDsDoenca(source.getDsDoenca());
        }

        if(Eval.isNotEmpty(source.getSiglaDoenca())) {
            doc.setSiglaDoenca(source.getSiglaDoenca());
        }

        return doc;
    }

}
