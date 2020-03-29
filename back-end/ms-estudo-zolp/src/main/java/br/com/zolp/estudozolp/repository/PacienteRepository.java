package br.com.zolp.estudozolp.repository;

import br.com.zolp.estudozolp.entity.TbPaciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface responsável por disponibilizar as operações de integração com a
 * base de dados para a entidade {@link TbPaciente}.
 *
 * Todas as <b>Named Queries</b> ou <b>Queries Nativas</b>, referentes a entidade
 * {@link TbPaciente}, deverão ser implementadas nesta interface.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Repository
public interface PacienteRepository extends JpaRepository<TbPaciente, Long> {
}
