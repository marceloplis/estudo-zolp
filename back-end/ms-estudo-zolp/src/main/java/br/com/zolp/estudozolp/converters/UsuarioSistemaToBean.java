package br.com.zolp.estudozolp.converters;

import br.com.zolp.estudozolp.bean.UsuarioSistema;
import br.com.zolp.estudozolp.entity.TbUsuarioSistema;
import br.com.zolp.estudozolp.util.Numbers;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Classe reponsável por efetuar a conversão dos objetos da consulta dos Usuarios
 * {@link TbUsuarioSistema} para o objeto {@link UsuarioSistema}.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Component
public class UsuarioSistemaToBean implements Converter<TbUsuarioSistema, UsuarioSistema> {

    private static final int
            CAMPO_1 = 0,
            CAMPO_2 = 1,

    // Numero de colunas da query executada:
    SQL_CONT_COLUNAS = 2;

    public final UsuarioSistema convert(final Object[] source) {

        final UsuarioSistema doc = new UsuarioSistema();

        if (source != null && source.length >= SQL_CONT_COLUNAS) {

            if (source[CAMPO_1] != null) {
                doc.setIdUsuario(Numbers.longValue(source[CAMPO_1]));
            }

            if (source[CAMPO_2] != null) {
                doc.setNome((String) source[CAMPO_2]);
            }

        }

        return doc;
    }

    @Override
    public final UsuarioSistema convert(final TbUsuarioSistema source) {

        UsuarioSistema doc = new UsuarioSistema();

        if (source != null) {

            doc.setIdUsuario(source.getIdUsuario());
            doc.setIdUnidadePesquisa(source.getIdUnidadePesquisa());
            doc.setIdPerfil(source.getIdPerfil());
            doc.setUsername(source.getUsername());
            doc.setNome(source.getNome());
            doc.setSenha(source.getSenha());
            doc.setEmail(source.getEmail());
            doc.setFlSenhaTemporaria(source.getFlSenhaTemporaria());
            doc.setFlAtivo(source.getFlAtivo());
            doc.setFone(source.getFone());
            doc.setAdmin(source.getAdmin());

        }

        return doc;
    }

}
