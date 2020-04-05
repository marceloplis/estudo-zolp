package br.com.morpheos.enums;

public enum TipoModificacaoEnum {

	INCLUSAO("I"),
    ALTERACAO("U"),
    APROVACAO("A"),
    EXCLUSAO("E");

    private final String value;

    private TipoModificacaoEnum(final String newValue) {
        value = newValue;
    }

    public String getValue() { return value; }
	
}
