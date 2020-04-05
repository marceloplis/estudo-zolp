package br.com.morpheos.enums;

public enum PerfilEnum {

	ADMIN(1),
    CADASTRO(2),
    CONSULTA(3),
    APROVADOR(4);

    private final int value;

    private PerfilEnum(final int newValue) {
        value = newValue;
    }

    public int getValue() { return value; }
	
}
