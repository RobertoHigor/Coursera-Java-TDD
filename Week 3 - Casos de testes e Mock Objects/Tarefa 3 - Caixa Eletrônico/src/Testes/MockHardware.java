package Testes;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import Codigo.Hardware;

public class MockHardware implements Hardware{
	private String numeroCartao;
	private List<String> execucoes = new ArrayList<>();

	@Override
	public String pegarNumeroDaContaCartao() {
		execucoes.add("pegarNumeroDaContaCartao");
		return this.numeroCartao;
	}

	@Override
	public void entregarDinheiro(int dinheiro) {
		execucoes.add("entregarDinheiro");
		
	}

	@Override
	public void lerEnvelope(int dinheiro) {
		execucoes.add("lerEnvelope");
		
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
		
	}
	
	public void verificaChamadas(String... execs) {
		for (int i = 0; i < execs.length; i++)
			if(!execucoes.contains(execs[i])) 
				fail();
	}

}
