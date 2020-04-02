/**
 * @author Roberto Higor Matos dos Anjos
 */
package Testes;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import Codigo.Armazenamento;
import Codigo.ArmazenamentoArquivo;
import Codigo.UsuarioInexistenteException;

class ArmazenamentoTeste {
	static Armazenamento armazenamento;
	
	@BeforeAll
	static void criarArquivo() {
		File file = new File("banco.txt");
		file.delete();
		armazenamento = new ArmazenamentoArquivo();
		armazenamento.armazenarPontos(5, "moeda", "Mario");
		armazenamento.armazenarPontos(5, "moeda", "Luigi");
		armazenamento.armazenarPontos(5, "moeda", "Luigi");
		armazenamento.armazenarPontos(1, "estrela", "Luigi");
		armazenamento.armazenarPontos(5, "cogumelo", "Luigi");
		armazenamento.armazenarPontos(0, "moeda", "Waluigi");
		armazenamento.armazenarPontos(0, "moeda", "Birdo");
	}
	
	// Recuperar Pontos
	@Test
	void recuperarPontosUsuarioTipo(){
		assertEquals(5, armazenamento.recuperarPontosUsuarioTipo("Mario", "moeda"));
	}
	
	@Test
	void recuperarPontosSomado() {
		assertEquals(10, armazenamento.recuperarPontosUsuarioTipo("Luigi", "moeda"));
	}
	
	@Test
	void recuperarDoisTiposDePontos() {
		assertEquals(10, armazenamento.recuperarPontosUsuarioTipo("Luigi", "moeda"));
		assertEquals(1, armazenamento.recuperarPontosUsuarioTipo("Luigi", "estrela"));
	}
	
	@Test
	void recuperarTrêsTiposDePontos() {
		assertEquals(10, armazenamento.recuperarPontosUsuarioTipo("Luigi", "moeda"));
		assertEquals(1, armazenamento.recuperarPontosUsuarioTipo("Luigi", "estrela"));
		assertEquals(5, armazenamento.recuperarPontosUsuarioTipo("Luigi", "cogumelo"));
	}
	
	@Test
	void recuperarUsuarioInexistente() {
		assertThrows(UsuarioInexistenteException.class, () -> armazenamento.recuperarPontosUsuarioTipo("Wario", "estrela"));
	}
	
	// Recuperar usuários com pontos
	
	@Test
	void retornarUsuariosComPontos() {
		assertEquals(true, armazenamento.retornarTodosOsUsuariosComPontos().contains("Mario"));
		assertEquals(true, armazenamento.retornarTodosOsUsuariosComPontos().contains("Luigi"));
	}
	
	@Test
	void naoRetornarUsuariosSemPontos() {
		assertEquals(false, armazenamento.retornarTodosOsUsuariosComPontos().contains("Wario"));
		assertEquals(false, armazenamento.retornarTodosOsUsuariosComPontos().contains("Birdo"));
	}
	
	// Recuperar todos os pontos de um usuário
	@Test
	void recuperarTodosOsPontos() {
		assertEquals("Luigi moeda 10, estrela 1, cogumelo 5", armazenamento.recuperarTodosOsPontos("Luigi"));
	}
}
