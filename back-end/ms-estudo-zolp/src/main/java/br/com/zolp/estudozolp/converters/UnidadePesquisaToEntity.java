package br.com.zolp.estudozolp.converters;

import br.com.zolp.estudozolp.bean.UnidadePesquisa;
import br.com.zolp.estudozolp.entity.TbUnidadePesquisa;
import br.com.zolp.estudozolp.util.Eval;
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

    /**
     * Atualiza o objeto com os dados para update.
     *
     * @param source
     * @return
     */
    public final TbUnidadePesquisa populate(final UnidadePesquisa source) {

        TbUnidadePesquisa doc = new TbUnidadePesquisa();

        if(Eval.isNotEmpty(source.getIdUnidadePesquisa())) {
            doc.setIdUnidadePesquisa(source.getIdUnidadePesquisa());
        }

        if(Eval.isNotEmpty(source.getDsUnidade())) {
            doc.setDsUnidade(source.getDsUnidade());
        }

        if(Eval.isNotEmpty(source.getSiglaUnidade())) {
            doc.setSiglaUnidade(source.getSiglaUnidade());
        }

        if(Eval.isNotEmpty(source.getTelUnidade())) {
            doc.setTelUnidade(source.getTelUnidade());
        }

        if(Eval.isNotEmpty(source.getEndereco())) {
            doc.setEndereco(source.getEndereco());
        }

        if(Eval.isNotEmpty(source.getCidade())) {
            doc.setCidade(source.getCidade());
        }

        if(Eval.isNotEmpty(source.getUf())) {
            doc.setUf(source.getUf());
        }

        if(Eval.isNotEmpty(source.getCep())) {
            doc.setCep(source.getCep());
        }

        if(Eval.isNotEmpty(source.getInvestigador())) {
            doc.setInvestigador(source.getInvestigador());
        }

        if(Eval.isNotEmpty(source.getCoordenador())) {
            doc.setCoordenador(source.getCoordenador());
        }

        if(Eval.isNotEmpty(source.getEmail())) {
            doc.setEmail(source.getEmail());
        }

        if(Eval.isNotEmpty(source.getNuUnidade())) {
            doc.setNuUnidade(source.getNuUnidade());
        }

        return doc;
    }
}
