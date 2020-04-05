package br.com.zolp.estudozolp.exception;

/**
 * Classe responsável pelo tratamento de exceção generica
 * do fluxo authzero.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
public class EstudoZolpException extends RuntimeException {

    private static final long serialVersionUID = 5090199191066908699L;

    public EstudoZolpException() {
        super();
    }

    public EstudoZolpException(final String message) {
        super(message);
    }

    public EstudoZolpException(final Throwable throwable) {
        super(throwable);
    }

    public EstudoZolpException(final String message, final Throwable throwable) {
        super(message, throwable);
    }

    public EstudoZolpException(final String message, final Throwable cause,
                               final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
