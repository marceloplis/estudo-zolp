package br.com.zolp.estudozolp.converters;

import br.com.zolp.estudozolp.bean.UsuarioSistema;
import br.com.zolp.estudozolp.entity.TbUsuarioSistema;
import br.com.zolp.estudozolp.util.Eval;
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
public class UsuarioSistemaToEntity implements Converter<UsuarioSistema, TbUsuarioSistema> {

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

    /**
     * Atualiza o objeto com os dados para update.
     *
     * @param source
     * @return
     */
    public final TbUsuarioSistema populate(final UsuarioSistema source) {

        TbUsuarioSistema doc = new TbUsuarioSistema();

        if(Eval.isNotEmpty(source.getIdUsuario())) {
            doc.setIdUsuario(source.getIdUsuario());
        }

        if(Eval.isNotEmpty(source.getIdUnidadePesquisa())) {
            doc.setIdUnidadePesquisa(source.getIdUnidadePesquisa());
        }

        if(Eval.isNotEmpty(source.getIdPerfil())) {
            doc.setIdPerfil(source.getIdPerfil());
        }

        if(Eval.isNotEmpty(source.getUsername())) {
            doc.setUsername(source.getUsername());
        }

        if(Eval.isNotEmpty(source.getNome())) {
            doc.setNome(source.getNome());
        }

        if(Eval.isNotEmpty(source.getSenha())) {
            doc.setSenha(source.getSenha());
        }

        if(Eval.isNotEmpty(source.getEmail())) {
            doc.setEmail(source.getEmail());
        }

        if(Eval.isNotEmpty(source.getFlSenhaTemporaria())) {
            doc.setFlSenhaTemporaria(source.getFlSenhaTemporaria());
        }

        if(Eval.isNotEmpty(source.getFlAtivo())) {
            doc.setFlAtivo(source.getFlAtivo());
        }

        if(Eval.isNotEmpty(source.getFone())) {
            doc.setFone(source.getFone());
        }

        if(Eval.isNotEmpty(source.getAdmin())) {
            doc.setAdmin(source.getAdmin());
        }

        return doc;
    }
}
