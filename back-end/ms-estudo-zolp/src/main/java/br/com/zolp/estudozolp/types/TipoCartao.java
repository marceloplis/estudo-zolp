package br.com.grupostp.authzero.types;

import br.com.grupostp.authzero.util.Constants;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Enumerator responsavel por gerenciar o dominio de
 * valores para tipo de dado TipoCartao.
 *
 * @author Grupo STP - Sem Parar.
 * @version 1.0
 *
 */
public enum TipoCartao {

    // --- STATIC -------------------------------------------------------------

    // Dominio de valores:
    AMEX(Constants.CARTAO_AMEX, "09"),
    ELO(Constants.CARTAO_ELO, "07"),
    HIPERCARD(Constants.CARTAO_HIPERCARD, "12"),
    MASTERCARD(Constants.CARTAO_MASTERCARD, "02"),
    VISA(Constants.CARTAO_VISA, "01");

    public static final List<TipoCartao> DOMINIO = Collections.unmodifiableList(
        Arrays.asList(new TipoCartao[] {AMEX, ELO, HIPERCARD, MASTERCARD, VISA}));

    /**
     * Metodo fromValue.
     *
     * @param value
     * @return
     */
    public static TipoCartao fromValue(final String value) {
        // null-pointer safe
        if (value == null) {
            return null;
        }

        // Verifica no dominio de valores onde se enquadra:
        switch (value) {
            case Constants.CARTAO_AMEX: return AMEX;
            case Constants.CARTAO_ELO: return ELO;
            case Constants.CARTAO_HIPERCARD: return HIPERCARD;
            case Constants.CARTAO_MASTERCARD: return MASTERCARD;
            case Constants.CARTAO_VISA: return VISA;
            default: return null;
        }
    }

    // --- INSTANCE -----------------------------------------------------------

    private final String value;
    private final String terminalId;

    /**
     * Cria uma nova instancia (objeto) do enum ClasseAtributo.
     *
     * @param value
     */
    TipoCartao(final String value, final String terminalId) {
        this.value = value;
        this.terminalId = terminalId;
    }

    /**
     * Obtem o valor corrente de value.
     *
     * @return O valor corrente de value.
     */
    public final String toValue() {
        return this.value;
    }

    public final String getTerminalId() {
        return this.terminalId;
    }

}
