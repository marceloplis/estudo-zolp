package br.com.zolp.estudozolp.exception;

/**
 * Classe responsável pelo tratamento de exceção para os registros nao localizados.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
public class RegistroNaoLocalizadoException extends RuntimeException {

    private static final long serialVersionUID = 3180978711898750699L;

    public RegistroNaoLocalizadoException() {
        super();
    }

    public RegistroNaoLocalizadoException(final String message) {
        super(message);
    }

    public RegistroNaoLocalizadoException(final Throwable throwable) {
        super(throwable);
    }

    public RegistroNaoLocalizadoException(final String message, final Throwable throwable) {
        super(message, throwable);
    }

    public RegistroNaoLocalizadoException(final String message, final Throwable cause,
                                          final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
