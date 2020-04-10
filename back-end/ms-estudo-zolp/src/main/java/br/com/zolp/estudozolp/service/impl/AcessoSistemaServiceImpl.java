package br.com.zolp.estudozolp.service.impl;

import br.com.zolp.estudozolp.bean.PerfilAcesso;
import br.com.zolp.estudozolp.bean.UsuarioSistema;
import br.com.zolp.estudozolp.bean.filtro.FiltroConsultaPerfilAcesso;
import br.com.zolp.estudozolp.bean.filtro.FiltroConsultaUsuario;
import br.com.zolp.estudozolp.converters.*;
import br.com.zolp.estudozolp.entity.TbPerfilAcesso;
import br.com.zolp.estudozolp.entity.TbUsuarioSistema;
import br.com.zolp.estudozolp.exception.EstudoZolpException;
import br.com.zolp.estudozolp.exception.PersistenciaException;
import br.com.zolp.estudozolp.exception.RegistroNaoLocalizadoException;
import br.com.zolp.estudozolp.log.LogManager;
import br.com.zolp.estudozolp.repository.PerfilAcessoRepository;
import br.com.zolp.estudozolp.repository.UsuarioSistemaRepository;
import br.com.zolp.estudozolp.service.AcessoSistemaService;
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
 * das informações referente ao acesso no sistema.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Service
@Transactional
public class AcessoSistemaServiceImpl implements AcessoSistemaService {

    @Autowired
    private UsuarioSistemaRepository usuarioSistemaRepository;

    @Autowired
    private UsuarioSistemaToBean usuarioSistemaToBean;

    @Autowired
    private UsuarioSistemaToEntity usuarioSistemaToEntity;

    @Autowired
    private PerfilAcessoRepository perfilAcessoRepository;

    @Autowired
    private PerfilAcessoToBean perfilAcessoToBean;

    @Autowired
    private PerfilAcessoToEntity perfilAcessoToEntity;

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


    // --- CADASTRO DE USUARIO ------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public UsuarioSistema obterUsuario(Long idUsuario) throws EstudoZolpException {

        // logging de entrada
        LogManager.log(Level.INFO, TipoLog.ENTRADA, AcessoSistemaServiceImpl.class, "obterUsuario");

        LogManager.logDetalhe(Level.INFO, AcessoSistemaServiceImpl.class, "obterUsuario",
            " Efetuando a consulta [ idUsuario: " + idUsuario + " ].");

        // Busca o registro
        Optional<TbUsuarioSistema> retorno;
        try {
            retorno = usuarioSistemaRepository.findById(idUsuario);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, AcessoSistemaServiceImpl.class, "obterUsuario",
                " Erro ao efetuar a consulta das informações. ", e);
            throw new PersistenciaException("Erro ao efetuar a consulta das informacaoes.", e);
        }

        // Converte o entity
        UsuarioSistema usuarioSistema = null;

        if (retorno.isPresent()) {
            try {
                usuarioSistema = usuarioSistemaToBean.convert(retorno.get());
            } catch (Exception e) {
                LogManager.logDetalhe(Level.ERROR, AcessoSistemaServiceImpl.class, "obterUsuario",
                    " Erro ao efetuar a conversao dos dados.", e);
                throw new EstudoZolpException("Erro ao efetuar a conversao dos dados.");
            }
        }

        // Logging de saida
        LogManager.log(Level.INFO, TipoLog.SAIDA, AcessoSistemaServiceImpl.class, "obterUsuario");

        return usuarioSistema;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UsuarioSistema> consultarUsuario(FiltroConsultaUsuario filtro) throws EstudoZolpException {

        // logging de entrada
        LogManager.log(Level.INFO, TipoLog.ENTRADA, AcessoSistemaServiceImpl.class, "consultarUsuario");

        LogManager.logDetalhe(Level.INFO, AcessoSistemaServiceImpl.class, "consultarUsuario",
            " Efetuando a consulta [ " + filtro + " ].");

        // Valida se o filtro foi preenchido
        if (Eval.isNull(filtro) || Eval.isAllEmpty(filtro.getId(), filtro.getDescricao())) {
            LogManager.logDetalhe(Level.ERROR, AcessoSistemaServiceImpl.class, "consultarUsuario",
                " Nenhum dado informado nos filtros.");

            throw new EstudoZolpException("Nenhum dado informado nos filtros.");
        }

        // Busca os registros de usuario
        final List<UsuarioSistema> listUsuario = new ArrayList<>();

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
                .forEach(object -> listUsuario
                .add(usuarioSistemaToBean.convert((Object[]) object)));

        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, AcessoSistemaServiceImpl.class, "consultarUsuario",
                " Erro ao efetuar a consulta das informacoes [" + " Consulta SQL: '" + sqlSelect
                + "' ].", e);
            throw new PersistenciaException("Erro ao efetuar a consulta das informacoes.", e);
        }

        // Logging de saida
        LogManager.log(Level.INFO, TipoLog.SAIDA, AcessoSistemaServiceImpl.class, "consultarUsuario");

        return listUsuario;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void incluirUsuario(UsuarioSistema usuarioSistema) throws EstudoZolpException {

        // Logging de entrada
        LogManager.log(Level.INFO, TipoLog.ENTRADA, AcessoSistemaServiceImpl.class, "incluirUsuario");

        // Remove o Id para que o mesmo obtenha um novo sequencial
        usuarioSistema.setIdUsuario(null);

        LogManager.logDetalhe(Level.INFO, AcessoSistemaServiceImpl.class, "incluirUsuario",
            " Dados entrada [ " + usuarioSistema + " ].");

        TbUsuarioSistema tbUsuarioSistema;

        // Efetua a conversao
        try {
            tbUsuarioSistema = usuarioSistemaToEntity.convert(usuarioSistema);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, AcessoSistemaServiceImpl.class, "incluirUsuario",
                " Erro ao efetuar a conversao dos dados.", e);
            throw new EstudoZolpException("Erro ao efetuar a conversao dos dados [ "
                + usuarioSistema + " ].");
        }

        // Inclui na base de dados
        try {
            usuarioSistemaRepository.save(tbUsuarioSistema);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, AcessoSistemaServiceImpl.class, "incluirUsuario",
                " Erro ao efetuar a inclusao das informacoes.", e);
            throw new PersistenciaException("Erro ao efetuar a inclusao das informacoes.", e);
        }

        // Logging de saida
        LogManager.log(Level.INFO, TipoLog.SAIDA, AcessoSistemaServiceImpl.class, "incluirUsuario");

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsuarioSistema alterarUsuario(UsuarioSistema usuarioSistema) throws EstudoZolpException,
        RegistroNaoLocalizadoException, PersistenciaException {

        // Logging de entrada
        LogManager.log(Level.INFO, TipoLog.ENTRADA, AcessoSistemaServiceImpl.class, "alteraUsuario");

        LogManager.logDetalhe(Level.INFO, AcessoSistemaServiceImpl.class, "alteraUsuario",
            " Dados entrada [ " + usuarioSistema + " ].");

        LogManager.logDetalhe(Level.INFO, AcessoSistemaServiceImpl.class, "alteraUsuario",
            " Efetuando a consulta das informacoes.");

        // Efetua a busca do usuario
        Optional<TbUsuarioSistema> retorno;
        try {
            retorno = usuarioSistemaRepository.findById(usuarioSistema.getIdUsuario());
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, AcessoSistemaServiceImpl.class, "alteraUsuario",
                " Erro ao verificar a existencia do registro.", e);
            throw new PersistenciaException("Erro ao verificar a existencia do registro.", e);
        }

        if (!retorno.isPresent()) {
            throw new RegistroNaoLocalizadoException("O registro nao foi localizado na base de dados.");
        }

        // obtem a entity recuperada da base,
        TbUsuarioSistema usuarioCadastrado = retorno.get();

        usuarioCadastrado.setIdUnidadePesquisa(usuarioSistema.getIdUnidadePesquisa());
        usuarioCadastrado.setIdPerfil(usuarioSistema.getIdPerfil());
        usuarioCadastrado.setUsername(usuarioSistema.getUsername());
        usuarioCadastrado.setNome(usuarioSistema.getNome());
        usuarioCadastrado.setEmail(usuarioSistema.getEmail());
        usuarioCadastrado.setFone(usuarioSistema.getFone());

        // Efetiva a atualizacao (update) na base oracle
        try {
            usuarioSistemaRepository.save(usuarioCadastrado);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, AcessoSistemaServiceImpl.class, "alteraUsuario",
                " Erro ao efetuar a atualizacao das informacoes.", e);
            throw new PersistenciaException("Erro ao efetuar a atualizacao das informacoes.", e);
        }

        // Logging de saida
        LogManager.log(Level.INFO, TipoLog.SAIDA, AcessoSistemaServiceImpl.class, "alteraUsuario");

        return usuarioSistemaToBean.convert(usuarioCadastrado);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void excluirUsuario(Long idUsuario) throws EstudoZolpException {

        // Logging de entrada
        LogManager.log(Level.INFO, TipoLog.ENTRADA, AcessoSistemaServiceImpl.class, "excluiUsuario");

        LogManager.logDetalhe(Level.INFO, AcessoSistemaServiceImpl.class, "excluiUsuario",
            " Dados entrada [ " + idUsuario + " ].");

        LogManager.logDetalhe(Level.INFO, AcessoSistemaServiceImpl.class, "excluiUsuario",
            " Efetuando a consulta das informacoes.");

        Optional<TbUsuarioSistema> retorno;
        try {
            retorno = usuarioSistemaRepository.findById(idUsuario);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, AcessoSistemaServiceImpl.class, "excluiUsuario",
                " Erro ao verificar a existencia do registro.", e);
            throw new PersistenciaException("Erro ao verificar a existencia do registro.", e);
        }

        if (!retorno.isPresent()) {
            throw new RegistroNaoLocalizadoException("O registro nao foi localizado na base de dados.");
        }

        // Obtem informacao da base
        TbUsuarioSistema usuarioCadastrado = retorno.get();

        // Efetiva a exclusao do usuario
        try {
            usuarioSistemaRepository.delete(usuarioCadastrado);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, AcessoSistemaServiceImpl.class, "excluiUsuario",
                " Erro ao efetuar a exclusao das informacoes.", e);
            throw new PersistenciaException("Erro ao efetuar a exclusao das informacoes.", e);
        }

        // Logging de saida
        LogManager.log(Level.INFO, TipoLog.SAIDA, AcessoSistemaServiceImpl.class, "excluiUsuario");

    }

    // --- CADASTO DE PERFIL --------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public PerfilAcesso obterPerfil(Long idPerfil) throws EstudoZolpException {

        // Logging de entrada
        LogManager.log(Level.INFO, TipoLog.ENTRADA, AcessoSistemaServiceImpl.class, "obterPerfil");

        LogManager.logDetalhe(Level.INFO, AcessoSistemaServiceImpl.class, "obterPerfil",
            " Efetuando a consulta [ idPerfil: " + idPerfil + " ]");

        // Busca o registro
        Optional<TbPerfilAcesso> retorno;
        try {
            retorno = perfilAcessoRepository.findById(idPerfil);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, AcessoSistemaServiceImpl.class, "obterPerfil",
                " Erro ao efetuar a consulta das informações. ", e);
            throw new PersistenciaException("Erro ao efetuar a consulta das informacaoes.", e);
        }

        // Converte o entity
        PerfilAcesso perfilAcesso = null;

        if (retorno.isPresent()) {
            try {
                perfilAcesso = perfilAcessoToBean.convert(retorno.get());
            } catch (Exception e) {
                LogManager.logDetalhe(Level.ERROR, AcessoSistemaServiceImpl.class, "obterPerfil",
                    " Erro ao efetuar a conversao dos dados.", e);
                throw new EstudoZolpException("Erro ao efetuar a conversao dos dados.");
            }
        }

        // Logging de saida
        LogManager.log(Level.INFO, TipoLog.SAIDA, AcessoSistemaServiceImpl.class, "obterPerfil");

        return perfilAcesso;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<PerfilAcesso> consultarPerfil(FiltroConsultaPerfilAcesso filtro) throws EstudoZolpException {

        // logging de entrada
        LogManager.log(Level.INFO, TipoLog.ENTRADA, AcessoSistemaServiceImpl.class, "consultarPerfil");

        LogManager.logDetalhe(Level.INFO, AcessoSistemaServiceImpl.class, "consultarPerfil",
                " Efetuando a consulta [ " + filtro + " ].");

        // Valida se o filtro foi preenchido
        if (Eval.isNull(filtro) || Eval.isAllEmpty(filtro.getId(), filtro.getDescricao())) {
            LogManager.logDetalhe(Level.ERROR, AcessoSistemaServiceImpl.class, "consultarPerfil",
                    " Nenhum dado informado nos filtros.");

            throw new EstudoZolpException("Nenhum dado informado nos filtros.");
        }

        // Busca os registros de usuario
        final List<PerfilAcesso> listPerfil = new ArrayList<>();

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
                .forEach(object -> listPerfil
                .add(perfilAcessoToBean.convert((Object[]) object)));

        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, AcessoSistemaServiceImpl.class, "consultarPerfil",
                    " Erro ao efetuar a consulta das informacoes [" + " Consulta SQL: '" + sqlSelect
                            + "' ].", e);
            throw new PersistenciaException("Erro ao efetuar a consulta das informacoes.", e);
        }

        // Logging de saida
        LogManager.log(Level.INFO, TipoLog.SAIDA, AcessoSistemaServiceImpl.class, "consultarPerfil");

        return listPerfil;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void incluirPerfil(PerfilAcesso perfilAcesso) throws EstudoZolpException {

        // Logging de entrada
        LogManager.log(Level.INFO, TipoLog.ENTRADA, AcessoSistemaServiceImpl.class, "incluirPerfil");

        // Remove o Id para que o mesmo obtenha um novo sequencial
        perfilAcesso.setIdPerfilAcesso(null);

        LogManager.logDetalhe(Level.INFO, AcessoSistemaServiceImpl.class, "incluirPerfil",
            " Dados entrada [ " + perfilAcesso + " ].");

        // Entity para o insert
        TbPerfilAcesso tbPerfilAcesso;

        // Efetua a conversao
        try {
            tbPerfilAcesso = perfilAcessoToEntity.convert(perfilAcesso);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, AcessoSistemaServiceImpl.class, "incluirPerfil",
                " Erro ao efetuar a conversao dos dados.", e);
            throw new EstudoZolpException("Erro ao efetuar a conversao dos dados [ "
                + perfilAcesso + " ].");
        }

        // Efetiva a inclusao das informacoes
        try {
            perfilAcessoRepository.save(tbPerfilAcesso);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, AcessoSistemaServiceImpl.class, "incluirPerfil",
                " Erro ao efetuar a inclusao das informacoes.", e);
            throw new PersistenciaException("Erro ao efetuar a inclusao das informacoes.", e);
        }

        // Logging de saida
        LogManager.log(Level.INFO, TipoLog.SAIDA, AcessoSistemaServiceImpl.class, "incluirPerfil");

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PerfilAcesso alterarPerfil(PerfilAcesso perfilAcesso) throws EstudoZolpException,
        RegistroNaoLocalizadoException, PersistenciaException {

        // Logging de entrada
        LogManager.log(Level.INFO, TipoLog.ENTRADA, AcessoSistemaServiceImpl.class, "alteraPerfil");

        LogManager.logDetalhe(Level.INFO, AcessoSistemaServiceImpl.class, "alteraPerfil",
            " Dados entrada [ " + perfilAcesso + " ].");

        LogManager.logDetalhe(Level.INFO, AcessoSistemaServiceImpl.class, "alteraPerfil",
            " Efetuando a consulta das informacoes.");

        Optional<TbPerfilAcesso> retorno;
        try {
            retorno = perfilAcessoRepository.findById(perfilAcesso.getIdPerfilAcesso());
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, AcessoSistemaServiceImpl.class, "alteraPerfil",
                " Erro ao verificar a existencia do registro.", e);
            throw new PersistenciaException("Erro ao verificar a existencia do registro.", e);
        }

        if (!retorno.isPresent()) {
            throw new RegistroNaoLocalizadoException("O registro nao foi localizado na base de dados.");
        }

        // Obtem a entity recuperada da base
        TbPerfilAcesso perfilCadastrado = retorno.get();

        perfilCadastrado.setIdPerfilAcesso(perfilAcesso.getIdPerfilAcesso());
        perfilCadastrado.setDsPerfil(perfilAcesso.getDsPerfil());

        // Efetiva a atualizacao
        try {
            perfilAcessoRepository.save(perfilCadastrado);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, AcessoSistemaServiceImpl.class, "alteraPerfil",
                " Erro ao efetuar a atualizacao das informacoes.", e);
            throw new PersistenciaException("Erro ao efetuar a atualizacao das informacoes.", e);
        }

        // Logging de saida
        LogManager.log(Level.INFO, TipoLog.SAIDA, AcessoSistemaServiceImpl.class, "alteraPerfil");

        return perfilAcessoToBean.convert(perfilCadastrado);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void excluirPerfil(Long idPerfil) throws EstudoZolpException {

        // Logging de entrada
        LogManager.log(Level.INFO, TipoLog.ENTRADA, AcessoSistemaServiceImpl.class, "excluiPerfil");

        LogManager.logDetalhe(Level.INFO, AcessoSistemaServiceImpl.class, "excluiPerfil",
            " Dados entrada [ " + idPerfil + " ].");

        LogManager.logDetalhe(Level.INFO, AcessoSistemaServiceImpl.class, "excluiPerfil",
            " Efetuando a consulta das informacoes.");

        Optional<TbPerfilAcesso> retorno;
        try {
            retorno = perfilAcessoRepository.findById(idPerfil);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, AcessoSistemaServiceImpl.class, "excluiPerfil",
                " Erro ao verificar a existencia do registro.", e);
            throw new PersistenciaException("Erro ao verificar a existencia do registro.", e);
        }

        if (!retorno.isPresent()) {
            throw new RegistroNaoLocalizadoException("O registro de Perfil nao foi localizado na base de dados.");
        }

        // Obtem informacao da base
        TbPerfilAcesso perfilCadastrado = retorno.get();

        // Efetua a exclusao do perfil da base de dados
        try {
            perfilAcessoRepository.delete(perfilCadastrado);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, AcessoSistemaServiceImpl.class, "excluiPerfil",
                " Erro ao efetuar a exclusao das informacoes.", e);
            throw new PersistenciaException("Erro ao efetuar a exclusao das informacoes.", e);
        }

        // Logging de saida
        LogManager.log(Level.INFO, TipoLog.SAIDA, AcessoSistemaServiceImpl.class, "excluiPerfil");

    }

}
