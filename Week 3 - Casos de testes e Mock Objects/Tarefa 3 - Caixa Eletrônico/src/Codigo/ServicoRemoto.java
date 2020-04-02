package Codigo;

public interface ServicoRemoto {

	public ContaCorrente recuperarConta(String numeroConta);
	public void persistirConta(int novoSaldo);
}
