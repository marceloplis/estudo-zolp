package br.com.zolp.estudozolp.converters;

import br.com.zolp.estudozolp.bean.PerfilAcesso;
import br.com.zolp.estudozolp.entity.TbPerfilAcesso;
import br.com.zolp.estudozolp.util.Numbers;
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

    private static final int
            CAMPO_1 = 0,
            CAMPO_2 = 1,

    // Numero de colunas da query executada:
    SQL_CONT_COLUNAS = 2;

    public final PerfilAcesso convert(final Object[] source) {

        final PerfilAcesso doc = new PerfilAcesso();

        if (source != null && source.length >= SQL_CONT_COLUNAS) {

            if (source[CAMPO_1] != null) {
                doc.setIdPerfilAcesso(Numbers.longValue(source[CAMPO_1]));
            }

            if (source[CAMPO_2] != null) {
                doc.setDsPerfil((String) source[CAMPO_2]);
            }

        }

        return doc;
    }

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
