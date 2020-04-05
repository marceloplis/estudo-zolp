package br.com.zolp.estudozolp.converters;

import br.com.zolp.estudozolp.bean.UnidadePesquisa;
import br.com.zolp.estudozolp.entity.TbUnidadePesquisa;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Classe reponsável por efetuar a conversão dos objetos
 * {@link TbUnidadePesquisa} para o objeto {@link UnidadePesquisa}.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Component
public class UnidadePesquisaToBean implements Converter<TbUnidadePesquisa, UnidadePesquisa> {

    @Override
    public final UnidadePesquisa convert(final TbUnidadePesquisa source) {

        UnidadePesquisa doc = new UnidadePesquisa();

        if (source != null) {

            doc.setIdUnidadePesquisa(source.getIdUnidadePesquisa());
            doc.setDsUnidade(source.getDsUnidade());
            doc.setSiglaUnidade(source.getSiglaUnidade());
            doc.setTelUnidade(source.getTelUnidade());
            doc.setEndereco(source.getEndereco());
            doc.setCidade(source.getCidade());
            doc.setUf(source.getUf());
            doc.setCep(source.getCep());
            doc.setInvestigador(source.getInvestigador());
            doc.setCoordenador(source.getCoordenador());
            doc.setEmail(source.getEmail());
            doc.setNuUnidade(source.getNuUnidade());

        }

        return doc;
    }

}
