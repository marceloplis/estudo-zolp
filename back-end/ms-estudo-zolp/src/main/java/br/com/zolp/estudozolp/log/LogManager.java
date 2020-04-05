package br.com.zolp.estudozolp.log;

import br.com.zolp.estudozolp.types.TipoLog;
import br.com.zolp.estudozolp.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;

import java.util.UUID;

/**
 * Classe responsável por efetuar o controle da exibição do detalhe dos logs nos arquivos de log.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
public final class LogManager {

    private static final Logger logger = LoggerFactory.getLogger(LogManager.class);

    private static final int LIGADO = 1;
    private static final int DESLIGADO = -1;
    private static int logDetail = DESLIGADO;

    private LogManager() {
    }

    /**
     * Habilita a exibição dos detalhes do log no arquivo de logs.
     */
    public static void ligaDetalhe() {
        logDetail = LIGADO;
    }

    /**
     * Desabilita a exibição dos detalhes do log no arquivo de logs.
     */
    public static void desligaDetalhe() {
        logDetail = DESLIGADO;
    }

    /**
     * Efetua o log da mensagem.
     *
     * @param level
     * @param tipoLog
     * @param className
     * @param metodo
     */
    public static void log(final Level level, final TipoLog tipoLog, final Class className, final String metodo ) {

        if (logDetail == DESLIGADO && level.toInt() != Level.ERROR.toInt() && !tipoLog.equals(TipoLog.VIP)) {
            return;
        }

        String correlationID = Thread.currentThread().getName();

        if (!correlationID.contains(Constants.STR_UUID)) {
            correlationID = Constants.STR_UUID + UUID.randomUUID().toString();
            Thread.currentThread().setName(correlationID);
        }

        switch (level) {
            case TRACE:
                logger.trace( correlationID + "::" + tipoLog.toString() + "::" + metodo + "::" + className.getName() );
                break;
            case DEBUG:
                logger.debug( correlationID + "::" + tipoLog.toString() + "::" + metodo + "::" + className.getName() );
                break;
            case WARN:
                logger.warn( correlationID + "::" + tipoLog.toString() + "::" + metodo + "::" + className.getName() );
                break;
            case ERROR:
                logger.error( correlationID + "::" + tipoLog.toString() + "::" + metodo + "::" + className.getName() );
                break;
            default:
                logger.info( correlationID  + "::" + tipoLog.toString() + "::" + metodo + "::" + className.getName() );
        }
    }

    /**
     * Efetua o log da mensagem.
     *
     * @param level
     * @param className
     * @param metodo
     * @param logDetalhe
     */
    public static void logDetalhe(final Level level, final Class className, final String metodo, final String logDetalhe ) {
        logDetalhe(level, className, metodo, logDetalhe, null);
    }

    /**
     * Efetua o log da mensagem.
     *
     * @param level
     * @param className
     * @param metodo
     * @param logDetalhe
     * @param e
     */
    public static void logDetalhe(final Level level, final Class className, final String metodo, String logDetalhe, final Exception e) {

        TipoLog tipoLog = TipoLog.DETALHE;

        if ( logDetail == DESLIGADO && level.toInt() != Level.ERROR.toInt()) {
            return;
        }

        String correlationID = Thread.currentThread().getName();

        if (!correlationID.contains(Constants.STR_UUID)) {
            correlationID = Constants.STR_UUID + UUID.randomUUID().toString();
            Thread.currentThread().setName(correlationID);
        }

        if ( logDetalhe == null) {
            logDetalhe = "";
        }

        String stackTrace = "";

        // Monta o stackTrace para incluir no log
        if(e != null){
            java.io.StringWriter strErr = new java.io.StringWriter();
            e.printStackTrace(new java.io.PrintWriter(strErr));
            stackTrace = " :: stacktrace :: ".concat(strErr.toString());
        }

        switch ( level ) {
            case TRACE:
                logger.trace( correlationID + "::"  + tipoLog.toString() + "::" + metodo + "::" + className.getName() + logDetalhe + stackTrace);
                break;
            case DEBUG:
                logger.debug( correlationID + "::" + tipoLog.toString() + "::" + metodo + "::" + className.getName() + logDetalhe + stackTrace);
                break;
            case WARN:
                logger.warn( correlationID + "::" + tipoLog.toString() + "::" + metodo + "::" + className.getName() + logDetalhe + stackTrace);
                break;
            case ERROR:
                logger.error( correlationID + "::" + tipoLog.toString() + "::" + metodo + "::" + className.getName() + logDetalhe + stackTrace);
                break;
            default:
                logger.info( correlationID + "::" + tipoLog.toString() + "::" + metodo + "::" + className.getName() + logDetalhe + stackTrace);
        }

    }

    /**
     * Obtem o status atual da exibicao detalhada do log.
     *
     * @return Status atual do log
     */
    public static String getStatusLog() {

        if (logDetail == LIGADO) {
            return "LIGADO";
        } else {
            return "DESLIGADO";
        }
    }

}
