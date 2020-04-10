package br.com.zolp.estudozolp.service.impl;

import br.com.zolp.estudozolp.bean.Paciente;
import br.com.zolp.estudozolp.bean.filtro.FiltroPaciente;
import br.com.zolp.estudozolp.converters.PacienteToBean;
import br.com.zolp.estudozolp.converters.PacienteToEntity;
import br.com.zolp.estudozolp.entity.TbPaciente;
import br.com.zolp.estudozolp.exception.EstudoZolpException;
import br.com.zolp.estudozolp.exception.PersistenciaException;
import br.com.zolp.estudozolp.exception.RegistroNaoLocalizadoException;
import br.com.zolp.estudozolp.log.LogManager;
import br.com.zolp.estudozolp.repository.PacienteRepository;
import br.com.zolp.estudozolp.service.PacienteService;
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
 * das informações referente a Paciente ....
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Service
@Transactional
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private PacienteToBean pacienteToBean;

    @Autowired
    private PacienteToEntity pacienteToEntity;

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

    // --- CADASTRO DE PACIENTE ------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Paciente obterPaciente(Long idPaciente) throws EstudoZolpException {

        // Logging de entrada
        LogManager.log(Level.INFO, TipoLog.ENTRADA, PacienteServiceImpl.class, "obterPaciente");

        LogManager.logDetalhe(Level.INFO, PacienteServiceImpl.class, "obterPaciente",
            " Efetuando a consulta [ idPaciente: " + idPaciente + " ].");

        // Busca o registro
        Optional<TbPaciente> retorno;
        try {
            retorno = pacienteRepository.findById(idPaciente);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, PacienteServiceImpl.class, "obterPaciente",
                " Erro ao efetuar a consulta das informações. ", e);
            throw new PersistenciaException("Erro ao efetuar a consulta das informacaoes.", e);
        }

        // Converte o entity
        Paciente paciente = null;

        if (retorno.isPresent()) {
            try {
                paciente = pacienteToBean.convert(retorno.get());
            } catch (Exception e) {
                LogManager.logDetalhe(Level.ERROR, PacienteServiceImpl.class, "obterPaciente",
                    " Erro ao efetuar a conversao dos dados.", e);
                throw new EstudoZolpException("Erro ao efetuar a conversao dos dados.");
            }
        }

        // Logging de saida
        LogManager.log(Level.INFO, TipoLog.SAIDA, PacienteServiceImpl.class, "obterPaciente");

        return paciente;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Paciente> consultarPaciente(FiltroPaciente filtro) throws EstudoZolpException {

        // Logging de entrada
        LogManager.log(Level.INFO, TipoLog.ENTRADA, PacienteServiceImpl.class, "consultarPaciente");

        LogManager.logDetalhe(Level.INFO, PacienteServiceImpl.class, "consultarPaciente",
            " Efetuando a consulta [ " + filtro + " ].");

        // Valida se o filtro foi preenchido
        if (Eval.isNull(filtro) || Eval.isAllEmpty(filtro.getId(), filtro.getDescricao())) {
            LogManager.logDetalhe(Level.ERROR, PacienteServiceImpl.class, "consultarPaciente",
                " Nenhum dado informado nos filtros.");

            throw new EstudoZolpException("Nenhum dado informado nos filtros.");
        }

        // Busca os registros de usuario
        final List<Paciente> listPaciente = new ArrayList<>();

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
                .forEach(object -> listPaciente
                .add(pacienteToBean.convert((Object[]) object)));

        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, PacienteServiceImpl.class, "consultarPaciente",
                " Erro ao efetuar a consulta das informacoes [" + " Consulta SQL: '" + sqlSelect
                + "' ].", e);
            throw new PersistenciaException("Erro ao efetuar a consulta das informacoes.", e);
        }

        // Logging de saida
        LogManager.log(Level.INFO, TipoLog.SAIDA, PacienteServiceImpl.class, "consultarPaciente");

        return listPaciente;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Paciente incluirPaciente(Paciente paciente) throws EstudoZolpException {

        // Logging de entrada
        LogManager.log(Level.INFO, TipoLog.ENTRADA, PacienteServiceImpl.class, "incluirPaciente");

        // Remove o Id para que o mesmo obtenha um novo sequencial
        paciente.setIdPaciente(null);

        LogManager.logDetalhe(Level.INFO, PacienteServiceImpl.class, "incluirPaciente",
            " Dados entrada [ " + paciente + " ].");

        TbPaciente tbPaciente;

        // Efetua a conversao
        try {
            tbPaciente = pacienteToEntity.convert(paciente);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, PacienteServiceImpl.class, "incluirPaciente",
                " Erro ao efetuar a conversao dos dados.", e);
            throw new EstudoZolpException("Erro ao efetuar a conversao dos dados [ "
                + paciente + " ].");
        }

        // Inclui na base de dados
        try {
            pacienteRepository.save(tbPaciente);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, PacienteServiceImpl.class, "incluirPaciente",
                " Erro ao efetuar a inclusao das informacoes.", e);
            throw new PersistenciaException("Erro ao efetuar a inclusao das informacoes.", e);
        }

        // Logging de saida
        LogManager.log(Level.INFO, TipoLog.SAIDA, PacienteServiceImpl.class, "incluirPaciente");

        return paciente;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Paciente alterarPaciente(Paciente paciente) throws EstudoZolpException,
        RegistroNaoLocalizadoException, PersistenciaException {

        // Logging de entrada
        LogManager.log(Level.INFO, TipoLog.ENTRADA, PacienteServiceImpl.class, "alterarPaciente");

        LogManager.logDetalhe(Level.INFO, PacienteServiceImpl.class, "alterarPaciente",
            " Dados entrada [ " + paciente + " ].");

        LogManager.logDetalhe(Level.INFO, PacienteServiceImpl.class, "alterarPaciente",
            " Efetuando a consulta das informacoes de Usuario.");

        // Efetua a busca do usuario
        Optional<TbPaciente> retorno;
        try {
            retorno = pacienteRepository.findById(paciente.getIdPaciente());
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, PacienteServiceImpl.class, "alterarPaciente",
                " Erro ao verificar a existencia do registro.", e);
            throw new PersistenciaException("Erro ao verificar a existencia do registro.", e);
        }

        if (!retorno.isPresent()) {
            throw new RegistroNaoLocalizadoException("O registro nao foi localizado na base de dados.");
        }

        // obtem a entity recuperada da base,
        TbPaciente tbPaciente = retorno.get();

        tbPaciente.setIdUnidadePesquisa(paciente.getIdUnidadePesquisa());
        tbPaciente.setCpf(paciente.getCpf());
        tbPaciente.setNome(paciente.getNome());
        tbPaciente.setIniciaisNome(paciente.getIniciaisNome());
        tbPaciente.setNuRegistroProtocolo(paciente.getNuRegistroProtocolo());
        tbPaciente.setEndereco(paciente.getEndereco());
        tbPaciente.setNuEndereco(paciente.getNuEndereco());
        tbPaciente.setComplEndereco(paciente.getComplEndereco());
        tbPaciente.setBairro(paciente.getBairro());
        tbPaciente.setCidade(paciente.getCidade());
        tbPaciente.setUf(paciente.getUf());
        tbPaciente.setCep(paciente.getCep());
        tbPaciente.setTelResidencial(paciente.getTelResidencial());
        tbPaciente.setTelCelular(paciente.getTelCelular());
        tbPaciente.setTelTrabalho(paciente.getTelTrabalho());
        tbPaciente.setTelRecado(paciente.getTelRecado());
        tbPaciente.setPessoaRecado(paciente.getPessoaRecado());
        tbPaciente.setProfissao(paciente.getProfissao());
        tbPaciente.setDtNascimento(paciente.getDtNascimento());
        tbPaciente.setEscolaridade(paciente.getEscolaridade());
        tbPaciente.setRaca(paciente.getRaca());
        tbPaciente.setSexo(paciente.getSexo());
        tbPaciente.setFlAtivo(paciente.getFlAtivo());
        tbPaciente.setDtInclusao(paciente.getDtInclusao());

        // Efetiva a atualizacao (update) na base oracle
        try {
            pacienteRepository.save(tbPaciente);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, PacienteServiceImpl.class, "alterarPaciente",
                " Erro ao efetuar a atualizacao das informacoes.", e);
            throw new PersistenciaException("Erro ao efetuar a atualizacao das informacoes.", e);
        }

        // Logging de saida
        LogManager.log(Level.INFO, TipoLog.SAIDA, PacienteServiceImpl.class, "alterarPaciente");

        return pacienteToBean.convert(tbPaciente);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void excluirPaciente(Long idPaciente) throws EstudoZolpException {

        // Logging de entrada
        LogManager.log(Level.INFO, TipoLog.ENTRADA, PacienteServiceImpl.class, "excluirPaciente");

        LogManager.logDetalhe(Level.INFO, PacienteServiceImpl.class, "excluirPaciente",
            " Dados entrada [ " + idPaciente + " ].");

        LogManager.logDetalhe(Level.INFO, PacienteServiceImpl.class, "excluirPaciente",
            " Efetuando a consulta das informacoes.");

        Optional<TbPaciente> retorno;
        try {
            retorno = pacienteRepository.findById(idPaciente);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, PacienteServiceImpl.class, "excluirPaciente",
                " Erro ao verificar a existencia do registro.", e);
            throw new PersistenciaException("Erro ao verificar a existencia do registro.", e);
        }

        if (!retorno.isPresent()) {
            throw new RegistroNaoLocalizadoException("O registro nao foi localizado na base de dados.");
        }

        // Obtem informacao da base
        TbPaciente pacienteCadastrado = retorno.get();

        // Efetiva a exclusao do usuario
        try {
            pacienteRepository.delete(pacienteCadastrado);
        } catch (Exception e) {
            LogManager.logDetalhe(Level.ERROR, PacienteServiceImpl.class, "excluirPaciente",
                " Erro ao efetuar a exclusao das informacoes.", e);
            throw new PersistenciaException("Erro ao efetuar a exclusao das informacoes.", e);
        }

        // Logging de saida
        LogManager.log(Level.INFO, TipoLog.SAIDA, PacienteServiceImpl.class, "excluirPaciente");

    }

}
