package br.com.zolp.estudozolp.converters;

import br.com.zolp.estudozolp.bean.DoencaEvento;
import br.com.zolp.estudozolp.entity.TbDoencaEvento;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Classe reponsável por efetuar a conversão dos objetos
 * {@link TbDoencaEvento} para o objeto {@link DoencaEvento}.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Component
public class DoencaEventoToBean implements Converter<TbDoencaEvento, DoencaEvento> {

    @Override
    public final DoencaEvento convert(final TbDoencaEvento source) {

        DoencaEvento doc = new DoencaEvento();

        if (source != null) {

            doc.setIdDoencaEvento(source.getIdDoencaEvento());
            doc.setDsDoenca(source.getDsDoenca());
            doc.setSiglaDoenca(source.getSiglaDoenca());

        }

        return doc;
    }

}
