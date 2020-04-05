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
public enum TipoOrigem {

    // --- STATIC -------------------------------------------------------------

    // Dominio de valores:
    AUTHZERO(DomainConstants.AUTHZERO),
    RESERVA(DomainConstants.RESERVA);

    public static final List<TipoOrigem> DOMINIO = Collections.unmodifiableList(
                        Arrays.asList(new TipoOrigem[] {AUTHZERO,
                                                         RESERVA}));

    /**
     * Metodo fromValue.
     *
     * @param value
     * @return
     */
    public static TipoOrigem fromValue(final Integer value) {
        // null-pointer safe
        if (value == null) {
            return (TipoOrigem) null;
        }

        // Verifica no dominio de valores onde se enquadra:
        switch (value) {
            case DomainConstants.AUTHZERO: return AUTHZERO;
            case DomainConstants.RESERVA: return RESERVA;
            default: return (TipoOrigem) null;
        }
    }

    // --- INSTANCE -----------------------------------------------------------

    private final int value;

    /**
     * Cria uma nova instancia (objeto) do enum FlagAprovado.
     *
     * @param value
     */
    TipoOrigem(final int value) {
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

}
