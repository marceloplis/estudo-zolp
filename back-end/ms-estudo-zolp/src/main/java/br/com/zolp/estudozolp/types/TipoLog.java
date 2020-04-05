package br.com.zolp.estudozolp.types;

/**
 * Enumerator responsável por identificar o ponto do log no fluxo.
 *
 * @author Mmamede
 * @version 0.0.1-SNAPSHOT
 */
public enum TipoLog {

    ENTRADA(1, "ENTRADA"),
    SAIDA(2, "SAIDA"),
    DETALHE(3, "DETALHE"),
    VIP(4, "VIP");

    private int tipoInt;
    private String tipoStr;

    TipoLog(final int i, final String s) {
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
