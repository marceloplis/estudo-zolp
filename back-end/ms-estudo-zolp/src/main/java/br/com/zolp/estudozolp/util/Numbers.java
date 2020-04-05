package br.com.zolp.estudozolp.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Classe responsavel por disponibilizar funcoes utilitarias para
 * manipulacao de valores numericos: Integer, Long, Double, BigDecimal, etc.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
public final class Numbers {

    /**
     * Impede criacao de instancias, para utilizacao apenas como static.
     */
    private Numbers() {
        super();
    }

    // -------------------------------------------------------------------------

    // Constantes numericas diversas:
    public static final int
        // Conversao convencional entre Boolean e Integer:
        INT_TRUE = 1,
        INT_FALSE = 0,

        // Constantes genericas para maior legibilidade (magic number):
        INT_ZERO = 0,

        // 2019-06-07 Atualizacao da escala decimal de 3 para 2 casas, pois alguns
        // gateways de pagamento (ex: GetNet) apenas aceitam 2 casas decimais.
        INT_SCALE = 2,  // 3,

        // Total para calculos percentuais (magic number).
        INT_100_PERCENT = 100;

    public static final BigDecimal
        // Garante que estas contantes tambem tenham o mesmo numero de casas decimais
        // que o restante da aplicacao.
        DEC_ZERO = BigDecimal.ZERO
                             .setScale(INT_SCALE, RoundingMode.HALF_UP),
        // Total para calculos percentuais (magic number).
        DEC_CEM = new BigDecimal(INT_100_PERCENT, MathContext.DECIMAL64)
                                .setScale(INT_SCALE, RoundingMode.HALF_UP);

    // -------------------------------------------------------------------------

    /**
     * Gera novo valor BigDecimal a partir de um numero integer.
     *
     * @param value
     * @return
     */
    public static BigDecimal decimal(final int value) {
        if (value == 0) {
            return DEC_ZERO;

        } else {
            return new BigDecimal(value, MathContext.DECIMAL64)
                                 .setScale(INT_SCALE, RoundingMode.HALF_UP);
        }
    }

    /**
     * Gera novo valor BigDecimal a partir de um numero integer.
     *
     * @param value
     * @return
     */
    public static BigDecimal decimal(final Integer value) {
        if (value == null) {
            return (BigDecimal) null;

        } else if (value == 0) {
            return DEC_ZERO;

        } else {
            return new BigDecimal(value, MathContext.DECIMAL64)
                                 .setScale(INT_SCALE, RoundingMode.HALF_UP);
        }
    }

    /**
     * Gera novo valor BigDecimal a partir de um numero long.
     *
     * @param value
     * @return
     */
    public static BigDecimal decimal(final long value) {
        if (value == 0L) {
            return DEC_ZERO;

        } else {
            return new BigDecimal(value, MathContext.DECIMAL64)
                                 .setScale(INT_SCALE, RoundingMode.HALF_UP);
        }
    }

    /**
     * Gera novo valor BigDecimal a partir de um numero long.
     *
     * @param value
     * @return
     */
    public static BigDecimal decimal(final Long value) {
        if (value == null) {
            return (BigDecimal) null;

        } else if (value == 0L) {
            return DEC_ZERO;

        } else {
            return new BigDecimal(value, MathContext.DECIMAL64)
                                 .setScale(INT_SCALE, RoundingMode.HALF_UP);
        }
    }

    /**
     * Gera novo valor BigDecimal a partir de um numero double.
     *
     * @param value
     * @return
     */
    public static BigDecimal decimal(final double value) {
        if (value == 0D) {
            return DEC_ZERO;

        } else {
            // convert o valor double para String conforme recomendacao PMD
            return new BigDecimal(String.valueOf(value), MathContext.DECIMAL64)
                                 .setScale(INT_SCALE, RoundingMode.HALF_UP);
        }
    }

    /**
     * Gera novo valor BigDecimal a partir de um numero double.
     *
     * @param value
     * @return
     */
    public static BigDecimal decimal(final Double value) {
        if (value == null) {
            return (BigDecimal) null;

        } else if (value == 0D) {
            return DEC_ZERO;

        } else {
            // convert o valor double para String conforme recomendacao PMD
            return new BigDecimal(String.valueOf(value), MathContext.DECIMAL64)
                                 .setScale(INT_SCALE, RoundingMode.HALF_UP);
        }
    }

    /**
     * Ajusta o valor BigDecimal com o numero de casas decimais padrao.
     * Este metodo eh util para garantir que valores decimais tenham o
     * mesmo numero de casas decimais ao longo do sistema (e interfaces).
     *
     * @param value
     * @return
     */
    public static BigDecimal decimal(final BigDecimal value) {
        if (value == null) {
            return (BigDecimal) null;

        } else {
            // Garante que este valor tenha o mesmo numero de casas decimais
            // que o restante da aplicacao.
            return value.setScale(INT_SCALE, RoundingMode.HALF_UP);
        }
    }

    // -------------------------------------------------------------------------

    /**
     * Converte um valor Object para Integer, proveniente do banco de dados,
     * de onde vem como BigInteger ou BigDecimal.
     *
     * @param value
     * @return
     */
    public static Integer integerValue(final Object value) {
        if (value == null) {
            return (Integer) null;

        } else if (value instanceof BigInteger) {
            BigInteger bigIntegerValue = (BigInteger) value;
            return bigIntegerValue.intValue();

        } else if (value instanceof BigDecimal) {
            BigDecimal bigDecimalValue = (BigDecimal) value;
            return bigDecimalValue.intValue();

        } else if (value instanceof Long) {
            Long longValue = (Long) value;
            return longValue.intValue();

        } else if (value instanceof Integer) {
            Integer integerValue = (Integer) value;
            return integerValue;

        } else if (value instanceof Double) {
            Double doubleValue = (Double) value;
            return doubleValue.intValue();

        } else {
            return null; // valor nao reconhecido.
        }
    }

    /**
     * Converte um valor Object para Long, proveniente do banco de dados,
     * de onde vem como BigInteger ou BigDecimal.
     *
     * @param value
     * @return
     */
    public static Long longValue(final Object value) {
        if (value == null) {
            return (Long) null;

        } else if (value instanceof BigInteger) {
            BigInteger bigIntegerValue = (BigInteger) value;
            return bigIntegerValue.longValue();

        } else if (value instanceof BigDecimal) {
            BigDecimal bigDecimalValue = (BigDecimal) value;
            return bigDecimalValue.longValue();

        } else if (value instanceof Long) {
            Long longValue = (Long) value;
            return longValue;

        } else if (value instanceof Integer) {
            Integer integerValue = (Integer) value;
            return integerValue.longValue();

        } else if (value instanceof Double) {
            Double doubleValue = (Double) value;
            return doubleValue.longValue();

        } else {
            return null; // valor nao reconhecido.
        }
    }

    /**
     * Converte um valor Object para BigDecimal, proveniente do banco de dados,
     * de onde vem como BigInteger ou BigDecimal ou Number.
     *
     * @param value
     * @return
     */
    public static BigDecimal decimalValue(final Object value) {
        // Garante que o valor convertido tenha o mesmo numero de casas decimais
        // que o restante da aplicacao.
        if (value == null) {
            return (BigDecimal) null;

        } else if (value instanceof BigDecimal) {
            return ((BigDecimal) value).setScale(INT_SCALE, RoundingMode.HALF_UP);

        } else if (value instanceof BigInteger) {
            return new BigDecimal((BigInteger) value)
                                 .setScale(INT_SCALE, RoundingMode.HALF_UP);

        } else if (value instanceof Long) {
            return new BigDecimal((Long) value)
                                 .setScale(INT_SCALE, RoundingMode.HALF_UP);

        } else if (value instanceof Integer) {
            return new BigDecimal((Integer) value)
                                 .setScale(INT_SCALE, RoundingMode.HALF_UP);

        } else if (value instanceof Double) {
            return new BigDecimal((Double) value)
                                 .setScale(INT_SCALE, RoundingMode.HALF_UP);

        } else {
            return null; // valor nao reconhecido.
        }
    }

}
