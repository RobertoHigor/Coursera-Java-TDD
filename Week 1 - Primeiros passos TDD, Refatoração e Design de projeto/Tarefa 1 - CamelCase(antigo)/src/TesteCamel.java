import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TesteCamel {

	@Before
	public void before(){
		Camel.limpar();
	}
	
	@Test
	public void camelCase() {
		List<String> lista = Arrays.asList("roberto", "Higor");
		assertEquals(lista, Camel.converterCamelCase("robertoHigor"));
	}
	
	@Test(expected = CamelNumeroException.class)
	public void camelNaoNumero() {
		List<String> lista = Arrays.asList("1roberto", "Higor");
		assertEquals(lista, Camel.converterCamelCase("1robertoHigor"));
	}

}
