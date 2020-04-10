package br.com.zolp.estudozolp.service.impl;

import br.com.zolp.estudozolp.bean.AuditoriaEstudo;
import br.com.zolp.estudozolp.bean.SaidaEstudo;
import br.com.zolp.estudozolp.bean.UnidadePesquisa;
import br.com.zolp.estudozolp.bean.filtro.FiltroConsultaAuditoria;
import br.com.zolp.estudozolp.bean.filtro.FiltroSaidaEstudo;
import br.com.zolp.estudozolp.bean.filtro.FiltroUnidadePesquisa;
import br.com.zolp.estudozolp.converters.*;
import br.com.zolp.estudozolp.entity.TbAuditoriaEstudo;
import br.com.zolp.estudozolp.entity.TbSaidaEstudo;
import br.com.zolp.estudozolp.entity.TbUnidadePesquisa;
import br.com.zolp.estudozolp.exception.EstudoZolpException;
import br.com.zolp.estudozolp.exception.PersistenciaException;
import br.com.zolp.estudozolp.exception.RegistroNaoLocalizadoException;
import br.com.zolp.estudozolp.log.LogManager;
import br.com.zolp.estudozolp.repository.AuditoriaEstudoRepository;
import br.com.zolp.estudozolp.repository.SaidaEstudoRepository;
import br.com.zolp.estudozolp.repository.UnidadePesquisaRepository;
import br.com.zolp.estudozolp.service.EstudoZolpService;
import br.com.zolp.estudozolp.types.TipoLog;
import br.com.zolp.estudozolp.util.Eval;
import org.slf4j.event.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Classe responsavel pela implementacao das operacoes de persistencia no Banco de Dados
 * das informações referente a auditoria, unidadePesquisa, saida estudo.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Service
@Transactional
public class EstudoZolpServiceImpl implements EstudoZolpService {

    @Autowired
    private AuditoriaEstudoRepository auditoriaEstudoRepository;

    @Autowired
    private AuditoriaEstudoToBean auditoriaEstudoToBean;

    @Autowired
    private AuditoriaEstudoToEntity auditoriaEstudoToEntity;

    @Autowired
    private UnidadePesquisaRepository unidadePesquisaRepository;

    @Autowired
    private UnidadePesquisaToBean unidadePesquisaToBean;

    @Autowired
    private UnidadePesquisaToEntity unidadePesquisaToEntity;

    @Autowired
    private SaidaEstudoRepository saidaEstudoRepository;

    @Autowired
    private SaidaEstudoToBean saidaEstudoToBean;

    @Autowired
    private SaidaEstudoToEntity saidaEstudoToEntity;

    @PersistenceContext
    private EntityManager entityManager;

    // --- QUERIES SQL --------------------------------------------------------

    // Query
    private static final String
        // Query
        SQL_SELECT_XPTO = " SELECT "
            + " FROM XPTO "
            + "WHERE 1=1 ",

        // Condicoes incrementais da clausula WHERE:
        AND_XPTO = " AND XPTO = ",
        AND_XPTO_1 = " AND XPTO_1 = ",

        // Ordenacao
        SQL_ORDER_BY = " ORDER BY XPTO ";

    // --- CADASTRO DE AUDITORIA ------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public AuditoriaEstudo obterAuditoria(Long idAuditoriaEstudo) throws EstudoZolpException {

        // Logging de entrada
        LogManager.log(Level.INFO, TipoLog.ENTRADA, EstudoZolpServiceImpl.class, "obterAuditoria");

        LogManager.logDetalhe(Level.INFO, EstudoZolpServiceImpl.class, "obterAuditoria",
            " Efetuando a consulta [ idAuditoriaEstudo: " + idAuditoriaEstudo + " ].");

        // Busca o registro
        Optional<TbAuditoriaEstudo> retorno;
        try {
            retorno = auditoriaEstudoRepository.findById(idAuditoriaEstudo);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, EstudoZolpServiceImpl.class, "obterAuditoria",
                " Erro ao efetuar a consulta das informações. ", e);
            throw new PersistenciaException("Erro ao efetuar a consulta das informacaoes.", e);
        }

        // Converte o entity
        AuditoriaEstudo auditoriaEstudo = null;

        if (retorno.isPresent()) {
            try {
                auditoriaEstudo = auditoriaEstudoToBean.convert(retorno.get());
            } catch (Exception e) {
                LogManager.logDetalhe(Level.ERROR, EstudoZolpServiceImpl.class, "obterAuditoria",
                    " Erro ao efetuar a conversao dos dados.", e);
                throw new EstudoZolpException("Erro ao efetuar a conversao dos dados.");
            }
        }

        // Logging de saida
        LogManager.log(Level.INFO, TipoLog.SAIDA, EstudoZolpServiceImpl.class, "obterAuditoria");

        return auditoriaEstudo;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<AuditoriaEstudo> consultarAuditoria(FiltroConsultaAuditoria filtro) throws EstudoZolpException {

        // Logging de entrada
        LogManager.log(Level.INFO, TipoLog.ENTRADA, EstudoZolpServiceImpl.class, "consultarAuditoria");

        LogManager.logDetalhe(Level.INFO, EstudoZolpServiceImpl.class, "consultarAuditoria",
            " Efetuando a consulta [ " + filtro + " ].");

        // Valida se o filtro foi preenchido
        if (Eval.isNull(filtro) || Eval.isAllEmpty(filtro.getId(), filtro.getDescricao())) {
            LogManager.logDetalhe(Level.ERROR, EstudoZolpServiceImpl.class, "consultarAuditoria",
                " Nenhum dado informado nos filtros.");

            throw new EstudoZolpException("Nenhum dado informado nos filtros.");
        }

        // Busca os registros de auditoria
        final List<AuditoriaEstudo> listaAuditoria = new ArrayList<>();

        // Monta comando SQL
        final StringBuilder sqlSelect = new StringBuilder(SQL_SELECT_XPTO);

        if (Eval.isNotEmpty(filtro.getDescricao())) {
            sqlSelect.append(AND_XPTO)
                .append(filtro.getDescricao());
        }

        sqlSelect.append(SQL_ORDER_BY);

        // Executa a consulta SQL
        try {

            final Query query = entityManager.createNativeQuery(sqlSelect.toString());

            ((List<?>) query.getResultList())
                .forEach(object -> listaAuditoria
                .add(auditoriaEstudoToBean.convert((Object[]) object)));

        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, EstudoZolpServiceImpl.class, "consultarAuditoria",
                " Erro ao efetuar a consulta das informacoes [" + " Consulta SQL: '" + sqlSelect
                + "' ].", e);
            throw new PersistenciaException("Erro ao efetuar a consulta das informacoes.", e);
        }

        // Logging de saida
        LogManager.log(Level.INFO, TipoLog.SAIDA, EstudoZolpServiceImpl.class, "consultarAuditoria");

        return listaAuditoria;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void incluirAuditoria(AuditoriaEstudo auditoriaEstudo) throws EstudoZolpException {

        // Logging de entrada
        LogManager.log(Level.INFO, TipoLog.ENTRADA, EstudoZolpServiceImpl.class, "incluirAuditoria");

        // Remove o Id para que o mesmo obtenha um novo sequencial
        auditoriaEstudo.setIdAuditoriaEstudo(null);

        LogManager.logDetalhe(Level.INFO, EstudoZolpServiceImpl.class, "incluirAuditoria",
            " Dados entrada [ " + auditoriaEstudo + " ].");

        TbAuditoriaEstudo tbAuditoriaEstudo;

        // Efetua a conversao
        try {
            tbAuditoriaEstudo = auditoriaEstudoToEntity.convert(auditoriaEstudo);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, EstudoZolpServiceImpl.class, "incluirAuditoria",
                " Erro ao efetuar a conversao dos dados.", e);
            throw new EstudoZolpException("Erro ao efetuar a conversao dos dados [ "
                + auditoriaEstudo + " ].");
        }

        // Inclui na base de dados
        try {
            auditoriaEstudoRepository.save(tbAuditoriaEstudo);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, EstudoZolpServiceImpl.class, "incluirAuditoria",
                " Erro ao efetuar a inclusao das informacoes.", e);
            throw new PersistenciaException("Erro ao efetuar a inclusao das informacoes.", e);
        }

        // Logging de saida
        LogManager.log(Level.INFO, TipoLog.SAIDA, EstudoZolpServiceImpl.class, "incluirAuditoria");

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AuditoriaEstudo alterarAuditoria(AuditoriaEstudo auditoriaEstudo) throws EstudoZolpException,
        RegistroNaoLocalizadoException, PersistenciaException {

        // Logging de entrada
        LogManager.log(Level.INFO, TipoLog.ENTRADA, EstudoZolpServiceImpl.class, "alterarAuditoria");

        LogManager.logDetalhe(Level.INFO, EstudoZolpServiceImpl.class, "alterarAuditoria",
            " Dados entrada [ " + auditoriaEstudo + " ].");

        LogManager.logDetalhe(Level.INFO, EstudoZolpServiceImpl.class, "alterarAuditoria",
            " Efetuando a consulta das informacoes de Usuario.");

        // Efetua a busca
        Optional<TbAuditoriaEstudo> retorno;
        try {
            retorno = auditoriaEstudoRepository.findById(auditoriaEstudo.getIdAuditoriaEstudo());
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, EstudoZolpServiceImpl.class, "alterarAuditoria",
                " Erro ao verificar a existencia do registro.", e);
            throw new PersistenciaException("Erro ao verificar a existencia do registro.", e);
        }

        if (!retorno.isPresent()) {
            throw new RegistroNaoLocalizadoException("O registro nao foi localizado na base de dados.");
        }

        // Obtem a entity recuperada da base
        TbAuditoriaEstudo tbAuditoriaEstudo = retorno.get();

        tbAuditoriaEstudo.setUsername(auditoriaEstudo.getUsername());
        tbAuditoriaEstudo.setDtModificacao(auditoriaEstudo.getDtModificacao());
        tbAuditoriaEstudo.setTpModificacao(auditoriaEstudo.getTpModificacao());
        tbAuditoriaEstudo.setDsModificacao(auditoriaEstudo.getDsModificacao());
        tbAuditoriaEstudo.setTpEntidade(auditoriaEstudo.getTpEntidade());
        tbAuditoriaEstudo.setIdPaciente(auditoriaEstudo.getIdPaciente());

        // Efetiva a atualizacao (update) na base oracle
        try {
            auditoriaEstudoRepository.save(tbAuditoriaEstudo);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, EstudoZolpServiceImpl.class, "alterarAuditoria",
                " Erro ao efetuar a atualizacao das informacoes.", e);
            throw new PersistenciaException("Erro ao efetuar a atualizacao das informacoes.", e);
        }

        // Logging de saida
        LogManager.log(Level.INFO, TipoLog.SAIDA, EstudoZolpServiceImpl.class, "alterarAuditoria");

        return auditoriaEstudoToBean.convert(tbAuditoriaEstudo);

    }

    @Override
    public void excluirAuditoria(Long idAuditoriaEstudo) throws EstudoZolpException {

        // Logging de entrada
        LogManager.log(Level.INFO, TipoLog.ENTRADA, EstudoZolpServiceImpl.class, "excluirAuditoria");

        LogManager.logDetalhe(Level.INFO, EstudoZolpServiceImpl.class, "excluirAuditoria",
            " Dados entrada [ " + idAuditoriaEstudo + " ].");

        LogManager.logDetalhe(Level.INFO, EstudoZolpServiceImpl.class, "excluirAuditoria",
            " Efetuando a consulta das informacoes.");

        Optional<TbAuditoriaEstudo> retorno;
        try {
            retorno = auditoriaEstudoRepository.findById(idAuditoriaEstudo);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, EstudoZolpServiceImpl.class, "excluirAuditoria",
                " Erro ao verificar a existencia do registro.", e);
            throw new PersistenciaException("Erro ao verificar a existencia do registro.", e);
        }

        if (!retorno.isPresent()) {
            throw new RegistroNaoLocalizadoException("O registro nao foi localizado na base de dados.");
        }

        // Obtem informacao da base
        TbAuditoriaEstudo auditoriaCadastrada = retorno.get();

        // Efetiva a exclusao do usuario
        try {
            auditoriaEstudoRepository.delete(auditoriaCadastrada);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, EstudoZolpServiceImpl.class, "excluirAuditoria",
                " Erro ao efetuar a exclusao das informacoes.", e);
            throw new PersistenciaException("Erro ao efetuar a exclusao das informacoes.", e);
        }

        // Logging de saida
        LogManager.log(Level.INFO, TipoLog.SAIDA, EstudoZolpServiceImpl.class, "excluirAuditoria");

    }

    // --- CADASTRO DE UNIDADE DE PESQUISA ------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public UnidadePesquisa obterUnidadePesquisa(Long idUnidadePesquisa) throws EstudoZolpException {

        // Logging de entrada
        LogManager.log(Level.INFO, TipoLog.ENTRADA, EstudoZolpServiceImpl.class, "obterUnidadePesquisa");

        LogManager.logDetalhe(Level.INFO, EstudoZolpServiceImpl.class, "obterUnidadePesquisa",
            " Efetuando a consulta [ idUnidadePesquisa: " + idUnidadePesquisa + " ].");

        // Busca o registro
        Optional<TbUnidadePesquisa> retorno;
        try {
            retorno = unidadePesquisaRepository.findById(idUnidadePesquisa);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, EstudoZolpServiceImpl.class, "obterUnidadePesquisa",
                " Erro ao efetuar a consulta das informações. ", e);
            throw new PersistenciaException("Erro ao efetuar a consulta das informacaoes.", e);
        }

        // Converte o entity
        UnidadePesquisa unidadePesquisa = null;

        if (retorno.isPresent()) {
            try {
                unidadePesquisa = unidadePesquisaToBean.convert(retorno.get());
            } catch (Exception e) {
                LogManager.logDetalhe(Level.ERROR, EstudoZolpServiceImpl.class, "obterUnidadePesquisa",
                    " Erro ao efetuar a conversao dos dados.", e);
                throw new EstudoZolpException("Erro ao efetuar a conversao dos dados.");
            }
        }

        // Logging de saida
        LogManager.log(Level.INFO, TipoLog.SAIDA, EstudoZolpServiceImpl.class, "obterUnidadePesquisa");

        return unidadePesquisa;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UnidadePesquisa> consultarUnidadePesquisa(FiltroUnidadePesquisa filtro) throws EstudoZolpException {

        // Logging de entrada
        LogManager.log(Level.INFO, TipoLog.ENTRADA, EstudoZolpServiceImpl.class, "consultarUnidadePesquisa");

        LogManager.logDetalhe(Level.INFO, EstudoZolpServiceImpl.class, "consultarUnidadePesquisa",
            " Efetuando a consulta [ " + filtro + " ].");

        // Valida se o filtro foi preenchido
        if (Eval.isNull(filtro) || Eval.isAllEmpty(filtro.getId(), filtro.getDescricao())) {
            LogManager.logDetalhe(Level.ERROR, EstudoZolpServiceImpl.class, "consultarUnidadePesquisa",
                " Nenhum dado informado nos filtros.");

            throw new EstudoZolpException("Nenhum dado informado nos filtros.");
        }

        // Busca os registros de usuario
        final List<UnidadePesquisa> listUnidadePesquisa = new ArrayList<>();

        // Monta comando SQL
        final StringBuilder sqlSelect = new StringBuilder(SQL_SELECT_XPTO);

        if (Eval.isNotEmpty(filtro.getDescricao())) {
            sqlSelect.append(AND_XPTO)
                .append(filtro.getDescricao());
        }

        sqlSelect.append(SQL_ORDER_BY);

        // Executa a consulta SQL
        try {

            final Query query = entityManager.createNativeQuery(sqlSelect.toString());

            ((List<?>) query.getResultList())
                .forEach(object -> listUnidadePesquisa
                .add(unidadePesquisaToBean.convert((Object[]) object)));

        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, EstudoZolpServiceImpl.class, "consultarUnidadePesquisa",
                " Erro ao efetuar a consulta das informacoes [" + " Consulta SQL: '" + sqlSelect
                + "' ].", e);
            throw new PersistenciaException("Erro ao efetuar a consulta das informacoes.", e);
        }

        // Logging de saida
        LogManager.log(Level.INFO, TipoLog.SAIDA, EstudoZolpServiceImpl.class, "consultarUnidadePesquisa");

        return listUnidadePesquisa;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void incluirUnidadePesquisa(UnidadePesquisa unidadePesquisa) throws EstudoZolpException {

        // Logging de entrada
        LogManager.log(Level.INFO, TipoLog.ENTRADA, EstudoZolpServiceImpl.class, "incluirUnidadePesquisa");

        // Remove o Id para que o mesmo obtenha um novo sequencial
        unidadePesquisa.setIdUnidadePesquisa(null);

        LogManager.logDetalhe(Level.INFO, EstudoZolpServiceImpl.class, "incluirUnidadePesquisa",
            " Dados entrada [ " + unidadePesquisa + " ].");

        TbUnidadePesquisa tbUnidadePesquisa;

        // Efetua a conversao
        try {
            tbUnidadePesquisa = unidadePesquisaToEntity.convert(unidadePesquisa);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, EstudoZolpServiceImpl.class, "incluirUnidadePesquisa",
                " Erro ao efetuar a conversao dos dados.", e);
            throw new EstudoZolpException("Erro ao efetuar a conversao dos dados [ "
                + unidadePesquisa + " ].");
        }

        // Inclui na base de dados
        try {
            unidadePesquisaRepository.save(tbUnidadePesquisa);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, EstudoZolpServiceImpl.class, "incluirUnidadePesquisa",
                " Erro ao efetuar a inclusao das informacoes.", e);
            throw new PersistenciaException("Erro ao efetuar a inclusao das informacoes.", e);
        }

        // Logging de saida
        LogManager.log(Level.INFO, TipoLog.SAIDA, EstudoZolpServiceImpl.class, "incluirUnidadePesquisa");

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UnidadePesquisa alterarUnidadePesquisa(UnidadePesquisa unidadePesquisa) throws EstudoZolpException,
        RegistroNaoLocalizadoException, PersistenciaException {

        // Logging de entrada
        LogManager.log(Level.INFO, TipoLog.ENTRADA, EstudoZolpServiceImpl.class, "alterarUnidadePesquisa");

        LogManager.logDetalhe(Level.INFO, EstudoZolpServiceImpl.class, "alterarUnidadePesquisa",
            " Dados entrada [ " + unidadePesquisa + " ].");

        LogManager.logDetalhe(Level.INFO, EstudoZolpServiceImpl.class, "alterarUnidadePesquisa",
            " Efetuando a consulta das informacoes.");

        // Efetua a busca do usuario
        Optional<TbUnidadePesquisa> retorno;
        try {
            retorno = unidadePesquisaRepository.findById(unidadePesquisa.getIdUnidadePesquisa());
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, EstudoZolpServiceImpl.class, "alterarUnidadePesquisa",
                " Erro ao verificar a existencia do registro.", e);
            throw new PersistenciaException("Erro ao verificar a existencia do registro.", e);
        }

        if (!retorno.isPresent()) {
            throw new RegistroNaoLocalizadoException("O registro nao foi localizado na base de dados.");
        }

        // obtem a entity recuperada da base,
        TbUnidadePesquisa tbUnidadePesquisa = retorno.get();

        tbUnidadePesquisa.setDsUnidade(unidadePesquisa.getDsUnidade());
        tbUnidadePesquisa.setSiglaUnidade(unidadePesquisa.getSiglaUnidade());
        tbUnidadePesquisa.setTelUnidade(unidadePesquisa.getTelUnidade());
        tbUnidadePesquisa.setEndereco(unidadePesquisa.getEndereco());
        tbUnidadePesquisa.setCidade(unidadePesquisa.getCidade());
        tbUnidadePesquisa.setUf(unidadePesquisa.getUf());
        tbUnidadePesquisa.setCep(unidadePesquisa.getCep());
        tbUnidadePesquisa.setInvestigador(unidadePesquisa.getInvestigador());
        tbUnidadePesquisa.setCoordenador(unidadePesquisa.getCoordenador());
        tbUnidadePesquisa.setEmail(unidadePesquisa.getEmail());
        tbUnidadePesquisa.setNuUnidade(unidadePesquisa.getNuUnidade());

        // Efetiva a atualizacao (update) na base oracle
        try {
            unidadePesquisaRepository.save(tbUnidadePesquisa);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, EstudoZolpServiceImpl.class, "alterarUnidadePesquisa",
                " Erro ao efetuar a atualizacao das informacoes.", e);
            throw new PersistenciaException("Erro ao efetuar a atualizacao das informacoes.", e);
        }

        // Logging de saida
        LogManager.log(Level.INFO, TipoLog.SAIDA, EstudoZolpServiceImpl.class, "alterarUnidadePesquisa");

        return unidadePesquisaToBean.convert(tbUnidadePesquisa);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void excluirUnidadePesquisa(Long idUnidadePesquisa) throws EstudoZolpException {

        // Logging de entrada
        LogManager.log(Level.INFO, TipoLog.ENTRADA, EstudoZolpServiceImpl.class, "excluirUnidadePesquisa");

        LogManager.logDetalhe(Level.INFO, EstudoZolpServiceImpl.class, "excluirUnidadePesquisa",
            " Dados entrada [ " + idUnidadePesquisa + " ].");

        LogManager.logDetalhe(Level.INFO, EstudoZolpServiceImpl.class, "excluirUnidadePesquisa",
            " Efetuando a consulta das informacoes.");

        Optional<TbUnidadePesquisa> retorno;
        try {
            retorno = unidadePesquisaRepository.findById(idUnidadePesquisa);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, EstudoZolpServiceImpl.class, "excluirUnidadePesquisa",
                " Erro ao verificar a existencia do registro.", e);
            throw new PersistenciaException("Erro ao verificar a existencia do registro.", e);
        }

        if (!retorno.isPresent()) {
            throw new RegistroNaoLocalizadoException("O registro nao foi localizado na base de dados.");
        }

        // Obtem informacao da base
        TbUnidadePesquisa unidadePesquisaCadastrada = retorno.get();

        // Efetiva a exclusao do usuario
        try {
            unidadePesquisaRepository.delete(unidadePesquisaCadastrada);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, EstudoZolpServiceImpl.class, "excluirUnidadePesquisa",
                " Erro ao efetuar a exclusao das informacoes.", e);
            throw new PersistenciaException("Erro ao efetuar a exclusao das informacoes.", e);
        }

        // Logging de saida
        LogManager.log(Level.INFO, TipoLog.SAIDA, EstudoZolpServiceImpl.class, "excluirUnidadePesquisa");

    }

    // --- CADASTRO DE SAIDA ESTUDO ------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public SaidaEstudo obterSaidaEstudo(Long idSaidaEstudo) throws EstudoZolpException {

        // Logging de entrada
        LogManager.log(Level.INFO, TipoLog.ENTRADA, EstudoZolpServiceImpl.class, "obterSaidaEstudo");

        LogManager.logDetalhe(Level.INFO, EstudoZolpServiceImpl.class, "obterSaidaEstudo",
            " Efetuando a consulta [ idSaidaEstudo: " + idSaidaEstudo + " ].");

        // Busca o registro
        Optional<TbSaidaEstudo> retorno;
        try {
            retorno = saidaEstudoRepository.findById(idSaidaEstudo);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, EstudoZolpServiceImpl.class, "obterSaidaEstudo",
                " Erro ao efetuar a consulta das informações. ", e);
            throw new PersistenciaException("Erro ao efetuar a consulta das informacaoes.", e);
        }

        // Converte o entity
        SaidaEstudo saidaEstudo = null;

        if (retorno.isPresent()) {
            try {
                saidaEstudo = saidaEstudoToBean.convert(retorno.get());
            } catch (Exception e) {
                LogManager.logDetalhe(Level.ERROR, EstudoZolpServiceImpl.class, "obterSaidaEstudo",
                    " Erro ao efetuar a conversao dos dados.", e);
                throw new EstudoZolpException("Erro ao efetuar a conversao dos dados.");
            }
        }

        // Logging de saida
        LogManager.log(Level.INFO, TipoLog.SAIDA, EstudoZolpServiceImpl.class, "obterSaidaEstudo");

        return saidaEstudo;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<SaidaEstudo> consultarSaidaEstudo(FiltroSaidaEstudo filtro) throws EstudoZolpException {

        // Logging de entrada
        LogManager.log(Level.INFO, TipoLog.ENTRADA, EstudoZolpServiceImpl.class, "consultarSaidaEstudo");

        LogManager.logDetalhe(Level.INFO, EstudoZolpServiceImpl.class, "consultarSaidaEstudo",
            " Efetuando a consulta [ " + filtro + " ].");

        // Valida se o filtro foi preenchido
        if (Eval.isNull(filtro) || Eval.isAllEmpty(filtro.getId(), filtro.getDescricao())) {
            LogManager.logDetalhe(Level.ERROR, EstudoZolpServiceImpl.class, "consultarSaidaEstudo",
                " Nenhum dado informado nos filtros.");

            throw new EstudoZolpException("Nenhum dado informado nos filtros.");
        }

        // Busca os registros de usuario
        final List<SaidaEstudo> saidaEstudos = new ArrayList<>();

        // Monta comando SQL
        final StringBuilder sqlSelect = new StringBuilder(SQL_SELECT_XPTO);

        if (Eval.isNotEmpty(filtro.getDescricao())) {
            sqlSelect.append(AND_XPTO)
                .append(filtro.getDescricao());
        }

        sqlSelect.append(SQL_ORDER_BY);

        // Executa a consulta SQL
        try {

            final Query query = entityManager.createNativeQuery(sqlSelect.toString());

            ((List<?>) query.getResultList())
                .forEach(object -> saidaEstudos
                .add(saidaEstudoToBean.convert((Object[]) object)));

        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, EstudoZolpServiceImpl.class, "consultarSaidaEstudo",
                " Erro ao efetuar a consulta das informacoes [" + " Consulta SQL: '" + sqlSelect
                + "' ].", e);
            throw new PersistenciaException("Erro ao efetuar a consulta das informacoes.", e);
        }

        // Logging de saida
        LogManager.log(Level.INFO, TipoLog.SAIDA, EstudoZolpServiceImpl.class, "consultarSaidaEstudo");

        return saidaEstudos;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void incluirSaidaEstudo(SaidaEstudo saidaEstudo) throws EstudoZolpException {

        // Logging de entrada
        LogManager.log(Level.INFO, TipoLog.ENTRADA, EstudoZolpServiceImpl.class, "incluirSaidaEstudo");

        // Remove o Id para que o mesmo obtenha um novo sequencial
        saidaEstudo.setIdSaidaEstudo(null);

        LogManager.logDetalhe(Level.INFO, EstudoZolpServiceImpl.class, "incluirSaidaEstudo",
            " Dados entrada [ " + saidaEstudo + " ].");

        TbSaidaEstudo tbSaidaEstudo;

        // Efetua a conversao
        try {
            tbSaidaEstudo = saidaEstudoToEntity.convert(saidaEstudo);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, EstudoZolpServiceImpl.class, "incluirSaidaEstudo",
                " Erro ao efetuar a conversao dos dados.", e);
            throw new EstudoZolpException("Erro ao efetuar a conversao dos dados [ "
                + saidaEstudo + " ].");
        }

        // Inclui na base de dados
        try {
            saidaEstudoRepository.save(tbSaidaEstudo);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, EstudoZolpServiceImpl.class, "incluirSaidaEstudo",
                " Erro ao efetuar a inclusao das informacoes.", e);
            throw new PersistenciaException("Erro ao efetuar a inclusao das informacoes.", e);
        }

        // Logging de saida
        LogManager.log(Level.INFO, TipoLog.SAIDA, EstudoZolpServiceImpl.class, "incluirSaidaEstudo");

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SaidaEstudo alterarSaidaEstudo(SaidaEstudo saidaEstudo) throws EstudoZolpException,
        RegistroNaoLocalizadoException, PersistenciaException {

        // Logging de entrada
        LogManager.log(Level.INFO, TipoLog.ENTRADA, EstudoZolpServiceImpl.class, "alterarSaidaEstudo");

        LogManager.logDetalhe(Level.INFO, EstudoZolpServiceImpl.class, "alterarSaidaEstudo",
            " Dados entrada [ " + saidaEstudo + " ].");

        LogManager.logDetalhe(Level.INFO, EstudoZolpServiceImpl.class, "alterarSaidaEstudo",
            " Efetuando a consulta das informacoes.");

        // Efetua a busca do usuario
        Optional<TbSaidaEstudo> retorno;
        try {
            retorno = saidaEstudoRepository.findById(saidaEstudo.getIdSaidaEstudo());
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, EstudoZolpServiceImpl.class, "alterarSaidaEstudo",
                " Erro ao verificar a existencia do registro.", e);
            throw new PersistenciaException("Erro ao verificar a existencia do registro.", e);
        }

        if (!retorno.isPresent()) {
            throw new RegistroNaoLocalizadoException("O registro nao foi localizado na base de dados.");
        }

        // obtem a entity recuperada da base,
        TbSaidaEstudo tbSaidaEstudo = retorno.get();

        tbSaidaEstudo.setIdPaciente(saidaEstudo.getIdPaciente());
        tbSaidaEstudo.setDtInclusao(saidaEstudo.getDtInclusao());
        tbSaidaEstudo.setNuVisita(saidaEstudo.getNuVisita());
        tbSaidaEstudo.setDtSaida(saidaEstudo.getDtSaida());
        tbSaidaEstudo.setDtOcorrencia(saidaEstudo.getDtOcorrencia());
        tbSaidaEstudo.setMotivo(saidaEstudo.getMotivo());
        tbSaidaEstudo.setFlEvolucaoObito(saidaEstudo.getFlEvolucaoObito());
        tbSaidaEstudo.setStAprovacao(saidaEstudo.getStAprovacao());
        tbSaidaEstudo.setAssinatura(saidaEstudo.getAssinatura());
        tbSaidaEstudo.setDtAssinatura(saidaEstudo.getDtAssinatura());
        tbSaidaEstudo.setObservacao(saidaEstudo.getObservacao());

        // Efetiva a atualizacao (update) na base oracle
        try {
            saidaEstudoRepository.save(tbSaidaEstudo);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, EstudoZolpServiceImpl.class, "alterarSaidaEstudo",
                " Erro ao efetuar a atualizacao das informacoes.", e);
            throw new PersistenciaException("Erro ao efetuar a atualizacao das informacoes.", e);
        }

        // Logging de saida
        LogManager.log(Level.INFO, TipoLog.SAIDA, EstudoZolpServiceImpl.class, "alterarSaidaEstudo");

        return saidaEstudoToBean.convert(tbSaidaEstudo);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void excluirSaidaEstudo(Long idSaidaEstudo) throws EstudoZolpException {

        // Logging de entrada
        LogManager.log(Level.INFO, TipoLog.ENTRADA, EstudoZolpServiceImpl.class, "excluirSaidaEstudo");

        LogManager.logDetalhe(Level.INFO, EstudoZolpServiceImpl.class, "excluirSaidaEstudo",
            " Dados entrada [ " + idSaidaEstudo + " ].");

        LogManager.logDetalhe(Level.INFO, EstudoZolpServiceImpl.class, "excluirSaidaEstudo",
            " Efetuando a consulta das informacoes.");

        Optional<TbSaidaEstudo> retorno;
        try {
            retorno = saidaEstudoRepository.findById(idSaidaEstudo);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, EstudoZolpServiceImpl.class, "excluirSaidaEstudo",
                " Erro ao verificar a existencia do registro.", e);
            throw new PersistenciaException("Erro ao verificar a existencia do registro.", e);
        }

        if (!retorno.isPresent()) {
            throw new RegistroNaoLocalizadoException("O registro nao foi localizado na base de dados.");
        }

        // Obtem informacao da base
        TbSaidaEstudo saidaEstudoCadastrado = retorno.get();

        // Efetiva a exclusao do usuario
        try {
            saidaEstudoRepository.delete(saidaEstudoCadastrado);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, EstudoZolpServiceImpl.class, "excluirSaidaEstudo",
                " Erro ao efetuar a exclusao das informacoes.", e);
            throw new PersistenciaException("Erro ao efetuar a exclusao das informacoes.", e);
        }

        // Logging de saida
        LogManager.log(Level.INFO, TipoLog.SAIDA, EstudoZolpServiceImpl.class, "excluirSaidaEstudo");

    }

}
