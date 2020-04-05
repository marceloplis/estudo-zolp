package br.com.zolp.estudozolp.converters;

import br.com.zolp.estudozolp.bean.UnidadePesquisa;
import br.com.zolp.estudozolp.entity.TbUnidadePesquisa;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Classe reponsável por efetuar a conversão dos objetos
 * {@link UnidadePesquisa} para o objeto {@link TbUnidadePesquisa}.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Component
public class UnidadePesquisaToEntity implements Converter<UnidadePesquisa, TbUnidadePesquisa> {

    @Override
    public final TbUnidadePesquisa convert(final UnidadePesquisa source) {

        TbUnidadePesquisa doc = new TbUnidadePesquisa();

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
