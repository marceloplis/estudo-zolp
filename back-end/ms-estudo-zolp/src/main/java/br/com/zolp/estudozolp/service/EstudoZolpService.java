package br.com.zolp.estudozolp.service;

import br.com.zolp.estudozolp.bean.AuditoriaEstudo;
import br.com.zolp.estudozolp.bean.SaidaEstudo;
import br.com.zolp.estudozolp.bean.UnidadePesquisa;
import br.com.zolp.estudozolp.bean.filtro.FiltroConsultaAuditoria;
import br.com.zolp.estudozolp.bean.filtro.FiltroSaidaEstudo;
import br.com.zolp.estudozolp.bean.filtro.FiltroUnidadePesquisa;
import br.com.zolp.estudozolp.exception.EstudoZolpException;
import br.com.zolp.estudozolp.exception.PersistenciaException;
import br.com.zolp.estudozolp.exception.RegistroNaoLocalizadoException;

import java.util.List;

/**
 * Interface responsavel por disponibilizar as operacoes de persistencia
 * das informações de auditoria, unidadePesquisa, saida estudo, ....
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
public interface EstudoZolpService {

    // --- CADASTRO DE AUDITORIA ------------------------------------------------

    /**
     * Efetua a busca da auditoria.
     *
     * @param idAuditoriaEstudo
     * @return AuditoriaEstudo
     * @throws EstudoZolpException
     */
    AuditoriaEstudo obterAuditoria(final Long idAuditoriaEstudo) throws EstudoZolpException;

    /**
     * Efetua a busca das auditorias com base no filtro.
     *
     * @param filtro
     * @return Lista de usuarios.
     * @throws EstudoZolpException
     */
    List<AuditoriaEstudo> consultarAuditoria(final FiltroConsultaAuditoria filtro) throws EstudoZolpException;

    /**
     *  Efetua a inclusao de uma auditoria.
     *
     * @param auditoriaEstudo
     * @throws EstudoZolpException
     */
    void incluirAuditoria(AuditoriaEstudo auditoriaEstudo) throws EstudoZolpException;

    /**
     * Efetua a alteracao de uma auditoria.
     * @return AuditoriaEstudo
     * @throws EstudoZolpException
     */
    AuditoriaEstudo alterarAuditoria(AuditoriaEstudo auditoriaEstudo) throws EstudoZolpException,
        RegistroNaoLocalizadoException, PersistenciaException;

    /**
     * Efetua a exclusao de uma auditoria.
     *
     * @param idAuditoriaEstudo
     * @return Boolean
     * @throws EstudoZolpException
     */
    void excluirAuditoria(Long idAuditoriaEstudo) throws EstudoZolpException;


    // --- CADASTRO DE UNIDADE DE PESQUISA ------------------------------------------------

    /**
     * Efetua a busca de uma unidadePesquisa.
     *
     * @param idUnidadePesquisa
     * @return UnidadePesquisa
     * @throws EstudoZolpException
     */
    UnidadePesquisa obterUnidadePesquisa(final Long idUnidadePesquisa) throws EstudoZolpException;

    /**
     * Efetua a busca dos usuarios com base no filtro.
     *
     * @param filtro
     * @return Lista de unidades de pesquisa.
     * @throws EstudoZolpException
     */
    List<UnidadePesquisa> consultarUnidadePesquisa(final FiltroUnidadePesquisa filtro) throws EstudoZolpException;

    /**
     *  Efetua a inclusao de uma unidadePesquisa.
     *
     * @param unidadePesquisa
     * @throws EstudoZolpException
     */
    void incluirUnidadePesquisa(UnidadePesquisa unidadePesquisa) throws EstudoZolpException;

    /**
     * Efetua a alteracao de uma unidadePesquisa.
     * @return UnidadePesquisa
     * @throws EstudoZolpException
     */
    UnidadePesquisa alterarUnidadePesquisa(UnidadePesquisa unidadePesquisa) throws EstudoZolpException,
        RegistroNaoLocalizadoException, PersistenciaException;

    /**
     * Efetua a exclusao de uma unidadePesquisa.
     *
     * @param idUnidadePesquisa
     * @return Boolean
     * @throws EstudoZolpException
     */
    void excluirUnidadePesquisa(Long idUnidadePesquisa) throws EstudoZolpException;


    // --- CADASTRO DE SAIDA ESTUDO ------------------------------------------------

    /**
     * Efetua a busca de um usuario.
     *
     * @param idSaidaEstudo
     * @return SaidaEstudo
     * @throws EstudoZolpException
     */
    SaidaEstudo obterSaidaEstudo(final Long idSaidaEstudo) throws EstudoZolpException;

    /**
     * Efetua a busca dos registros de saidaEstudo com base no filtro.
     *
     * @param filtro
     * @return Lista de saidaEstudo.
     * @throws EstudoZolpException
     */
    List<SaidaEstudo> consultarSaidaEstudo(final FiltroSaidaEstudo filtro) throws EstudoZolpException;

    /**
     *  Efetua a inclusao de uma saidaEstudo.
     *
     * @param saidaEstudo
     * @throws EstudoZolpException
     */
    void incluirSaidaEstudo(SaidaEstudo saidaEstudo) throws EstudoZolpException;

    /**
     * Efetua a alteracao de uma saidaEstudo.
     * @return SaidaEstudo
     * @throws EstudoZolpException
     */
    SaidaEstudo alterarSaidaEstudo(SaidaEstudo saidaEstudo) throws EstudoZolpException,
        RegistroNaoLocalizadoException, PersistenciaException;

    /**
     * Efetua a exclusao de uma saidaEstudo.
     *
     * @param idSaidaEstudo
     * @return Boolean
     * @throws EstudoZolpException
     */
    void excluirSaidaEstudo(Long idSaidaEstudo) throws EstudoZolpException;

}
