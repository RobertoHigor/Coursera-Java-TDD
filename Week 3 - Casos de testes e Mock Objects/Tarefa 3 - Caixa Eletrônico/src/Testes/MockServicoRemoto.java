package Testes;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import Codigo.ContaCorrente;
import Codigo.ServicoRemoto;

public class MockServicoRemoto implements ServicoRemoto{

	private String numeroConta;
	private ContaCorrente conta;
	private List<String> execucoes = new ArrayList<>();

	@Override
	public ContaCorrente recuperarConta(String numeroConta) {	
		execucoes.add("recuperarConta");
		if (numeroConta.equals(this.numeroConta)) {
			conta = new ContaCorrente();
			return conta;
		}
		return null;
	}

	@Override
	public void persistirConta(int novoSaldo) {
		execucoes.add("persistirConta");
		conta.setSaldo(novoSaldo);
	}

	public void verificaChamadas(String... execs) {
		for (int i = 0; i < execs.length; i++)
			if(!execucoes.contains(execs[i])) 
				fail();
	}

	public void setSaldo(int saldo) {
		conta.setSaldo(saldo);
	}
	
	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;	
	}
	
}
