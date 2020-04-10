package br.com.zolp.estudozolp.converters;

import br.com.zolp.estudozolp.bean.UnidadePesquisa;
import br.com.zolp.estudozolp.entity.TbUnidadePesquisa;
import br.com.zolp.estudozolp.util.Numbers;
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

    private static final int
            CAMPO_1 = 0,
            CAMPO_2 = 1,

    // Numero de colunas da query executada:
    SQL_CONT_COLUNAS = 2;

    public final UnidadePesquisa convert(final Object[] source) {

        final UnidadePesquisa doc = new UnidadePesquisa();

        if (source != null && source.length >= SQL_CONT_COLUNAS) {

            if (source[CAMPO_1] != null) {
                doc.setIdUnidadePesquisa(Numbers.longValue(source[CAMPO_1]));
            }

            if (source[CAMPO_2] != null) {
                doc.setDsUnidade((String) source[CAMPO_2]);
            }

        }

        return doc;
    }

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
