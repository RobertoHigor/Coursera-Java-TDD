package Codigo;

public class ErroLeituraException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ErroLeituraException() {
		super("Ocorreu um erro na leitura do envelope");
	}
}
