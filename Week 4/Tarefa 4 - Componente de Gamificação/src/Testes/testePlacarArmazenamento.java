package Testes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import Codigo.ArmazenamentoArquivo;
import Codigo.Placar;

class testePlacarArmazenamento {
	ArmazenamentoArquivo armazenamento;
	Placar placar;

	@Test
	void recuperarTodosOsPontos() {
		armazenamento = new ArmazenamentoArquivo();
		placar = new Placar(armazenamento);
		assertEquals("Luigi moeda 10, estrela 1, cogumelo 5", placar.retornarTodosOsPontosDeUmUsuario("Luigi"));
	}

	@Test
	void retornarRanking() {
		armazenamento = new ArmazenamentoArquivo();
		placar = new Placar(armazenamento);
			
		List<String> ranking = new ArrayList<String>();
		ranking.add("Luigi moeda 10");
		ranking.add("Mario moeda 5");
		assertEquals(ranking, placar.retornarRankingTipo("moeda"));
	}
	
	@Test
	void adicionarERetornarUsuario() {
		armazenamento = new ArmazenamentoArquivo();
		placar = new Placar(armazenamento);
			
		placar.adicionarPontosUsuario("Yoshi", "moeda", 15);
		assertEquals("Yoshi moeda 15", placar.retornarTodosOsPontosDeUmUsuario("Yoshi"));
		placar.adicionarPontosUsuario("Yoshi", "moeda", -15);
	}
	
	@Test
	void naoRetornarUsuarioSemPontos() {
		armazenamento = new ArmazenamentoArquivo();
		placar = new Placar(armazenamento);
			
		assertEquals(null, placar.retornarTodosOsPontosDeUmUsuario("Zaquin"));
	}
}
