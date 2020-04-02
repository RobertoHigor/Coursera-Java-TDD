import static org.junit.Assert.*;

import org.junit.Test;

public class TesteTradutor {

	@Test
	public void tradutorSemPalavra() {
		Tradutor t = new Tradutor();
		assertTrue(t.estaVazio());
	}

	@Test
	public void umaTraducao() {
		Tradutor t = new Tradutor();
		t.addTraducao("bom", "good");
		assertFalse(t.estaVazio());
		assertEquals("good", t.traduzir("bom"));
	}

}
