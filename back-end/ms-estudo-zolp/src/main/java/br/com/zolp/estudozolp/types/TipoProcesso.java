package br.com.zolp.estudozolp.types;

/**
 * Enumerator responsável por identificar os tipos de processo a que o log se refere.
 *
 * @author stp
 * @version 0.0.1-SNAPSHOT
 *
 */
public enum TipoProcesso {

    HTTP(1, "HTTP"),
    JMS(2, "JMS"),
    ARQUIVO(-1, "ARQUIVO");

    private int tipoInt;
    private String tipoStr;

    TipoProcesso(final int i, final String s) {
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
