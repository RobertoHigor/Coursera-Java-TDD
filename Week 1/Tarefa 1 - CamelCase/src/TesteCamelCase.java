import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TesteCamelCase {
	List<String> listaPreenchida;
	List<String> lista;
	@BeforeEach
	void iniciarLista() {	
		listaPreenchida = new ArrayList<String>();
		
		listaPreenchida.add("julia");
		listaPreenchida.add("marins");
	}
	
	@Test
	void testeConverterCamelCase() {		
		lista = Camel.converterCamelCase("juliaMarins");
		
		assertEquals("julia", lista.get(0));
		assertEquals("marins", lista.get(1));
		assertEquals(listaPreenchida, lista);
	}
	
	
	@Test 
	void iniciaComNumero() {
		assertThrows(CamelNumeroException.class, () -> Camel.converterCamelCase("1juliaMarins"));
	}
	
	@Test
	void contemCaractereEspecial() {
		assertThrows(CamelCaractereEspecialException.class, () -> Camel.converterCamelCase("Julia#Marins"));
	}
	
	@Test
	void separaPorNumero() {
		lista = Camel.converterCamelCase("julia10marins");
		
		assertEquals("julia", lista.get(0));
		assertEquals("10", lista.get(1));
		assertEquals("marins", lista.get(2));
	}
	
	@Test
	void separarSigla() {
		lista = Camel.converterCamelCase("juliaMCAlmeida");
		
		assertEquals("julia", lista.get(0));
		assertEquals("mc", lista.get(1));
		assertEquals("almeida", lista.get(2));
	}

}
