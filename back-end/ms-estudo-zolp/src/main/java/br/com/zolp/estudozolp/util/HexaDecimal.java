package br.com.zolp.estudozolp.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * Enumerator para tratamento de campos hexadecimais.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */
@Component
public class HexaDecimal {

    private static final String HEXA = "0123456789ABCDEF";

    public static String byteArray2Hex(byte[] bytes) {

        final StringBuilder hex = new StringBuilder(2 * bytes.length);
        for (final byte b : bytes) {
            hex.append(HEXA.charAt((b & 0xF0) >> 4)).append(HEXA.charAt((b & 0x0F)));
        }
        return hex.toString();
    }

    public static byte[] hex2ByteArray(String hexa) throws IllegalArgumentException {

        if (hexa.length() % 2 != 0) {
            throw new IllegalArgumentException("String hexa invalida");
        }

        byte[] b = new byte[hexa.length() / 2];

        for (int i = 0; i < hexa.length(); i+=2) {
            b[i / 2] = (byte) ((HEXA.indexOf(hexa.charAt(i)) << 4) | (HEXA.indexOf(hexa.charAt(i + 1))));
        }
        return b;
    }

}
