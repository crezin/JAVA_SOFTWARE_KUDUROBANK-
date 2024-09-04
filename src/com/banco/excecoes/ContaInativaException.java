package com.banco.excecoes;

public class ContaInativaException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ContaInativaException(String message) {
        super(message);
    }
}
