package Codigo;

public class CaixaEletronico {

	private ServicoRemoto remoto;
	private Hardware hardware;
	private ContaCorrente contaCorrente;
	
	public CaixaEletronico(ServicoRemoto remoto, Hardware hardware) {
		this.remoto = remoto;
		this.hardware = hardware;
	}
	public String logar() {
		String numeroCartao = hardware.pegarNumeroDaContaCartao();
		contaCorrente = remoto.recuperarConta(numeroCartao);
		
		if(contaCorrente != null) {
			return "Usuário Autenticado";
		}else {
			return "Não foi possível autenticar o usuário";
		}
	}
	public String saldo() {
		if (contaCorrente != null)
			return "O saldo é R$" + contaCorrente.getSaldo() + ",00";
		else
			return null;
	}
	public String depositar(int dinheiro) {
			hardware.lerEnvelope(dinheiro);			
			
			if (contaCorrente != null) {
				remoto.persistirConta(contaCorrente.getSaldo()+dinheiro);	
				return "Depósito recebido com sucesso";
			}else {
				return null;
			}
			
	}
	public String sacar(int dinheiro) {	
			if (contaCorrente != null) {
				if (contaCorrente.getSaldo() < dinheiro)
				return "Saldo insuficiente";
			
			hardware.entregarDinheiro(dinheiro);
			remoto.persistirConta(contaCorrente.getSaldo() - dinheiro);
			return "Retire seu dinheiro";
			}else {
				return null;
			}
		
	}
}
