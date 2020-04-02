package Testes;

import Codigo.EntregarDinheiroException;
import Codigo.ErroLeituraException;
import Codigo.Hardware;
import Codigo.PegarNumeroContaException;

public class MockHardwareComProblema implements Hardware{
	private Boolean darErro = true;
	private String numeroCartao;
	@Override
	public String pegarNumeroDaContaCartao() {
		if (darErro)
			throw new PegarNumeroContaException();
		else
			return this.numeroCartao;
	}
	

	@Override
	public void entregarDinheiro(int dinheiro) {
		throw new EntregarDinheiroException();
		
	}

	@Override
	public void lerEnvelope(int dinheiro) {
		throw new ErroLeituraException();
		
	}
	
	public void darErroLogin(Boolean darErro) {
		this.darErro = darErro;
	}
	
	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

}
