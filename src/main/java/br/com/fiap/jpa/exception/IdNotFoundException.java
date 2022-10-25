package br.com.fiap.jpa.exception;

public class IdNotFoundException extends Exception {

	public IdNotFoundException() {
		super("Id n�o encontrado");
	}
	
	public IdNotFoundException(String msg) {
		super(msg);
	}
	
}