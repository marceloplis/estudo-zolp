package br.com.morpheos.enums;

public enum TipoEntidadeEnum {

	VISITA("V"),
    EVENTO("E"),
    SAIDA("S");

    private final String value;

    private TipoEntidadeEnum(final String newValue) {
        value = newValue;
    }

    public String getValue() { return value; }
	
}
