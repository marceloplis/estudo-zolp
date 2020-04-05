package br.com.zolp.estudozolp.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.GregorianCalendar;

/**
 * Classe responsavel por disponibilizar funcoes utilitarias para
 * manipulacao de valores temporais: Date, Time, DateTime, Instant, etc.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
public final class Dates {

    public static final String ZONE_ID_AMERICA_SAO_PAULO = "America/Sao_Paulo";

    public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static final DateTimeFormatter DATETIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Impede criacao de instancias, para utilizacao apenas como static.
     */
    private Dates() {
        super();
    }

    // -------------------------------------------------------------------------

    /**
     * Cria nova data (util.Date) utilizando convencao usual para mes.
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static java.util.Date date(final int year, final int month, final int day) {
        return new GregorianCalendar(year, month - 1, day, 0, 0, 0).getTime();
    }

    public static java.util.Date atZone(final LocalDateTime datetime) {
        if (datetime == null) {
            return (java.util.Date) null;

        } else {
            return java.util.Date.from(datetime.atZone(systemZoneId()).toInstant());
        }
    }

    /**
     * Cria nova data (LocalDateTime) utilizando o timezone do sistema.
     *
     * @param datetime
     * @return
     */
    public static LocalDateTime atZone(final java.util.Date datetime) {
        if (datetime == null) {
            return (LocalDateTime) null;

        } else if (datetime instanceof java.sql.Timestamp) {
            final java.sql.Timestamp timestamp = (java.sql.Timestamp) datetime;
            return timestamp.toLocalDateTime();

        } else if (datetime instanceof java.sql.Date) {
            final java.sql.Date date = (java.sql.Date) datetime;
            return LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()),
                                           systemZoneId());

        } else {
            return LocalDateTime.ofInstant(datetime.toInstant(), systemZoneId());
        }
    }

    // -------------------------------------------------------------------------

    /**
     * Converte um valor Object para LocalDateTime, proveniente do banco de dados,
     * de onde vem como java.sql.Date, java.sql.Timestamp ou java.sql.Util.
     *
     * @param value
     * @return
     */
    public static LocalDateTime localDateTimeValue(final Object value) {
        if (value == null) {
            return (LocalDateTime) null;

        } else if (value instanceof java.sql.Timestamp) {
            final java.sql.Timestamp timestamp = (java.sql.Timestamp) value;
            return timestamp.toLocalDateTime();

        } else if (value instanceof java.sql.Date) {
            final java.sql.Date sqlDate = (java.sql.Date) value;
            return LocalDateTime.ofInstant(Instant.ofEpochMilli(sqlDate.getTime()),
                                           systemZoneId());

        } else if (value instanceof java.util.Date) {
            final java.util.Date utilDate = (java.util.Date) value;
            return LocalDateTime.ofInstant(utilDate.toInstant(), systemZoneId());

        } else {
            return null; // valor nao reconhecido.
        }
    }

    /**
     * Obtem a data atual, ja ajustada para o timezone default do sistema
     * operacional (servidor).
     *
     * @return
     */
    public static LocalDateTime localDateTimeAtual() {
        return LocalDateTime.now(systemZoneId());
    }

    /**
     * Obtem a data atual, ja ajustada para o timezone default do sistema
     * operacional (servidor).
     *
     * @return
     */
    public static LocalDate localDateAtual() {
        return LocalDate.now(systemZoneId());
    }

    /**
     * Obtem a data atual, ja ajustada para o timezone default do sistema
     * operacional (servidor).
     *
     * @return
     */
    public static java.util.Date dateAtual() {
        return java.util.Date.from(ZonedDateTime.now(systemZoneId()).toInstant());
    }

    /**
     * Obtem o ZoneId (TimeZone) default do sistema operacional (servidor).
     *
     * @return
     */
    public static ZoneId systemZoneId() {
        // return ZoneId.of(ZONE_ID_AMERICA_SAO_PAULO)
        return ZoneId.systemDefault();
    }

    // -------------------------------------------------------------------------

    /**
     * Metodo format.
     *
     * @param date
     * @return
     */
    public static String format(final LocalDate date) {
        if (date == null) {
            return "";
        }

        return DATE_FORMAT.format(date);
    }

    /**
     * Metodo format.
     *
     * @param datetime
     * @return
     */
    public static String format(final LocalDateTime datetime) {
        if (datetime == null) {
            return "";
        }

        return DATETIME_FORMAT.format(datetime);
    }

}
