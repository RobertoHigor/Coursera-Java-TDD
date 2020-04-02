package Codigo;

public class PegarNumeroContaException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PegarNumeroContaException() {
		super("Ocorreu um erro no hardware ao logar");
	}

}
