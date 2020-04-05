package br.com.zolp.estudozolp.converters;

import br.com.zolp.estudozolp.bean.UsuarioSistema;
import br.com.zolp.estudozolp.entity.TbUsuarioSistema;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Classe reponsável por efetuar a conversão dos objetos da consulta dos Usuarios
 * {@link UsuarioSistema} para o objeto {@link TbUsuarioSistema}.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Component
public class UnidadePesquisaToEntity implements Converter<UsuarioSistema, TbUsuarioSistema> {

    @Override
    public final TbUsuarioSistema convert(final UsuarioSistema source) {

        TbUsuarioSistema doc = new TbUsuarioSistema();

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
