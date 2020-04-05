package br.com.grupostp.authzero.types;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Enumerator responsavel por gerenciar o dominio de
 * valores para tipo de dado FlagAprovado.
 *
 * @author stp
 * @version 1.0
 *
 */
public enum FlagAprovado {

    // --- STATIC -------------------------------------------------------------

    // Dominio de valores:
    NAO_APROVADO(DomainConstants.NAO_APROVADO),
    APROVADO(DomainConstants.APROVADO);

    public static final List<FlagAprovado> DOMINIO = Collections.unmodifiableList(
                        Arrays.asList(new FlagAprovado[] {NAO_APROVADO,
                                                         APROVADO}));

    /**
     * Metodo fromValue.
     *
     * @param value
     * @return
     */
    public static FlagAprovado fromValue(final Integer value) {
        // null-pointer safe
        if (value == null) {
            return (FlagAprovado) null;
        }

        // Verifica no dominio de valores onde se enquadra:
        switch (value) {
            case DomainConstants.NAO_APROVADO: return NAO_APROVADO;
            case DomainConstants.APROVADO: return APROVADO;
            default: return (FlagAprovado) null;
        }
    }

    /**
     * Metodo toBoolean.
     *
     * @param value
     * @return
     */
    public static Boolean toBoolean(final Integer value) {
        // null-pointer safe
        if (value == null) {
            return (Boolean) null;
        }

        // Verifica no dominio de valores onde se enquadra:
        switch (value) {
            case DomainConstants.NAO_APROVADO: return Boolean.FALSE;
            case DomainConstants.APROVADO: return Boolean.TRUE;
            default: return (Boolean) null;
        }
    }

    /**
     * Metodo fromValue.
     *
     * @param value
     * @return
     */
    public static FlagAprovado fromBoolean(final Boolean value) {
        // null-pointer safe
        if (value == null) {
            return (FlagAprovado) null;

        } else if (value) { // true
            return APROVADO;

        } else { // false
            return NAO_APROVADO;
        }
    }

    // --- INSTANCE -----------------------------------------------------------

    private final int value;

    /**
     * Cria uma nova instancia (objeto) do enum FlagAprovado.
     *
     * @param value
     */
    FlagAprovado(final int value) {
        this.value = value;
    }

    /**
     * Obtem o valor corrente de value.
     *
     * @return O valor corrente de value.
     */
    public final int toValue() {
        return this.value;
    }

    /**
     * Obtem o valor corrente de value na forma de boolean.
     *
     * @return O valor corrente de value na forma de boolean.
     */
    public final boolean toBoolean() {
        return this.value == DomainConstants.APROVADO;
    }

}
