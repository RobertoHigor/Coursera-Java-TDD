import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TesteTradutor {
/*
 * Usando uma lista de tarefas para criar os testes:
 * - Tradutor sem Palavras
 * - Uma tradução
 * - Duas Traduções
 * - Duas traduções, mesma palavra
 * - Traduzir Frase 
 * 
 * Por fim foi adicionado "Traduzir frase c/ 2 traduções c/ mesma palavra
 */
	
	Tradutor t;
	@BeforeEach
	public void criarTraducao() {
		t = new Tradutor();
	}
	@Test
	public void tradutorSemPalavras() {
		assertTrue(t.estaVazio());
	}
	
	@Test
	public void umaTraducao() {		
		t.adicionaTraducao("bom", "good");
		assertFalse(t.estaVazio());
		assertEquals("good", t.traduzir("bom"));
	}
	
	@Test
	public void duasTraducoes() {		
		t.adicionaTraducao("bom", "good");
		t.adicionaTraducao("mal", "bad");
		assertFalse(t.estaVazio());
		assertEquals("good", t.traduzir("bom"));
		assertEquals("bad", t.traduzir("mal"));
	}
	
	@Test
	public void duasTraducoesMesmaPalavra() {		
		t.adicionaTraducao("bom", "good");
		t.adicionaTraducao("bom", "nice");
		assertFalse(t.estaVazio());
		assertEquals("good, nice", t.traduzir("bom"));
	}
	
	@Test
	public void traduzirUmaFrase() {
		t.adicionaTraducao("guerra", "war");
		t.adicionaTraducao("é", "is");
		t.adicionaTraducao("ruim", "bad");
		assertFalse(t.estaVazio());
		assertEquals("war is bad", t.traduzirFrase("guerra é ruim"));
	}
	
	@Test
	public void traduzirUmaFraseComDuasTraducoesMesmaPalavra() {
		t.adicionaTraducao("paz", "peace");
		t.adicionaTraducao("é", "is");
		t.adicionaTraducao("bom", "good");
		t.adicionaTraducao("bom", "nice");
		assertFalse(t.estaVazio());
		assertEquals("peace is good", t.traduzirFrase("paz é bom"));
	}
}
