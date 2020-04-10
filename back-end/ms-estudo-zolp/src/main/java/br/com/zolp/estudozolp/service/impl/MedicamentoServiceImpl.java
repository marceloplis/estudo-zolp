package br.com.zolp.estudozolp.service.impl;

import br.com.zolp.estudozolp.bean.*;
import br.com.zolp.estudozolp.bean.filtro.FiltroDoencaEvento;
import br.com.zolp.estudozolp.bean.filtro.FiltroEventoAdverso;
import br.com.zolp.estudozolp.bean.filtro.FiltroGrupoMedicamento;
import br.com.zolp.estudozolp.bean.filtro.FiltroMedicamento;
import br.com.zolp.estudozolp.converters.*;
import br.com.zolp.estudozolp.entity.TbDoencaEvento;
import br.com.zolp.estudozolp.entity.TbEventoAdverso;
import br.com.zolp.estudozolp.entity.TbGrupoMedicamento;
import br.com.zolp.estudozolp.entity.TbMedicamento;
import br.com.zolp.estudozolp.exception.EstudoZolpException;
import br.com.zolp.estudozolp.exception.PersistenciaException;
import br.com.zolp.estudozolp.exception.RegistroNaoLocalizadoException;
import br.com.zolp.estudozolp.log.LogManager;
import br.com.zolp.estudozolp.repository.DoencaEventoRepository;
import br.com.zolp.estudozolp.repository.EventoAdversoRepository;
import br.com.zolp.estudozolp.repository.GrupoMedicamentoRepository;
import br.com.zolp.estudozolp.repository.MedicamentoRepository;
import br.com.zolp.estudozolp.service.MedicamentoService;
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
 * das informações referente a Medicamento, GrupoMedicamento, EventoAdverso e DoencaEvento.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Service
@Transactional
public class MedicamentoServiceImpl implements MedicamentoService {

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    @Autowired
    private MedicamentoToBean medicamentoToBean;

    @Autowired
    private MedicamentoToEntity medicamentoToEntity;

    @Autowired
    private GrupoMedicamentoRepository grupoMedicamentoRepository;

    @Autowired
    private GrupoMedicamentoToBean grupoMedicamentoToBean;

    @Autowired
    private GrupoMedicamentoToEntity grupoMedicamentoToEntity;

    @Autowired
    private EventoAdversoRepository eventoAdversoRepository;

    @Autowired
    private EventoAdversoToBean eventoAdversoToBean;

    @Autowired
    private EventoAdversoToEntity eventoAdversoToEntity;

    @Autowired
    private DoencaEventoRepository doencaEventoRepository;

    @Autowired
    private DoencaEventoToBean doencaEventoToBean;

    @Autowired
    private DoencaEventoToEntity doencaEventoToEntity;

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

    // --- CADASTRO DE MEDICAMENTO ------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Medicamento obterMedicamento(Long idMedicamento) throws EstudoZolpException {

        // Logging de entrada
        LogManager.log(Level.INFO, TipoLog.ENTRADA, MedicamentoServiceImpl.class, "obterMedicamento");

        LogManager.logDetalhe(Level.INFO, MedicamentoServiceImpl.class, "obterMedicamento",
            " Efetuando a consulta [ idMedicamento: " + idMedicamento + " ].");

        // Busca o registro
        Optional<TbMedicamento> retorno;
        try {
            retorno = medicamentoRepository.findById(idMedicamento);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, MedicamentoServiceImpl.class, "obterMedicamento",
                " Erro ao efetuar a consulta das informações. ", e);
            throw new PersistenciaException("Erro ao efetuar a consulta das informacaoes.", e);
        }

        // Converte o entity
        Medicamento medicamento = null;

        if (retorno.isPresent()) {
            try {
                medicamento = medicamentoToBean.convert(retorno.get());
            } catch (Exception e) {
                LogManager.logDetalhe(Level.ERROR, MedicamentoServiceImpl.class, "obterMedicamento",
                    " Erro ao efetuar a conversao dos dados.", e);
                throw new EstudoZolpException("Erro ao efetuar a conversao dos dados.");
            }
        }

        // Logging de saida
        LogManager.log(Level.INFO, TipoLog.SAIDA, MedicamentoServiceImpl.class, "obterMedicamento");

        return medicamento;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Medicamento> consultarMedicamento(FiltroMedicamento filtro) throws EstudoZolpException {

        // Logging de entrada
        LogManager.log(Level.INFO, TipoLog.ENTRADA, MedicamentoServiceImpl.class, "consultarMedicamento");

        LogManager.logDetalhe(Level.INFO, MedicamentoServiceImpl.class, "consultarMedicamento",
            " Efetuando a consulta [ " + filtro + " ].");

        // Valida se o filtro foi preenchido
        if (Eval.isNull(filtro) || Eval.isAllEmpty(filtro.getId(), filtro.getDescricao())) {
            LogManager.logDetalhe(Level.ERROR, MedicamentoServiceImpl.class, "consultarMedicamento",
                " Nenhum dado informado nos filtros.");

            throw new EstudoZolpException("Nenhum dado informado nos filtros.");
        }

        // Busca os registros de usuario
        final List<Medicamento> listMedicamento = new ArrayList<>();

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
                .forEach(object -> listMedicamento
                .add(medicamentoToBean.convert((Object[]) object)));

        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, MedicamentoServiceImpl.class, "consultarMedicamento",
                " Erro ao efetuar a consulta das informacoes [" + " Consulta SQL: '" + sqlSelect
                + "' ].", e);
            throw new PersistenciaException("Erro ao efetuar a consulta das informacoes.", e);
        }

        // Logging de saida
        LogManager.log(Level.INFO, TipoLog.SAIDA, MedicamentoServiceImpl.class, "consultarMedicamento");

        return listMedicamento;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Medicamento incluirMedicamento(Medicamento medicamento) throws EstudoZolpException {

        // Logging de entrada
        LogManager.log(Level.INFO, TipoLog.ENTRADA, MedicamentoServiceImpl.class, "incluirMedicamento");

        LogManager.logDetalhe(Level.INFO, MedicamentoServiceImpl.class, "incluirMedicamento",
            " Dados entrada [ " + medicamento + " ].");

        TbMedicamento tbMedicamento;

        // Efetua a conversao
        try {
            tbMedicamento = medicamentoToEntity.convert(medicamento);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, MedicamentoServiceImpl.class, "incluirMedicamento",
                " Erro ao efetuar a conversao dos dados.", e);
            throw new EstudoZolpException("Erro ao efetuar a conversao dos dados [ "
                + medicamento + " ].");
        }

        // Inclui na base de dados
        try {
            medicamentoRepository.save(tbMedicamento);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, MedicamentoServiceImpl.class, "incluirMedicamento",
                " Erro ao efetuar a inclusao das informacoes.", e);
            throw new PersistenciaException("Erro ao efetuar a inclusao das informacoes.", e);
        }

        // Logging de saida
        LogManager.log(Level.INFO, TipoLog.SAIDA, MedicamentoServiceImpl.class, "incluirMedicamento");

        return medicamento;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Medicamento alterarMedicamento(Medicamento medicamento) throws EstudoZolpException,
        RegistroNaoLocalizadoException, PersistenciaException {

        // Logging de entrada
        LogManager.log(Level.INFO, TipoLog.ENTRADA, MedicamentoServiceImpl.class, "alterarMedicamento");

        LogManager.logDetalhe(Level.INFO, MedicamentoServiceImpl.class, "alterarMedicamento",
            " Dados entrada [ " + medicamento + " ].");

        LogManager.logDetalhe(Level.INFO, MedicamentoServiceImpl.class, "alterarMedicamento",
            " Efetuando a consulta das informacoes.");

        // Efetua a busca do usuario
        Optional<TbMedicamento> retorno;
        try {
            retorno = medicamentoRepository.findById(medicamento.getIdMedicamento());
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, MedicamentoServiceImpl.class, "alterarMedicamento",
                " Erro ao verificar a existencia do registro.", e);
            throw new PersistenciaException("Erro ao verificar a existencia do registro.", e);
        }

        if (!retorno.isPresent()) {
            throw new RegistroNaoLocalizadoException("O registro nao foi localizado na base de dados.");
        }

        // Obtem a entity recuperada da base
        TbMedicamento tbMedicamento = retorno.get();

        tbMedicamento.setIdGrupoMedicamento(medicamento.getIdGrupoMedicamento());
        tbMedicamento.setDsMedicamento(medicamento.getDsMedicamento());

        // Efetiva a atualizacao (update) na base oracle
        try {
            medicamentoRepository.save(tbMedicamento);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, MedicamentoServiceImpl.class, "alterarMedicamento",
                " Erro ao efetuar a atualizacao das informacoes.", e);
            throw new PersistenciaException("Erro ao efetuar a atualizacao das informacoes.", e);
        }

        // Logging de saida
        LogManager.log(Level.INFO, TipoLog.SAIDA, MedicamentoServiceImpl.class, "alterarMedicamento");

        return medicamentoToBean.convert(tbMedicamento);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void excluirMedicamento(Long idMedicamento) throws EstudoZolpException {

        // Logging de entrada
        LogManager.log(Level.INFO, TipoLog.ENTRADA, MedicamentoServiceImpl.class, "excluirMedicamento");

        LogManager.logDetalhe(Level.INFO, MedicamentoServiceImpl.class, "excluirMedicamento",
            " Dados entrada [ " + idMedicamento + " ].");

        LogManager.logDetalhe(Level.INFO, MedicamentoServiceImpl.class, "excluirMedicamento",
            " Efetuando a consulta das informacoes.");

        Optional<TbMedicamento> retorno;
        try {
            retorno = medicamentoRepository.findById(idMedicamento);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, MedicamentoServiceImpl.class, "excluirMedicamento",
                " Erro ao verificar a existencia do registro.", e);
            throw new PersistenciaException("Erro ao verificar a existencia do registro.", e);
        }

        if (!retorno.isPresent()) {
            throw new RegistroNaoLocalizadoException("O registro nao foi localizado na base de dados.");
        }

        // Obtem informacao da base
        TbMedicamento medicamentoCadastrado = retorno.get();

        // Efetiva a exclusao do usuario
        try {
            medicamentoRepository.delete(medicamentoCadastrado);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, MedicamentoServiceImpl.class, "excluirMedicamento",
                " Erro ao efetuar a exclusao das informacoes.", e);
            throw new PersistenciaException("Erro ao efetuar a exclusao das informacoes.", e);
        }

        // Logging de saida
        LogManager.log(Level.INFO, TipoLog.SAIDA, MedicamentoServiceImpl.class, "excluirMedicamento");

    }

    // --- CADASTRO DE GRUPO MEDICAMENTO ------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public GrupoMedicamento obterGrupoMedicamento(Long idGrupoMedicamento) throws EstudoZolpException {

        // Logging de entrada
        LogManager.log(Level.INFO, TipoLog.ENTRADA, MedicamentoServiceImpl.class, "obterGrupoMedicamento");

        LogManager.logDetalhe(Level.INFO, MedicamentoServiceImpl.class, "obterGrupoMedicamento",
            " Efetuando a consulta [ idPaciente: " + idGrupoMedicamento + " ].");

        // Busca o registro
        Optional<TbGrupoMedicamento> retorno;
        try {
            retorno = grupoMedicamentoRepository.findById(idGrupoMedicamento);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, MedicamentoServiceImpl.class, "obterGrupoMedicamento",
                " Erro ao efetuar a consulta das informações. ", e);
            throw new PersistenciaException("Erro ao efetuar a consulta das informacaoes.", e);
        }

        // Converte o entity
        GrupoMedicamento grupoMedicamento = null;

        if (retorno.isPresent()) {
            try {
                grupoMedicamento = grupoMedicamentoToBean.convert(retorno.get());
            } catch (Exception e) {
                LogManager.logDetalhe(Level.ERROR, MedicamentoServiceImpl.class, "obterGrupoMedicamento",
                    " Erro ao efetuar a conversao dos dados.", e);
                throw new EstudoZolpException("Erro ao efetuar a conversao dos dados.");
            }
        }

        // Logging de saida
        LogManager.log(Level.INFO, TipoLog.SAIDA, MedicamentoServiceImpl.class, "obterGrupoMedicamento");

        return grupoMedicamento;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<GrupoMedicamento> consultarGrupoMedicamento(FiltroGrupoMedicamento filtro) throws EstudoZolpException {

        // Logging de entrada
        LogManager.log(Level.INFO, TipoLog.ENTRADA, MedicamentoServiceImpl.class, "consultarGrupoMedicamento");

        LogManager.logDetalhe(Level.INFO, MedicamentoServiceImpl.class, "consultarGrupoMedicamento",
            " Efetuando a consulta [ " + filtro + " ].");

        // Valida se o filtro foi preenchido
        if (Eval.isNull(filtro) || Eval.isAllEmpty(filtro.getId(), filtro.getDescricao())) {
            LogManager.logDetalhe(Level.ERROR, MedicamentoServiceImpl.class, "consultarGrupoMedicamento",
                " Nenhum dado informado nos filtros.");

            throw new EstudoZolpException("Nenhum dado informado nos filtros.");
        }

        // Busca os registros de usuario
        final List<GrupoMedicamento> listGrupoMedicamento = new ArrayList<>();

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
                .forEach(object -> listGrupoMedicamento
                .add(grupoMedicamentoToBean.convert((Object[]) object)));

        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, MedicamentoServiceImpl.class, "consultarGrupoMedicamento",
                " Erro ao efetuar a consulta das informacoes [" + " Consulta SQL: '" + sqlSelect
                + "' ].", e);
            throw new PersistenciaException("Erro ao efetuar a consulta das informacoes.", e);
        }

        // Logging de saida
        LogManager.log(Level.INFO, TipoLog.SAIDA, MedicamentoServiceImpl.class, "consultarGrupoMedicamento");

        return listGrupoMedicamento;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GrupoMedicamento incluirGrupoMedicamento(GrupoMedicamento grupoMedicamento) throws EstudoZolpException {

        // Logging de entrada
        LogManager.log(Level.INFO, TipoLog.ENTRADA, MedicamentoServiceImpl.class, "incluirGrupoMedicamento");

        LogManager.logDetalhe(Level.INFO, MedicamentoServiceImpl.class, "incluirGrupoMedicamento",
            " Dados entrada [ " + grupoMedicamento + " ].");

        TbGrupoMedicamento tbGrupoMedicamento;

        // Efetua a conversao
        try {
            tbGrupoMedicamento = grupoMedicamentoToEntity.convert(grupoMedicamento);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, MedicamentoServiceImpl.class, "incluirGrupoMedicamento",
                " Erro ao efetuar a conversao dos dados.", e);
            throw new EstudoZolpException("Erro ao efetuar a conversao dos dados [ "
                + grupoMedicamento + " ].");
        }

        // Inclui na base de dados
        try {
            grupoMedicamentoRepository.save(tbGrupoMedicamento);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, MedicamentoServiceImpl.class, "incluirGrupoMedicamento",
                " Erro ao efetuar a inclusao das informacoes.", e);
            throw new PersistenciaException("Erro ao efetuar a inclusao das informacoes.", e);
        }

        // Logging de saida
        LogManager.log(Level.INFO, TipoLog.SAIDA, MedicamentoServiceImpl.class, "incluirGrupoMedicamento");

        return grupoMedicamento;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GrupoMedicamento alterarGrupoMedicamento(GrupoMedicamento grupoMedicamento) throws EstudoZolpException,
        RegistroNaoLocalizadoException, PersistenciaException {

        // Logging de entrada
        LogManager.log(Level.INFO, TipoLog.ENTRADA, MedicamentoServiceImpl.class, "alterarGrupoMedicamento");

        LogManager.logDetalhe(Level.INFO, MedicamentoServiceImpl.class, "alterarGrupoMedicamento",
            " Dados entrada [ " + grupoMedicamento + " ].");

        LogManager.logDetalhe(Level.INFO, MedicamentoServiceImpl.class, "alterarGrupoMedicamento",
            " Efetuando a consulta das informacoes.");

        // Efetua a busca do usuario
        Optional<TbGrupoMedicamento> retorno;
        try {
            retorno = grupoMedicamentoRepository.findById(grupoMedicamento.getIdGrupoMedicamento());
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, MedicamentoServiceImpl.class, "alterarGrupoMedicamento",
                " Erro ao verificar a existencia do registro.", e);
            throw new PersistenciaException("Erro ao verificar a existencia do registro.", e);
        }

        if (!retorno.isPresent()) {
            throw new RegistroNaoLocalizadoException("O registro nao foi localizado na base de dados.");
        }

        // Obtem a entity recuperada da base
        TbGrupoMedicamento tbGrupoMedicamento = retorno.get();

        tbGrupoMedicamento.setDsGrupoMedicamento(grupoMedicamento.getDsGrupoMedicamento());

        // Efetiva a atualizacao (update) na base oracle
        try {
            grupoMedicamentoRepository.save(tbGrupoMedicamento);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, MedicamentoServiceImpl.class, "alterarGrupoMedicamento",
                " Erro ao efetuar a atualizacao das informacoes.", e);
            throw new PersistenciaException("Erro ao efetuar a atualizacao das informacoes.", e);
        }

        // Logging de saida
        LogManager.log(Level.INFO, TipoLog.SAIDA, MedicamentoServiceImpl.class, "alterarGrupoMedicamento");

        return grupoMedicamentoToBean.convert(tbGrupoMedicamento);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void excluirGrupoMedicamento(Long idGrupoMedicamento) throws EstudoZolpException {

        // Logging de entrada
        LogManager.log(Level.INFO, TipoLog.ENTRADA, MedicamentoServiceImpl.class, "excluirGrupoMedicamento");

        LogManager.logDetalhe(Level.INFO, MedicamentoServiceImpl.class, "excluirGrupoMedicamento",
            " Dados entrada [ " + idGrupoMedicamento + " ].");

        LogManager.logDetalhe(Level.INFO, MedicamentoServiceImpl.class, "excluirGrupoMedicamento",
            " Efetuando a consulta das informacoes.");

        Optional<TbGrupoMedicamento> retorno;
        try {
            retorno = grupoMedicamentoRepository.findById(idGrupoMedicamento);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, MedicamentoServiceImpl.class, "excluirGrupoMedicamento",
                " Erro ao verificar a existencia do registro.", e);
            throw new PersistenciaException("Erro ao verificar a existencia do registro.", e);
        }

        if (!retorno.isPresent()) {
            throw new RegistroNaoLocalizadoException("O registro nao foi localizado na base de dados.");
        }

        // Obtem informacao da base
        TbGrupoMedicamento grupoMedicamentoCadastrado = retorno.get();

        // Efetiva a exclusao
        try {
            grupoMedicamentoRepository.delete(grupoMedicamentoCadastrado);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, MedicamentoServiceImpl.class, "excluirGrupoMedicamento",
                " Erro ao efetuar a exclusao das informacoes.", e);
            throw new PersistenciaException("Erro ao efetuar a exclusao das informacoes.", e);
        }

        // Logging de saida
        LogManager.log(Level.INFO, TipoLog.SAIDA, MedicamentoServiceImpl.class, "excluirGrupoMedicamento");
    }

    // --- CADASTRO DE EVENTO ADVERSO ------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public EventoAdverso obterEventoAdverso(Long idEventoAdverso) throws EstudoZolpException {

        // Logging de entrada
        LogManager.log(Level.INFO, TipoLog.ENTRADA, MedicamentoServiceImpl.class, "obterEventoAdverso");

        LogManager.logDetalhe(Level.INFO, MedicamentoServiceImpl.class, "obterEventoAdverso",
            " Efetuando a consulta [ idEventoAdverso: " + idEventoAdverso + " ].");

        // Busca o registro
        Optional<TbEventoAdverso> retorno;
        try {
            retorno = eventoAdversoRepository.findById(idEventoAdverso);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, MedicamentoServiceImpl.class, "obterEventoAdverso",
                " Erro ao efetuar a consulta das informações. ", e);
            throw new PersistenciaException("Erro ao efetuar a consulta das informacaoes.", e);
        }

        // Converte o entity
        EventoAdverso eventoAdverso = null;

        if (retorno.isPresent()) {
            try {
                eventoAdverso = eventoAdversoToBean.convert(retorno.get());
            } catch (Exception e) {
                LogManager.logDetalhe(Level.ERROR, MedicamentoServiceImpl.class, "obterEventoAdverso",
                    " Erro ao efetuar a conversao dos dados.", e);
                throw new EstudoZolpException("Erro ao efetuar a conversao dos dados.");
            }
        }

        // Logging de saida
        LogManager.log(Level.INFO, TipoLog.SAIDA, MedicamentoServiceImpl.class, "obterEventoAdverso");

        return eventoAdverso;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<EventoAdverso> consultarEventoAdverso(FiltroEventoAdverso filtro) throws EstudoZolpException {

        // Logging de entrada
        LogManager.log(Level.INFO, TipoLog.ENTRADA, MedicamentoServiceImpl.class, "consultarEventoAdverso");

        LogManager.logDetalhe(Level.INFO, MedicamentoServiceImpl.class, "consultarEventoAdverso",
            " Efetuando a consulta [ " + filtro + " ].");

        // Valida se o filtro foi preenchido
        if (Eval.isNull(filtro) || Eval.isAllEmpty(filtro.getId(), filtro.getDescricao())) {
            LogManager.logDetalhe(Level.ERROR, MedicamentoServiceImpl.class, "consultarEventoAdverso",
                    " Nenhum dado informado nos filtros.");

            throw new EstudoZolpException("Nenhum dado informado nos filtros.");
        }

        // Busca os registros de usuario
        final List<EventoAdverso> listEventoAdverso = new ArrayList<>();

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
                .forEach(object -> listEventoAdverso
                .add(eventoAdversoToBean.convert((Object[]) object)));

        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, MedicamentoServiceImpl.class, "consultarEventoAdverso",
                " Erro ao efetuar a consulta das informacoes [" + " Consulta SQL: '" + sqlSelect
                + "' ].", e);
            throw new PersistenciaException("Erro ao efetuar a consulta das informacoes.", e);
        }

        // Logging de saida
        LogManager.log(Level.INFO, TipoLog.SAIDA, MedicamentoServiceImpl.class, "consultarEventoAdverso");

        return listEventoAdverso;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventoAdverso incluirEventoAdverso(EventoAdverso eventoAdverso) throws EstudoZolpException {

        // Logging de entrada
        LogManager.log(Level.INFO, TipoLog.ENTRADA, MedicamentoServiceImpl.class, "incluirEventoAdverso");

        LogManager.logDetalhe(Level.INFO, MedicamentoServiceImpl.class, "incluirEventoAdverso",
            " Dados entrada [ " + eventoAdverso + " ].");

        TbEventoAdverso tbEventoAdverso;

        // Efetua a conversao
        try {
            tbEventoAdverso = eventoAdversoToEntity.convert(eventoAdverso);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, MedicamentoServiceImpl.class, "incluirEventoAdverso",
                " Erro ao efetuar a conversao dos dados.", e);
            throw new EstudoZolpException("Erro ao efetuar a conversao dos dados [ "
                + eventoAdverso + " ].");
        }

        // Inclui na base de dados
        try {
            eventoAdversoRepository.save(tbEventoAdverso);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, MedicamentoServiceImpl.class, "incluirEventoAdverso",
                " Erro ao efetuar a inclusao das informacoes.", e);
            throw new PersistenciaException("Erro ao efetuar a inclusao das informacoes.", e);
        }

        // Logging de saida
        LogManager.log(Level.INFO, TipoLog.SAIDA, MedicamentoServiceImpl.class, "incluirEventoAdverso");

        return eventoAdverso;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventoAdverso alterarEventoAdverso(EventoAdverso eventoAdverso) throws EstudoZolpException,
        RegistroNaoLocalizadoException, PersistenciaException {

        // Logging de entrada
        LogManager.log(Level.INFO, TipoLog.ENTRADA, MedicamentoServiceImpl.class, "alterarEventoAdverso");

        LogManager.logDetalhe(Level.INFO, MedicamentoServiceImpl.class, "alterarEventoAdverso",
            " Dados entrada [ " + eventoAdverso + " ].");

        LogManager.logDetalhe(Level.INFO, MedicamentoServiceImpl.class, "alterarEventoAdverso",
            " Efetuando a consulta das informacoes.");

        // Efetua a busca do usuario
        Optional<TbEventoAdverso> retorno;
        try {
            retorno = eventoAdversoRepository.findById(eventoAdverso.getIdEventoAdverso());
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, MedicamentoServiceImpl.class, "alterarEventoAdverso",
                " Erro ao verificar a existencia do registro.", e);
            throw new PersistenciaException("Erro ao verificar a existencia do registro.", e);
        }

        if (!retorno.isPresent()) {
            throw new RegistroNaoLocalizadoException("O registro nao foi localizado na base de dados.");
        }

        // obtem a entity recuperada da base,
        TbEventoAdverso tbEventoAdverso = retorno.get();

        tbEventoAdverso.setIdEventoAdverso(eventoAdverso.getIdEventoAdverso());
        tbEventoAdverso.setIdDoenca(eventoAdverso.getIdDoenca());
        tbEventoAdverso.setIdPaciente(eventoAdverso.getIdPaciente());
        tbEventoAdverso.setDtInclusao(eventoAdverso.getDtInclusao());
        tbEventoAdverso.setDtInicio(eventoAdverso.getDtInicio());
        tbEventoAdverso.setDtFim(eventoAdverso.getDtFim());
        tbEventoAdverso.setPER_E01(eventoAdverso.getPER_E01());
        tbEventoAdverso.setPER_E02(eventoAdverso.getPER_E02());
        tbEventoAdverso.setPER_E03(eventoAdverso.getPER_E03());
        tbEventoAdverso.setPER_E04(eventoAdverso.getPER_E04());
        tbEventoAdverso.setObservacao(eventoAdverso.getObservacao());
        tbEventoAdverso.setStAprovacao(eventoAdverso.getStAprovacao());
        tbEventoAdverso.setAssinatura(eventoAdverso.getAssinatura());
        tbEventoAdverso.setDtAssinatura(eventoAdverso.getDtAssinatura());
        tbEventoAdverso.setNuVisita(eventoAdverso.getNuVisita());

        // Efetiva a atualizacao (update) na base oracle
        try {
            eventoAdversoRepository.save(tbEventoAdverso);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, MedicamentoServiceImpl.class, "alterarEventoAdverso",
                " Erro ao efetuar a atualizacao das informacoes.", e);
            throw new PersistenciaException("Erro ao efetuar a atualizacao das informacoes.", e);
        }

        // Logging de saida
        LogManager.log(Level.INFO, TipoLog.SAIDA, MedicamentoServiceImpl.class, "alterarEventoAdverso");

        return eventoAdversoToBean.convert(tbEventoAdverso);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void excluirEventoAdverso(Long idEventoAdverso) throws EstudoZolpException {

        // Logging de entrada
        LogManager.log(Level.INFO, TipoLog.ENTRADA, MedicamentoServiceImpl.class, "excluirEventoAdverso");

        LogManager.logDetalhe(Level.INFO, MedicamentoServiceImpl.class, "excluirEventoAdverso",
            " Dados entrada [ " + idEventoAdverso + " ].");

        LogManager.logDetalhe(Level.INFO, MedicamentoServiceImpl.class, "excluirEventoAdverso",
            " Efetuando a consulta das informacoes.");

        Optional<TbEventoAdverso> retorno;
        try {
            retorno = eventoAdversoRepository.findById(idEventoAdverso);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, MedicamentoServiceImpl.class, "excluirEventoAdverso",
                " Erro ao verificar a existencia do registro.", e);
            throw new PersistenciaException("Erro ao verificar a existencia do registro.", e);
        }

        if (!retorno.isPresent()) {
            throw new RegistroNaoLocalizadoException("O registro nao foi localizado na base de dados.");
        }

        // Obtem informacao da base
        TbEventoAdverso eventoAdversoCadastrado = retorno.get();

        // Efetiva a exclusao do usuario
        try {
            eventoAdversoRepository.delete(eventoAdversoCadastrado);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, MedicamentoServiceImpl.class, "excluirEventoAdverso",
                " Erro ao efetuar a exclusao das informacoes.", e);
            throw new PersistenciaException("Erro ao efetuar a exclusao das informacoes.", e);
        }

        // Logging de saida
        LogManager.log(Level.INFO, TipoLog.SAIDA, MedicamentoServiceImpl.class, "excluirEventoAdverso");
    }

    // --- CADASTRO DE DOENCA EVENTO ------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public DoencaEvento obterDoencaEvento(Long idDoencaEvento) throws EstudoZolpException {

        // Logging de entrada
        LogManager.log(Level.INFO, TipoLog.ENTRADA, MedicamentoServiceImpl.class, "obterDoencaEvento");

        LogManager.logDetalhe(Level.INFO, MedicamentoServiceImpl.class, "obterDoencaEvento",
            " Efetuando a consulta [ idDoencaEvento: " + idDoencaEvento + " ].");

        // Busca o registro
        Optional<TbDoencaEvento> retorno;
        try {
            retorno = doencaEventoRepository.findById(idDoencaEvento);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, MedicamentoServiceImpl.class, "obterDoencaEvento",
                " Erro ao efetuar a consulta das informações. ", e);
            throw new PersistenciaException("Erro ao efetuar a consulta das informacaoes.", e);
        }

        // Converte o entity
        DoencaEvento doencaEvento = null;

        if (retorno.isPresent()) {
            try {
                doencaEvento = doencaEventoToBean.convert(retorno.get());
            } catch (Exception e) {
                LogManager.logDetalhe(Level.ERROR, MedicamentoServiceImpl.class, "obterDoencaEvento",
                    " Erro ao efetuar a conversao dos dados.", e);
                throw new EstudoZolpException("Erro ao efetuar a conversao dos dados.");
            }
        }

        // Logging de saida
        LogManager.log(Level.INFO, TipoLog.SAIDA, MedicamentoServiceImpl.class, "obterDoencaEvento");

        return doencaEvento;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<DoencaEvento> consultarDoencaEvento(FiltroDoencaEvento filtro) throws EstudoZolpException {

        // Logging de entrada
        LogManager.log(Level.INFO, TipoLog.ENTRADA, MedicamentoServiceImpl.class, "consultarDoencaEvento");

        LogManager.logDetalhe(Level.INFO, MedicamentoServiceImpl.class, "consultarDoencaEvento",
            " Efetuando a consulta [ " + filtro + " ].");

        // Valida se o filtro foi preenchido
        if (Eval.isNull(filtro) || Eval.isAllEmpty(filtro.getId(), filtro.getDescricao())) {
            LogManager.logDetalhe(Level.ERROR, MedicamentoServiceImpl.class, "consultarDoencaEvento",
                    " Nenhum dado informado nos filtros.");

            throw new EstudoZolpException("Nenhum dado informado nos filtros.");
        }

        // Busca os registros de usuario
        final List<DoencaEvento> listDoencaEvento = new ArrayList<>();

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
                .forEach(object -> listDoencaEvento
                .add(doencaEventoToBean.convert((Object[]) object)));

        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, MedicamentoServiceImpl.class, "consultarDoencaEvento",
                " Erro ao efetuar a consulta das informacoes [" + " Consulta SQL: '" + sqlSelect
                + "' ].", e);
            throw new PersistenciaException("Erro ao efetuar a consulta das informacoes.", e);
        }

        // Logging de saida
        LogManager.log(Level.INFO, TipoLog.SAIDA, MedicamentoServiceImpl.class, "consultarDoencaEvento");

        return listDoencaEvento;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DoencaEvento incluirDoencaEvento(DoencaEvento doencaEvento) throws EstudoZolpException {

        // Logging de entrada
        LogManager.log(Level.INFO, TipoLog.ENTRADA, MedicamentoServiceImpl.class, "incluirDoencaEvento");

        LogManager.logDetalhe(Level.INFO, MedicamentoServiceImpl.class, "incluirDoencaEvento",
            " Dados entrada [ " + doencaEvento + " ].");

        TbDoencaEvento tbDoencaEvento;

        // Efetua a conversao
        try {
            tbDoencaEvento = doencaEventoToEntity.convert(doencaEvento);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, MedicamentoServiceImpl.class, "incluirDoencaEvento",
                " Erro ao efetuar a conversao dos dados.", e);
            throw new EstudoZolpException("Erro ao efetuar a conversao dos dados [ "
                + doencaEvento + " ].");
        }

        // Inclui na base de dados
        try {
            doencaEventoRepository.save(tbDoencaEvento);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, MedicamentoServiceImpl.class, "incluirDoencaEvento",
                " Erro ao efetuar a inclusao das informacoes.", e);
            throw new PersistenciaException("Erro ao efetuar a inclusao das informacoes.", e);
        }

        // Logging de saida
        LogManager.log(Level.INFO, TipoLog.SAIDA, MedicamentoServiceImpl.class, "incluirDoencaEvento");

        return doencaEvento;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DoencaEvento alterarDoencaEvento(DoencaEvento doencaEvento) throws EstudoZolpException,
        RegistroNaoLocalizadoException, PersistenciaException {

        // Logging de entrada
        LogManager.log(Level.INFO, TipoLog.ENTRADA, MedicamentoServiceImpl.class, "alterarDoencaEvento");

        LogManager.logDetalhe(Level.INFO, MedicamentoServiceImpl.class, "alterarDoencaEvento",
            " Dados entrada [ " + doencaEvento + " ].");

        LogManager.logDetalhe(Level.INFO, MedicamentoServiceImpl.class, "alterarDoencaEvento",
            " Efetuando a consulta das informacoes de Usuario.");

        // Efetua a busca do usuario
        Optional<TbDoencaEvento> retorno;
        try {
            retorno = doencaEventoRepository.findById(doencaEvento.getIdDoencaEvento());
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, MedicamentoServiceImpl.class, "alterarDoencaEvento",
                " Erro ao verificar a existencia do registro.", e);
            throw new PersistenciaException("Erro ao verificar a existencia do registro.", e);
        }

        if (!retorno.isPresent()) {
            throw new RegistroNaoLocalizadoException("O registro nao foi localizado na base de dados.");
        }

        // obtem a entity recuperada da base,
        TbDoencaEvento tbDoencaEvento = retorno.get();

        tbDoencaEvento.setDsDoenca(doencaEvento.getDsDoenca());
        tbDoencaEvento.setSiglaDoenca(doencaEvento.getSiglaDoenca());

        // Efetiva a atualizacao (update) na base oracle
        try {
            doencaEventoRepository.save(tbDoencaEvento);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, MedicamentoServiceImpl.class, "alterarDoencaEvento",
                " Erro ao efetuar a atualizacao das informacoes.", e);
            throw new PersistenciaException("Erro ao efetuar a atualizacao das informacoes.", e);
        }

        // Logging de saida
        LogManager.log(Level.INFO, TipoLog.SAIDA, MedicamentoServiceImpl.class, "alterarDoencaEvento");

        return doencaEventoToBean.convert(tbDoencaEvento);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void excluirDoencaEvento(Long idDoencaEvento) throws EstudoZolpException {

        // Logging de entrada
        LogManager.log(Level.INFO, TipoLog.ENTRADA, MedicamentoServiceImpl.class, "excluirDoencaEvento");

        LogManager.logDetalhe(Level.INFO, MedicamentoServiceImpl.class, "excluirDoencaEvento",
            " Dados entrada [ " + idDoencaEvento + " ].");

        LogManager.logDetalhe(Level.INFO, MedicamentoServiceImpl.class, "excluirDoencaEvento",
            " Efetuando a consulta das informacoes.");

        Optional<TbDoencaEvento> retorno;
        try {
            retorno = doencaEventoRepository.findById(idDoencaEvento);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, MedicamentoServiceImpl.class, "excluirDoencaEvento",
                " Erro ao verificar a existencia do registro.", e);
            throw new PersistenciaException("Erro ao verificar a existencia do registro.", e);
        }

        if (!retorno.isPresent()) {
            throw new RegistroNaoLocalizadoException("O registro nao foi localizado na base de dados.");
        }

        // Obtem informacao da base
        TbDoencaEvento doencaEventoCadastrado = retorno.get();

        // Efetiva a exclusao do usuario
        try {
            doencaEventoRepository.delete(doencaEventoCadastrado);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, MedicamentoServiceImpl.class, "excluirDoencaEvento",
                " Erro ao efetuar a exclusao das informacoes.", e);
            throw new PersistenciaException("Erro ao efetuar a exclusao das informacoes.", e);
        }

        // Logging de saida
        LogManager.log(Level.INFO, TipoLog.SAIDA, MedicamentoServiceImpl.class, "excluirDoencaEvento");
    }

}
