package br.com.zolp.estudozolp.service;

import br.com.zolp.estudozolp.bean.*;
import br.com.zolp.estudozolp.bean.filtro.FiltroDoencaEvento;
import br.com.zolp.estudozolp.bean.filtro.FiltroEventoAdverso;
import br.com.zolp.estudozolp.bean.filtro.FiltroGrupoMedicamento;
import br.com.zolp.estudozolp.bean.filtro.FiltroMedicamento;
import br.com.zolp.estudozolp.exception.EstudoZolpException;
import br.com.zolp.estudozolp.exception.PersistenciaException;
import br.com.zolp.estudozolp.exception.RegistroNaoLocalizadoException;

import java.util.List;

/**
 * Interface responsavel por disponibilizar as operacoes de persistencia
 * das informações de Medicamento, GrupoMedicamento, EventoAdverso e DoencaEvento.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
public interface MedicamentoService {

    // --- CADASTRO DE MEDICAMENTO ------------------------------------------------

    /**
     * Efetua a busca de um medicamento.
     *
     * @param idMedicamento
     * @return Medicamento
     * @throws EstudoZolpException
     */
    Medicamento obterMedicamento(final Long idMedicamento) throws EstudoZolpException;

    /**
     * Efetua a busca dos medicamentos com base no filtro.
     *
     * @param filtro
     * @return Lista de medicamentos.
     * @throws EstudoZolpException
     */
    List<Medicamento> consultarMedicamento(final FiltroMedicamento filtro) throws EstudoZolpException;

    /**
     *  Efetua a inclusao de um medicamento.
     *
     * @param medicamento
     * @throws EstudoZolpException
     */
    Medicamento incluirMedicamento(Medicamento medicamento) throws EstudoZolpException;

    /**
     * Efetua a alteracao de um medicamento.
     *
     * @param medicamento
     * @return Medicamento
     * @throws EstudoZolpException
     * @throws RegistroNaoLocalizadoException
     * @throws PersistenciaException
     */
    Medicamento alterarMedicamento(Medicamento medicamento) throws EstudoZolpException,
        RegistroNaoLocalizadoException, PersistenciaException;

    /**
     * Efetua a exclusao de um medicamento.
     *
     * @param idMedicamento
     * @return Boolean
     * @throws EstudoZolpException
     */
    void excluirMedicamento(Long idMedicamento) throws EstudoZolpException;

    // --- CADASTRO DE GRUPO MEDICAMENTO ------------------------------------------------

    /**
     * Efetua a busca de um grupo medicamento.
     *
     * @param idGrupoMedicamento
     * @return Paciente
     * @throws EstudoZolpException
     */
    GrupoMedicamento obterGrupoMedicamento(final Long idGrupoMedicamento) throws EstudoZolpException;

    /**
     * Efetua a busca dos grupos de medicamentos com base no filtro.
     *
     * @param filtro
     * @return Lista de grupos de medicamento.
     * @throws EstudoZolpException
     */
    List<GrupoMedicamento> consultarGrupoMedicamento(final FiltroGrupoMedicamento filtro) throws EstudoZolpException;

    /**
     *  Efetua a inclusao de um grupoMedicamento.
     *
     * @param grupoMedicamento
     * @throws EstudoZolpException
     */
    GrupoMedicamento incluirGrupoMedicamento(GrupoMedicamento grupoMedicamento) throws EstudoZolpException;

    /**
     * Efetua a alteracao de um grupoMedicamento.
     *
     * @param grupoMedicamento
     * @return GrupoMedicamento
     * @throws EstudoZolpException
     * @throws RegistroNaoLocalizadoException
     * @throws PersistenciaException
     */
    GrupoMedicamento alterarGrupoMedicamento(GrupoMedicamento grupoMedicamento) throws EstudoZolpException,
        RegistroNaoLocalizadoException, PersistenciaException;

    /**
     * Efetua a exclusao de um grupoMedicamento.
     *
     * @param idGrupoMedicamento
     * @return Boolean
     * @throws EstudoZolpException
     */
    void excluirGrupoMedicamento(Long idGrupoMedicamento) throws EstudoZolpException;

    // --- CADASTRO DE EVENTO ADVERSO ------------------------------------------------

    /**
     * Efetua a busca de um Evento Adverso.
     *
     * @param idEventoAdverso
     * @return EventoAdverso
     * @throws EstudoZolpException
     */
    EventoAdverso obterEventoAdverso(final Long idEventoAdverso) throws EstudoZolpException;

    /**
     * Efetua a busca dos eventos adversos com base no filtro.
     *
     * @param filtro
     * @return Lista de eventos adversos.
     * @throws EstudoZolpException
     */
    List<EventoAdverso> consultarEventoAdverso(final FiltroEventoAdverso filtro) throws EstudoZolpException;

    /**
     *  Efetua a inclusao de um evento adverso.
     *
     * @param eventoAdverso
     * @throws EstudoZolpException
     */
    EventoAdverso incluirEventoAdverso(EventoAdverso eventoAdverso) throws EstudoZolpException;

    /**
     * Efetua a alteracao de um evento adverso.
     *
     * @param eventoAdverso
     * @return EventoAdverso
     * @throws EstudoZolpException
     * @throws RegistroNaoLocalizadoException
     * @throws PersistenciaException
     */
    EventoAdverso alterarEventoAdverso(EventoAdverso eventoAdverso) throws EstudoZolpException,
        RegistroNaoLocalizadoException, PersistenciaException;

    /**
     * Efetua a exclusao de um evento adverso.
     *
     * @param idEventoAdverso
     * @return Boolean
     * @throws EstudoZolpException
     */
    void excluirEventoAdverso(Long idEventoAdverso) throws EstudoZolpException;

    // --- CADASTRO DE DOENCA EVENTO ------------------------------------------------

    /**
     * Efetua a busca de doenca evento.
     *
     * @param idDoencaEvento
     * @return DoencaEvento
     * @throws EstudoZolpException
     */
    DoencaEvento obterDoencaEvento(final Long idDoencaEvento) throws EstudoZolpException;

    /**
     * Efetua a busca da doencaEvento com base no filtro.
     *
     * @param filtro
     * @return Lista de doencaEvento.
     * @throws EstudoZolpException
     */
    List<DoencaEvento> consultarDoencaEvento(final FiltroDoencaEvento filtro) throws EstudoZolpException;

    /**
     *  Efetua a inclusao de um doencaEvento.
     *
     * @param doencaEvento
     * @throws EstudoZolpException
     */
    DoencaEvento incluirDoencaEvento(DoencaEvento doencaEvento) throws EstudoZolpException;

    /**
     * Efetua a alteracao de doencaEvento.
     *
     * @param doencaEvento
     * @return DoencaEvento
     * @throws EstudoZolpException
     * @throws RegistroNaoLocalizadoException
     * @throws PersistenciaException
     */
    DoencaEvento alterarDoencaEvento(DoencaEvento doencaEvento) throws EstudoZolpException,
        RegistroNaoLocalizadoException, PersistenciaException;

    /**
     * Efetua a exclusao de uma doencaEvento.
     *
     * @param idDoencaEvento
     * @return Boolean
     * @throws EstudoZolpException
     */
    void excluirDoencaEvento(Long idDoencaEvento) throws EstudoZolpException;

}
