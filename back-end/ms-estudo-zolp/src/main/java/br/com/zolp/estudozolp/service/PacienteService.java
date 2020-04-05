package br.com.zolp.estudozolp.service;

import br.com.zolp.estudozolp.bean.Paciente;
import br.com.zolp.estudozolp.bean.UsuarioSistema;
import br.com.zolp.estudozolp.bean.filtro.FiltroConsultaUsuario;
import br.com.zolp.estudozolp.bean.filtro.FiltroPaciente;
import br.com.zolp.estudozolp.exception.EstudoZolpException;
import br.com.zolp.estudozolp.exception.PersistenciaException;
import br.com.zolp.estudozolp.exception.RegistroNaoLocalizadoException;

import java.util.List;

/**
 * Interface responsavel por disponibilizar as operacoes de persistencia
 * das informações de Paciente, Visitas ....
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
public interface PacienteService {

    // --- CADASTRO DE PACIENTE ------------------------------------------------

    /**
     * Efetua a busca de um paciente.
     *
     * @param idPaciente
     * @return Paciente
     * @throws EstudoZolpException
     */
    Paciente obterPaciente(final Long idPaciente) throws EstudoZolpException;

    /**
     * Efetua a busca dos pacientes com base no filtro.
     *
     * @param filtro
     * @return Lista de pacientes.
     * @throws EstudoZolpException
     */
    List<Paciente> consultarPaciente(final FiltroPaciente filtro) throws EstudoZolpException;

    /**
     *  Efetua a inclusao de um paciente.
     *
     * @param paciente
     * @throws EstudoZolpException
     */
    Paciente incluirPaciente(Paciente paciente) throws EstudoZolpException;

    /**
     * Efetua a alteracao de um paciente.
     *
     * @param paciente
     * @return Paciente
     * @throws EstudoZolpException
     * @throws RegistroNaoLocalizadoException
     * @throws PersistenciaException
     */
    Paciente alterarPaciente(Paciente paciente) throws EstudoZolpException,
        RegistroNaoLocalizadoException, PersistenciaException;

    /**
     * Efetua a exclusao de um paciente.
     *
     * @param idPaciente
     * @return Boolean
     * @throws EstudoZolpException
     */
    void excluirPaciente(Long idPaciente) throws EstudoZolpException;

}
