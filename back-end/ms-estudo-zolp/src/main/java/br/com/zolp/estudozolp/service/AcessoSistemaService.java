package br.com.zolp.estudozolp.service;

import br.com.zolp.estudozolp.bean.PerfilAcesso;
import br.com.zolp.estudozolp.bean.UsuarioSistema;
import br.com.zolp.estudozolp.bean.filtro.FiltroConsultaPerfilAcesso;
import br.com.zolp.estudozolp.bean.filtro.FiltroConsultaUsuario;
import br.com.zolp.estudozolp.exception.EstudoZolpException;
import br.com.zolp.estudozolp.exception.PersistenciaException;
import br.com.zolp.estudozolp.exception.RegistroNaoLocalizadoException;

import java.util.List;

/**
 * Interface responsavel por disponibilizar as operacoes de persistencia
 * das informações de acesso ao sistema.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
public interface AcessoSistemaService {

    // --- CADASTRO DE USUARIO ------------------------------------------------

    /**
     * Efetua a busca de um usuario.
     *
     * @param idUsuario
     * @return UsuarioSistema
     * @throws EstudoZolpException
     */
    UsuarioSistema obterUsuario(final Long idUsuario) throws EstudoZolpException;

    /**
     * Efetua a busca dos usuarios com base no filtro.
     *
     * @param filtro
     * @return Lista de usuarios.
     * @throws EstudoZolpException
     */
    List<UsuarioSistema> consultarUsuario(final FiltroConsultaUsuario filtro) throws EstudoZolpException;

    /**
     *  Efetua a inclusao de um usuario.
     *
     * @param usuarioSistema
     * @throws EstudoZolpException
     */
    void incluirUsuario(UsuarioSistema usuarioSistema) throws EstudoZolpException;

    /**
     * Efetua a alteracao de um usuario.
     * @return
     * @throws EstudoZolpException
     */
    UsuarioSistema alterarUsuario(UsuarioSistema usuarioSistema) throws EstudoZolpException,
        RegistroNaoLocalizadoException, PersistenciaException;

    /**
     * Efetua a exclusao de um usuario.
     *
     * @param idUsuario
     * @return Boolean
     * @throws EstudoZolpException
     */
    void excluirUsuario(Long idUsuario) throws EstudoZolpException;

    // --- CADASTRO DE PERFIL ------------------------------------------------

    /**
     * Efetua a busca de um perfil.
     *
     * @param idPerfil
     * @return PerfilAcesso
     * @throws EstudoZolpException
     */
    PerfilAcesso obterPerfil(final Long idPerfil) throws EstudoZolpException;

    /**
     * Efetua a busca dos perfis com base no filtro.
     *
     * @param filtro
     * @return Lista de perfis
     * @throws EstudoZolpException
     */
    List<PerfilAcesso> consultarPerfil(FiltroConsultaPerfilAcesso filtro) throws EstudoZolpException;

    /**
     *  Efetua a inclusao de um perfil.
     *
     * @param perfilAcesso
     * @throws EstudoZolpException
     */
    void incluirPerfil(PerfilAcesso perfilAcesso) throws EstudoZolpException;

    /**
     * Efetua a alteracao de um perfil.
     *
     * @return PerfilSistema
     * @throws EstudoZolpException
     */
    PerfilAcesso alterarPerfil(PerfilAcesso perfilAcesso) throws EstudoZolpException,
        RegistroNaoLocalizadoException, PersistenciaException;

    /**
     * Efetua a exclusao de um usuario.
     *
     * @param idPerfil
     * @return Boolean
     * @throws EstudoZolpException
     */
    void excluirPerfil(Long idPerfil) throws EstudoZolpException;

}
