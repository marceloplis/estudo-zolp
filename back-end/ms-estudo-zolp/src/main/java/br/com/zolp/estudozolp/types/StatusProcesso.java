package br.com.grupostp.library.stplog.service.types;

/**
 * Enumerator responsável por identificar os tipos de processo a que o log se refere.
 *
 * @author stp
 * @version 0.0.1-SNAPSHOT
 *
 */
public enum StatusProcesso {

    INICIADO(1, "INICIADO"),
    FINALIZADO_SUCESSO(2, "FINALIZADO_SUCESSO"),
    FINALIZADO_ERRO(-1, "FINALIZADO_ERRO");

    private int tipoInt;
    private String tipoStr;

    StatusProcesso(final int i,final String s) {
        this.tipoInt = i;
        this.tipoStr = s;
    }

    public int toInt() {
        return this.tipoInt;
    }

    public String toString() {
        return this.tipoStr;
    }
}
