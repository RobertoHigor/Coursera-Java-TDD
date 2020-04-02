/**
 * @author Roberto Higor Matos dos Anjos
 */
package Testes;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import Codigo.Armazenamento;
import Codigo.UsuarioInexistenteException;

public class MockArmazenamento implements Armazenamento {
	private String usuario;
	private List<String> execucoes = new ArrayList<String>();
	private String tipoPonto;
	private int qtdPontos;
	
	@Override
	public void armazenarPontos(int qtdPontos, String tipoPonto, String usuario) {
		execucoes.add("armazenarPontos");
	}

	@Override
	public List<String> retornarTodosOsUsuariosComPontos() {
		execucoes.add("retornarTodosOsUsuariosComPontos");
		List<String> lista= new ArrayList<String>();
		lista.add("Mario");
		lista.add("Luigi");
		lista.add("Wario");
		return lista;
	}

	@Override
	public int recuperarPontosUsuarioTipo(String usuario, String tipoPonto) {
		execucoes.add("recuperarPontosUSuarioTipo");
		if (usuario.equals("Luigi")){
			return 10;
		}else if (usuario.equals("Wario")) {
			return 2;
		}
		return 5;
	}

	@Override
	public String recuperarTodosOsPontos(String usuario) {
		execucoes.add("recuperarTodosOsPontos");
		
		if (this.usuario.equals(usuario))
			return usuario;
		else
			throw new UsuarioInexistenteException();
	}
	
	public void verificaChamadas(String... execs) {
		for (int i = 0; i < execs.length; i++)
			if(!execucoes.get(i).equals(execs[i])) 
				fail();
	}

	public void setUsuario(String usuario, String tipoPonto, int qtdPonto) {
		this.usuario = usuario;	
		this.tipoPonto  = tipoPonto;
		this.qtdPontos = qtdPonto;
	}
	
	public void verificaPontos(String usuario, String tipoPonto, int qtdPonto) {
		assertEquals("mario moeda 5", usuario + " " + tipoPonto +" " + qtdPonto);
	}

}
