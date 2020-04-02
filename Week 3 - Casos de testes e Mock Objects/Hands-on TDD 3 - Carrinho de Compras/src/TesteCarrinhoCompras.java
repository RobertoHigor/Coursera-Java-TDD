import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TesteCarrinhoCompras {

	@Test
	void totalCarrinho() {
		CarrinhoCompras c = new CarrinhoCompras();
		c.adicionaProduto(new Produto("tenis", 100));
		c.adicionaProduto(new Produto("camiseta", 50));
		c.adicionaProduto(new Produto("bermuda", 70));
		assertEquals(220, c.total());
	}

	//Exemplo de design Pattern Observer
	@Test
	public void escutaAdicaoDeProduto() {
		CarrinhoCompras c = new CarrinhoCompras();
		MockObservadorCarrinho mock = new MockObservadorCarrinho();
		c.adicionarObservador(mock);
		c.adicionaProduto(new Produto("tenis", 100));
		//Foi definido aqui para o mock receber só o nome e o preço, ao invés da classe produto.
		mock.verificaRecebimentoProduto("tenis", 100); 
	}
	
	@Test
	public void adicionarDoisObservadores() {
		CarrinhoCompras c = new CarrinhoCompras();
		MockObservadorCarrinho mock1 = new MockObservadorCarrinho();
		MockObservadorCarrinho mock2 = new MockObservadorCarrinho();
		c.adicionarObservador(mock1);
		c.adicionarObservador(mock2);
		c.adicionaProduto(new Produto("tenis", 100));
		//Foi definido aqui para o mock receber só o nome e o preço, ao invés da classe produto.
		mock1.verificaRecebimentoProduto("tenis", 100); 
		mock2.verificaRecebimentoProduto("tenis", 100); 
	}
	
	@Test
	public void continuaNotificandoComErroObservador() {
		CarrinhoCompras c = new CarrinhoCompras();
		MockObservadorCarrinho mock1 = new MockObservadorCarrinho();
		ObservadorCarrinho mock2 = new MockObservadorComProblema();
		MockObservadorCarrinho mock3 = new MockObservadorCarrinho();
		c.adicionarObservador(mock1);
		c.adicionarObservador(mock2);
		c.adicionarObservador(mock3);
		c.adicionaProduto(new Produto("tenis", 100));
		//Foi definido aqui para o mock receber só o nome e o preço, ao invés da classe produto.
		mock1.verificaRecebimentoProduto("tenis", 100); 
		mock3.verificaRecebimentoProduto("tenis", 100); 
	}
	
}

