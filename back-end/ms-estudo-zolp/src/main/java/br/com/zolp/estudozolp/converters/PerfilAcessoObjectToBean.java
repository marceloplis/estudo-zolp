package br.com.zolp.estudozolp.converters;

import br.com.zolp.estudozolp.bean.PerfilAcesso;
import br.com.zolp.estudozolp.util.Numbers;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Classe reponsável por efetuar a conversão dos objetos da consulta
 * para o objeto {@link PerfilAcesso}.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Component
public class PerfilAcessoObjectToBean implements Converter<Object[], PerfilAcesso> {

    private static final int
        CAMPO_1 = 0,
        CAMPO_2 = 1,

        // Numero de colunas da query executada:
        SQL_CONT_COLUNAS = 2;

    @Override
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

}