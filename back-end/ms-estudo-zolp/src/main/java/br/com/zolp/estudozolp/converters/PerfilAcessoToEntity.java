package br.com.zolp.estudozolp.converters;

import br.com.zolp.estudozolp.bean.PerfilAcesso;
import br.com.zolp.estudozolp.entity.TbPerfilAcesso;
import br.com.zolp.estudozolp.util.Eval;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Classe reponsável por efetuar a conversão dos objetos da consulta dos Usuarios
 * {@link PerfilAcesso} para o objeto {@link TbPerfilAcesso}.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Component
public class PerfilAcessoToEntity implements Converter<PerfilAcesso, TbPerfilAcesso> {

    @Override
    public final TbPerfilAcesso convert(final PerfilAcesso source) {

        TbPerfilAcesso doc = new TbPerfilAcesso();

        if (source != null) {

            doc.setIdPerfilAcesso(source.getIdPerfilAcesso());
            doc.setDsPerfil(source.getDsPerfil());

        }

        return doc;
    }

    /**
     * Atualiza o objeto com os dados para update.
     *
     * @param source
     * @return
     */
    public final TbPerfilAcesso populate(final PerfilAcesso source) {

        TbPerfilAcesso doc = new TbPerfilAcesso();

        if(Eval.isNotEmpty(source.getIdPerfilAcesso())) {
            doc.setIdPerfilAcesso(source.getIdPerfilAcesso());
        }

        if(Eval.isNotEmpty(source.getDsPerfil())) {
            doc.setDsPerfil(source.getDsPerfil());
        }

        return doc;
    }

}
