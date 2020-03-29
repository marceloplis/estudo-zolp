package br.com.zolp.estudozolp.repository;

import br.com.zolp.estudozolp.entity.TbAuditoriaEstudo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface responsável por disponibilizar as operações de integração com a
 * base de dados para a entidade {@link TbAuditoriaEstudo}.
 *
 * Todas as <b>Named Queries</b> ou <b>Queries Nativas</b>, referentes a entidade
 * {@link TbAuditoriaEstudo}, deverão ser implementadas nesta interface.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Repository
public interface AuditoriaEstudoRepository extends JpaRepository<TbAuditoriaEstudo, Long> {

//    /**
//     *
//     */
//    @Query(value = "SELECT PP.TB0100_CD_CLIENTEPEDAGIO AS CD_CLIENTE,"
//            + " COUNT(1) AS QT_ABASTECIMENTOS,"
//            + " NVL(MIN(PP.TB0153_DT_TRANSACAO), TO_DATE('2019-01-01', 'YYYY-MM-DD')) AS DT_PRIMEIRA_TRANSACAO,"
//            + " MAX(PP.TB0153_DT_TRANSACAO) AS DT_ULTIMA_TRANSACAO,"
//            + " ROUND(MONTHS_BETWEEN(SYSDATE, MIN(PP.TB0153_DT_TRANSACAO)), 2) AS QT_DIF_MESES,"
//            + " ROUND(COUNT(1) / MONTHS_BETWEEN(SYSDATE, MIN(PP.TB0153_DT_TRANSACAO)), 2) AS VL_FREQUENCIA_MEDIA,"
//            + " ROUND(SUM(PO.TB0165_VOLUMEABASTECIMENTO) / COUNT(1), 2) AS VL_VOLUME_MEDIO,"
//            + " CASE WHEN ROUND(SYSDATE - TRUNC(MAX(PP.TB0153_DT_TRANSACAO))) <= 30 THEN 'RECENTE'"
//            + " WHEN ROUND(SYSDATE - TRUNC(MAX(PP.TB0153_DT_TRANSACAO))) BETWEEN 31 AND 90  THEN 'NAO RECENTE'"
//            + " WHEN ROUND(SYSDATE - TRUNC(MAX(PP.TB0153_DT_TRANSACAO))) BETWEEN 91 AND 180 THEN 'EM ABANDONO'"
//            + " WHEN ROUND(SYSDATE - TRUNC(MAX(PP.TB0153_DT_TRANSACAO))) >= 181 THEN 'PERDIDO'"
//            + " ELSE 'NUNCA ABASTECEU'"
//            + " END TP_RECENCIA,"
//            + " CASE WHEN (COUNT(1) / MONTHS_BETWEEN(SYSDATE, MIN(PP.TB0153_DT_TRANSACAO))) < 1"
//            + " THEN 'ESPORADICO'"
//            + " WHEN (COUNT(1) / MONTHS_BETWEEN(SYSDATE, MIN(PP.TB0153_DT_TRANSACAO))) BETWEEN 1 AND 2"
//            + " THEN 'FREQUENTE'"
//            + " WHEN (COUNT(1) / MONTHS_BETWEEN(SYSDATE, MIN(PP.TB0153_DT_TRANSACAO))) > 2"
//            + " THEN 'MUITO FREQUENTE'"
//            + " ELSE 'NUNCA ABASTECEU'"
//            + " END TP_FREQUENCIA,"
//            + " CASE WHEN (SUM(PO.TB0165_VOLUMEABASTECIMENTO) / COUNT(1)) < 30 THEN 'BAIXO'"
//            + " WHEN (SUM(PO.TB0165_VOLUMEABASTECIMENTO) / COUNT(1)) BETWEEN 30 AND 39 THEN 'MEDIO'"
//            + " WHEN (SUM(PO.TB0165_VOLUMEABASTECIMENTO) / COUNT(1)) >= 40 THEN 'ALTO'"
//            + " ELSE 'NUNCA ABASTECEU'"
//            + " END TP_VOLUME"
//            + " FROM CADMO.TB0153_TRANSACAOCONVENIADO PP,"
//            + " CADMO.TB0165_TRANSACAOPOSTO PO,"
//            + " (SELECT TB0100_CD_CLIENTEPEDAGIO CD_CLIENTEPEDAGIO, MIN(SS.TB0153_DT_TRANSACAO) DT_TRANSACAO"
//            + " FROM CADMO.TB0153_TRANSACAOCONVENIADO SS"
//            + " WHERE SS.TB0100_CD_CLIENTEPEDAGIO = :codigoCliente"
//            + " AND SS.TB0025_CD_TIPO = 3"
//            + " AND SS.TB0153_DT_TRANSACAO >= TO_DATE('2019-01-01', 'YYYY-MM-DD')"
//            + " GROUP BY SS.TB0100_CD_CLIENTEPEDAGIO) ZZ"
//            + " WHERE PP.TB0153_ID_TRANSACAO = PO.TB0153_ID_TRANSACAO"
//            + " AND PP.TB0025_CD_TIPO = 3"
//            + " AND PP.TB0100_CD_CLIENTEPEDAGIO = ZZ.CD_CLIENTEPEDAGIO"
//            + " AND PP.TB0153_DT_TRANSACAO >= ZZ.DT_TRANSACAO"
//            + " AND PP.TB0100_CD_CLIENTEPEDAGIO = :codigoCliente"
//            + " GROUP BY PP.TB0100_CD_CLIENTEPEDAGIO", nativeQuery = true)
//    List<Object[]> obterPerfilRfvCliente(@Param("codigoCliente") Long codigoCliente);

//    /**
//     *
//     */
//    @Query(value = "SELECT TB0503_VL_RANKINGABASTECE"
//                   + " FROM CADMO.TB0503_RANKINGRFVABASTECE"
//                   + " WHERE TB0503_FL_ATIVO = 1 AND TB0025_TP_RECENCIA = :tpRecencia"
//                   + " AND TB0025_TP_FREQUENCIA = :tpFrequencia AND TB0025_TP_VOLUME = :tpVolume"
//                   + " ORDER BY TB0503_DT_CRIACAO DESC", nativeQuery = true)
//    List<BigDecimal> obterRankingRfv(@Param("tpRecencia") Integer tpRecencia,
//                                     @Param("tpFrequencia") Integer tpFrequencia,
//                                     @Param("tpVolume") Integer tpVolume);

}
