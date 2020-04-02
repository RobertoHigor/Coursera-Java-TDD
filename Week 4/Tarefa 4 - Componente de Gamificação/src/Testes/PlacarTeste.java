package Testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import Codigo.Placar;
import Codigo.UsuarioInexistenteException;

class PlacarTeste {
	Placar placar;
	MockArmazenamento mock;
	
	//Retornar todos os pontos de um usuario
	@Test
	void adicionarPontosUSuario() {
		mock = new MockArmazenamento();
		placar = new Placar(mock);
		mock.setUsuario("Mario", "moeda", 5);
		placar.adicionarPontosUsuario("Mario", "moeda", 5);
		mock.verificaChamadas("armazenarPontos");
	}
	
	@Test
	void adicionarDoisTiposDePontos() {
		mock = new MockArmazenamento();
		placar = new Placar(mock);
		mock.setUsuario("Luigi", "moeda", 5);
		placar.adicionarPontosUsuario("Luigi", "moeda", 5);
		placar.adicionarPontosUsuario("Luigi", "estrela", 1);
		mock.verificaChamadas("armazenarPontos", "armazenarPontos");;
	}
	

	@Test
	void naoRetornarUsuarioInexistente() {
		mock = new MockArmazenamento();
		placar = new Placar(mock);
		mock.setUsuario("Invalido", "moeda", 5);		
		assertThrows(UsuarioInexistenteException.class, () -> placar.retornarTodosOsPontosDeUmUsuario("Waluigi"));
		mock.verificaChamadas("recuperarTodosOsPontos");
	}
	
	//Ranking
	@Test
	void retornarRankingPorTipo() {
		mock = new MockArmazenamento();
		placar = new Placar(mock);
		mock.setUsuario("Mario","moeda", 5);
		mock.setUsuario("Luigi", "Moeda", 10);
		mock.setUsuario("Wario", "moeda", 2);
		List<String> ranking = new ArrayList<String>();
		ranking.add("Luigi moeda 10");
		ranking.add("Mario moeda 5");
		ranking.add("Wario moeda 2");
		assertEquals(ranking, placar.retornarRankingTipo("moeda"));
		mock.verificaChamadas("retornarTodosOsUsuariosComPontos", "recuperarPontosUSuarioTipo", "recuperarPontosUSuarioTipo");
	}
	
	

}
