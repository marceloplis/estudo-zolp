package br.com.zolp.estudozolp.repository;

import br.com.zolp.estudozolp.entity.TbEventoAdverso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface responsável por disponibilizar as operações de integração com a
 * base de dados para a entidade {@link TbEventoAdverso}.
 *
 * Todas as <b>Named Queries</b> ou <b>Queries Nativas</b>, referentes a entidade
 * {@link TbEventoAdverso}, deverão ser implementadas nesta interface.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Repository
public interface EventoAdversoRepository extends JpaRepository<TbEventoAdverso, Long> {
}
