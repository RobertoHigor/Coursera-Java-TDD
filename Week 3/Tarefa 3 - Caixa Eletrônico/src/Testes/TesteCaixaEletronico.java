package Testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Codigo.CaixaEletronico;
import Codigo.EntregarDinheiroException;
import Codigo.ErroLeituraException;
import Codigo.PegarNumeroContaException;

class TesteCaixaEletronico {
	MockServicoRemoto mockRemoto;
	MockHardware mockHardware;
	CaixaEletronico caixa;
	
	@BeforeEach
	public void criarConta() {
		mockRemoto = new MockServicoRemoto();
		mockHardware = new MockHardware();
		mockRemoto.setNumeroConta("123456");
		mockHardware.setNumeroCartao("123456");
		
		caixa = new CaixaEletronico(mockRemoto, mockHardware);
		caixa.logar();
		mockRemoto.setSaldo(500);
	}

//Logar
	@Test
	void logar() {		
		assertEquals("Usuário Autenticado", caixa.logar());
		mockRemoto.verificaChamadas("recuperarConta");
		mockHardware.verificaChamadas("pegarNumeroDaContaCartao");
	}
	
	@Test
	void logarSenhaInvalida() {
		mockHardware.setNumeroCartao("123455");
		
		assertEquals("Não foi possível autenticar o usuário", caixa.logar());
		mockRemoto.verificaChamadas("recuperarConta");
		mockHardware.verificaChamadas("pegarNumeroDaContaCartao");
	}
	
	@Test
	void logarErroDeHardware() {
		MockHardwareComProblema mockHardwareException = new MockHardwareComProblema();
		caixa = new CaixaEletronico(mockRemoto, mockHardwareException);
		assertThrows(PegarNumeroContaException.class, () -> caixa.logar());
	}

//Saldo
	@Test
	void saldo() {		
		assertEquals("O saldo é R$500,00", caixa.saldo());
		mockRemoto.verificaChamadas("recuperarConta");
		mockHardware.verificaChamadas("pegarNumeroDaContaCartao");
	}
	
//Depositar
	@Test
	void depositar() {		
		assertEquals("Depósito recebido com sucesso", caixa.depositar(500));		
		assertEquals("O saldo é R$1000,00", caixa.saldo());
		mockRemoto.verificaChamadas("recuperarConta", "persistirConta");
		mockHardware.verificaChamadas("pegarNumeroDaContaCartao", "lerEnvelope");
	}
	
	@Test
	void depositarSemConta() {
		mockHardware.setNumeroCartao("123455");
		CaixaEletronico caixa2 = new CaixaEletronico(mockRemoto, mockHardware);
		caixa2.logar();
		
		assertEquals(null, caixa2.depositar(500));
	}
	
	@Test
	void depositarErroDeHardware() {			
		MockHardwareComProblema mockHardwareException = new MockHardwareComProblema();
		mockHardwareException.darErroLogin(false);
		mockHardwareException.setNumeroCartao("123456");
		
		caixa = new CaixaEletronico(mockRemoto, mockHardwareException);
		caixa.logar();
		
		assertThrows(ErroLeituraException.class, () -> caixa.depositar(500));
		mockRemoto.verificaChamadas("recuperarConta");
	}

//Sacar
	@Test
	void sacar() {		
		assertEquals("Retire seu dinheiro", caixa.sacar(500));
		mockRemoto.verificaChamadas("recuperarConta", "persistirConta");
		mockHardware.verificaChamadas("pegarNumeroDaContaCartao", "entregarDinheiro");
	}
	
	@Test
	void sacarSaldoInsuficiente() {		
		assertEquals("Saldo insuficiente", caixa.sacar(600));
		mockRemoto.verificaChamadas("recuperarConta");
		mockHardware.verificaChamadas("pegarNumeroDaContaCartao");
		
	}
	
	@Test
	void sacarSemConta() {
		mockHardware.setNumeroCartao("123455");
		CaixaEletronico caixa2 = new CaixaEletronico(mockRemoto, mockHardware);
		caixa2.logar();
		
		assertEquals(null, caixa2.sacar(500));
	}
	
	@Test
	void sacarErroDeHardware() {		
		MockHardwareComProblema mockHardwareException = new MockHardwareComProblema();
		mockHardwareException.darErroLogin(false);
		mockHardwareException.setNumeroCartao("123456");
		
		caixa = new CaixaEletronico(mockRemoto, mockHardwareException);
		caixa.logar();
		mockRemoto.setSaldo(500);
		
		assertEquals("O saldo é R$500,00", caixa.saldo());
		assertThrows(EntregarDinheiroException.class, () -> caixa.sacar(500));
		mockRemoto.verificaChamadas("recuperarConta");
	}
}
