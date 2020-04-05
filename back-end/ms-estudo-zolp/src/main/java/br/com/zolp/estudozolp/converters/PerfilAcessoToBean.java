package br.com.zolp.estudozolp.converters;

import br.com.zolp.estudozolp.bean.PerfilAcesso;
import br.com.zolp.estudozolp.entity.TbPerfilAcesso;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Classe reponsável por efetuar a conversão dos objetos da consulta dos Usuarios
 * {@link TbPerfilAcesso} para o objeto {@link PerfilAcesso}.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Component
public class PerfilAcessoToBean implements Converter<TbPerfilAcesso, PerfilAcesso> {

    @Override
    public final PerfilAcesso convert(final TbPerfilAcesso source) {

        PerfilAcesso doc = new PerfilAcesso();

        if (source != null) {

            doc.setIdPerfilAcesso(source.getIdPerfilAcesso());
            doc.setDsPerfil(source.getDsPerfil());

        }

        return doc;
    }

}
