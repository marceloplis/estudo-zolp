package br.com.zolp.estudozolp.exception;

/**
 * Classe responsável pelo tratamento de exceção no
 * momento da persistencia das informacoes.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
public class PersistenciaException extends RuntimeException {

    private static final long serialVersionUID = 3180978711898750699L;

    public PersistenciaException() {
        super();
    }

    public PersistenciaException(final String message) {
        super(message);
    }

    public PersistenciaException(final Throwable throwable) {
        super(throwable);
    }

    public PersistenciaException(final String message, final Throwable throwable) {
        super(message, throwable);
    }

    public PersistenciaException(final String message, final Throwable cause,
                                 final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
