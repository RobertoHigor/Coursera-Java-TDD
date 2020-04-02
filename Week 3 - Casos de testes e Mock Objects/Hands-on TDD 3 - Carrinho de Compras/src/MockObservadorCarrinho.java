import static org.junit.Assert.assertEquals;

public class MockObservadorCarrinho implements ObservadorCarrinho{//Implementa a interface da classe ObservadorCarrinho

	private String nomeRecebido;
	private int valorRecebido;
	
	@Override
	public void produtoAdicionado(String nome, int valor) {
		this.nomeRecebido = nome;
		this.valorRecebido = valor;	
	}

	public void verificaRecebimentoProduto(String nomeEsperado, int valorEsperado) {
		assertEquals(nomeEsperado, nomeRecebido);
		assertEquals(valorEsperado, valorRecebido);
	}
}
