import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestPilha {

	private Pilha p;
	
	@BeforeEach
	public void inicializaPilha() {
		p = new Pilha(10);
	}
	
	@Test
	void pilhaVazia() {		
	//Teste para verificar se a pilha está vazia
		assertTrue(p.estaVazia());
		assertEquals(0, p.tamanho());
	}
	
	@Test
	void empilhaUmElemento() {	
	//Teste para verificar se foi empilhado o elemento "primeiro"
		p.empilha("primeiro");
		
		assertFalse(p.estaVazia());
		assertEquals(1, p.tamanho());
		assertEquals("primeiro", p.topo()); // O topo da pilha tem que dizer quem é o primeiro
	}
	
	@Test
	void empilhaEDesempilha() {
	//Teste para verificar se foi empilhado e desempilhado um elemento
		p.empilha("primeiro");
		p.empilha("segundo");
		
		assertEquals(2, p.tamanho());
		assertEquals("segundo", p.topo()); // O topo da pilha tem que dizer quem é o primeiro
		
		//Nesse caso ele está recebendo um valor do tipo Object do método desempilha
		Object desempilhado = p.desempilha();
		assertEquals(1, p.tamanho());
		assertEquals("primeiro", p.topo());
		assertEquals("segundo", desempilhado);
	}
	
	@Test
	public void removeDaPilhaVazia() {
	//Teste para remover de uma pilha vazia
		assertThrows(PilhaVaziaException.class, () -> p.desempilha()); //Checando se o método irá lançar a PilhaVaziaException
	}
	
	@Test
	public void adicionaNaPilhaCheia() {
		//Enchendo a pilha
		for (int i = 0; i<10; i++) {
			p.empilha("elemento"+i);
		}
		
		assertThrows(PilhaCheiaException.class, () -> p.empilha("ultimo")); //Estourando a pilha e checando se lançou exception
	}
	

}
