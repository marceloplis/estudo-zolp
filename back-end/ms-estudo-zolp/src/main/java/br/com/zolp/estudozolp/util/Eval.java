package br.com.zolp.estudozolp.util;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Classe responsavel por disponibilizar funcoes utilitarias para
 * validacao (evaluate) de valores.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
public final class Eval {

    // Status de comparacao entre valores:
    public static final int
        COMPARE_MENOR = -1,
        COMPARE_IGUAL = 0,
        COMPARE_MAIOR = 1;

    /**
     * Impede criacao de instancias, para utilizacao apenas como static.
     */
    private Eval() {
        super();
    }

    // -------------------------------------------------------------------------

    /**
     * Metodo isNull.
     *
     * @param o
     * @return
     */
    public static boolean isNull(final Object o) {
        return o == null;
    }

    /**
     * Metodo isNotNull.
     *
     * @param o
     * @return
     */
    public static boolean isNotNull(final Object o) {
        return !isNull(o);
    }

    /**
     * Metodo ifNull.
     *
     * @param <O>
     * @param value
     * @param other
     * @return
     */
    public static <O extends Object> O ifNull(final O value, final O other) {
        return isNull(value) ? other : value;
    }

    /**
     * Metodo ifNull.
     *
     * @param <O>
     * @param value
     * @param nullValue
     * @param nonNullvalue
     * @return
     */
    public static <O extends Object> O ifNull(final Object value, final O nullValue, final O nonNullvalue) {
        return isNull(value) ? nullValue : nonNullvalue;
    }

    /**
     * Metodo nonNull.
     *
     * @param args
     * @return
     */
    public static Object nonNull(final Object... args) {
        for (Object o : args) {
            if (o != null) {
                return o;
            }
        }
        return null;
    }

    /**
     * Metodo nonNull.
     *
     * @param args
     * @return
     */
    public static Long nonNull(final Long... args) {
        for (Long o : args) {
            if (o != null) {
                return o;
            }
        }
        return null;
    }

    /**
     * Metodo nonNull.
     *
     * @param args
     * @return
     */
    public static Integer nonNull(final Integer... args) {
        for (Integer o : args) {
            if (o != null) {
                return o;
            }
        }
        return null;
    }

    /**
     * Metodo assertNull.
     *
     * @param arg
     * @return
     */
    public static Object assertNull(final Object arg) {
        if (isNull(arg)) {
            throw new IllegalArgumentException();
        }
        return arg;
    }

    /**
     * Metodo assertNull.
     *
     * @param args
     */
    public static void assertNull(final Object... args) {
        for (Object o : args) {
            if (o == null) {
                throw new IllegalArgumentException();
            }
        }
    }

    // -------------------------------------------------------------------------

    /**
     * Metodo isEmpty.
     *
     * @param o
     * @return
     */
    public static boolean isEmpty(final Object o) {
        return o == null || //
               o instanceof CharSequence && ((CharSequence) o).length() == 0 || //
               o instanceof Character && ((Character) o).charValue() == 0 || //
               o instanceof Boolean && !((Boolean) o).booleanValue() || //
               o instanceof Number && ((Number) o).doubleValue() == 0d || //
               o instanceof BigDecimal && ((BigDecimal) o).compareTo(BigDecimal.ZERO) == 0 || //
               o instanceof List<?> && ((List<?>) o).size() == 0 || //
               o instanceof Collection<?> && ((Collection<?>) o).size() == 0 || //
               o instanceof Map<?, ?> && ((Map<?, ?>) o).size() == 0 || //
               o.getClass().isArray() && Array.getLength(o) == 0;
    }

    /**
     * Metodo isNotEmpty.
     *
     * @param o
     * @return
     */
    public static boolean isNotEmpty(final Object o) {
        return !isEmpty(o);
    }

    /**
     * Testa se todos não são vazios.
     *
     * @param args
     * @return
     */
    public static boolean isAnyEmpty(final Object... args) {
        if (isEmpty(args)) {
            return true;
        }

        for (Object o : args) {
            if (isEmpty(o)) {
                return true;
            }
        }

        // se chegou aqui, entao nenhum eh vazio.
        return false;
    }

    /**
     * Testa se todos são vazios.
     *
     * @param args
     * @return
     */
    public static boolean isAllEmpty(final Object... args) {
        if (isEmpty(args)) {
            return true;
        }

        for (Object o : args) {
            if (isNotEmpty(o)) {
                return false;
            }
        }

        // se chegou aqui, entao todos estao vazios.
        return true;
    }

    /**
     * Testa se todos são valorados.
     *
     * @param args
     * @return
     */
    public static boolean isNoneEmpty(final Object... args) {
        if (isEmpty(args)) {
            return false;
        }

        for (Object o : args) {
            if (isEmpty(o)) {
                return false;
            }
        }

        // se chegou aqui, entao todos estao valorados.
        return true;
    }

    /**
     * Metodo ifEmpty.
     *
     * @param <O>
     * @param value
     * @param other
     * @return
     */
    public static <O extends Object> O ifEmpty(final O value, final O other) {
        return isEmpty(value) ? other : value;
    }

    /**
     * Metodo ifEmpty.
     *
     * @param <O>
     * @param value
     * @param emptyValue
     * @param nonEmptyValue
     * @return
     */
    public static <O extends Object> O ifEmpty(final Object value, final O emptyValue, final O nonEmptyValue) {
        return isEmpty(value) ? emptyValue : nonEmptyValue;
    }

    /**
     * Metodo nonEmpty.
     *
     * @param args
     * @return
     */
    public static Object nonEmpty(final Object... args) {
        for (Object o : args) {
            if (!isEmpty(o)) {
                return o;
            }
        }
        return null;
    }

    /**
     * Metodo assertEmpty.
     *
     * @param arg
     * @return
     */
    public static Object assertEmpty(final Object arg) {
        if (isEmpty(arg)) {
            throw new IllegalArgumentException();
        }
        return arg;
    }

    /**
     * Metodo assertEmpty.
     *
     * @param args
     */
    public static void assertEmpty(final Object... args) {
        for (Object o : args) {
            if (isEmpty(o)) {
                throw new IllegalArgumentException();
            }
        }
    }

    // -------------------------------------------------------------------------

    /**
     * Metodo isZero.
     *
     * @param o
     * @return
     */
    public static boolean isZero(final Object o) {
        return o == null || //
               o instanceof BigDecimal && (((BigDecimal) o).compareTo(BigDecimal.ZERO) == 0 //
                                           || ((BigDecimal) o).compareTo(Numbers.DEC_ZERO) == 0) || //
               o instanceof BigInteger && ((BigInteger) o).compareTo(BigInteger.ZERO) == 0 || //
               o instanceof Number && ((Number) o).doubleValue() == 0D;
    }

    public static boolean isNotZero(final Object o) {
        return !isZero(o);
    }

    /**
     * Testa se todos não estão zerados.
     *
     * @param args
     * @return
     */
    public static boolean isAnyZero(final Number... args) {
        if (isEmpty(args)) {
            return true;
        }

        for (Object o : args) {
            if (isZero(o)) {
                return true;
            }
        }

        // se chegou aqui, entao nenhum estah zerado.
        return false;
    }

    /**
     * Testa se todos estão valorados.
     *
     * @param args
     * @return
     */
    public static boolean isNoneZero(final Number... args) {
        if (isEmpty(args)) {
            return false;
        }

        for (Object o : args) {
            if (isZero(o)) {
                return false;
            }
        }

        // se chegou aqui, entao todos estao valorados.
        return true;
    }

    /**
     * Metodo ifZero.
     *
     * @param <O>
     * @param value
     * @param other
     * @return
     */
    public static <O extends Object> O ifZero(final O value, final O other) {
        return isZero(value) ? other : value;
    }

    /**
     * Metodo ifZero.
     *
     * @param <O>
     * @param value
     * @param zeroValue
     * @param nonZeroValue
     * @return
     */
    public static <O extends Object> O ifZero(final Object value, final O zeroValue, final O nonZeroValue) {
        return isZero(value) ? zeroValue : nonZeroValue;
    }

    /**
     * Metodo nonZero.
     *
     * @param args
     * @return
     */
    public static Object nonZero(final Object... args) {
        for (Object o : args) {
            if (!isZero(o)) {
                return o;
            }
        }
        return null;
    }

    /**
     * Metodo nonZero.
     *
     * @param args
     * @return
     */
    public static Long nonZero(final Long... args) {
        for (Long o : args) {
            if (!isZero(o)) {
                return o;
            }
        }
        return null;
    }

    /**
     * Metodo nonZero.
     *
     * @param args
     * @return
     */
    public static Integer nonZero(final Integer... args) {
        for (Integer o : args) {
            if (!isZero(o)) {
                return o;
            }
        }
        return null;
    }

    /**
     * Metodo assertZero.
     *
     * @param arg
     * @return
     */
    public static Object assertZero(final Object arg) {
        if (isZero(arg)) {
            throw new IllegalArgumentException();
        }
        return arg;
    }

    /**
     * Metodo assertZero.
     *
     * @param args
     */
    public static void assertZero(final Object... args) {
        for (Object o : args) {
            if (isZero(o)) {
                throw new IllegalArgumentException();
            }
        }
    }

    // -------------------------------------------------------------------------

    /**
     * Metodo length.
     *
     * @param o
     * @return
     */
    public static int length(final Object o) {
        return (o == null) ? 0 : //
            (o instanceof CharSequence) ? ((CharSequence) o).length() : //
                (o instanceof List<?>) ? ((List<?>) o).size() : //
                    (o instanceof Map<?, ?>) ? ((Map<?, ?>) o).size() : //
                        (o.getClass().isArray()) ? Array.getLength(o) : //
                            0;
    }

    // ------------------------------------------------------------------------

}
