package Codigo;

public class UsuarioInexistenteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UsuarioInexistenteException() {
		super("Usuario não encontrado");
	}

}
