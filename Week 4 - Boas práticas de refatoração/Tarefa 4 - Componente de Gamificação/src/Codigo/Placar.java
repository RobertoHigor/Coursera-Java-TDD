/**
 * @author Roberto Higor Matos dos Anjos
 */
package Codigo;

import java.util.Collections;
import java.util.List;

public class Placar {
	private Armazenamento armazenamento;
	
	public Placar(Armazenamento armazenamento) {
		this.armazenamento = armazenamento;
	}

	public void adicionarPontosUsuario(String usuario, String tipoPonto, int qtdPontos) {
		armazenamento.armazenarPontos(qtdPontos, tipoPonto, usuario);		
	}

	public String retornarTodosOsPontosDeUmUsuario(String usuario) {
		return armazenamento.recuperarTodosOsPontos(usuario);
	}

	public List<String> retornarRankingTipo(String tipoPonto) {
		List<String> usuariosComPontos = armazenamento.retornarTodosOsUsuariosComPontos();
		String[] linhaAtual;
		String[] maiorLinha;
		String[] linha;
		int maiorIndice;
		
		for(int i = 0; i < usuariosComPontos.size(); i++) {
			maiorIndice = i;
			int qtdPontosMaior = 0;
			int qtdPontoUsuarioAtual = 0;
		
			for(int x = i; x < usuariosComPontos.size(); x++) {
				maiorLinha = usuariosComPontos.get(maiorIndice).split(" ");
				linhaAtual = usuariosComPontos.get(x).split(" ");
				
				qtdPontosMaior = armazenamento.recuperarPontosUsuarioTipo(maiorLinha[0], tipoPonto);
				qtdPontoUsuarioAtual = armazenamento.recuperarPontosUsuarioTipo(linhaAtual[0], tipoPonto);	
				if (qtdPontoUsuarioAtual < qtdPontosMaior) {
					maiorIndice = x;
				}						
			}
			linha = usuariosComPontos.get(maiorIndice).split(" ");
			int qtdPontos = armazenamento.recuperarPontosUsuarioTipo(linha[0], tipoPonto);
			
			Collections.swap(usuariosComPontos, maiorIndice, i);
			usuariosComPontos.set(i, usuariosComPontos.get(i) + " " + tipoPonto + " " + qtdPontos);
		}
		Collections.reverse(usuariosComPontos);
		return usuariosComPontos;
	}
}
