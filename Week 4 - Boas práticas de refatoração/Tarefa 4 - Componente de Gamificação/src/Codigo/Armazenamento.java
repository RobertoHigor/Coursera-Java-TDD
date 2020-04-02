package Codigo;

import java.util.List;

public interface Armazenamento {

	public void armazenarPontos(int qtdPontos, String tipoPontos, String usuario);

	public List<String> retornarTodosOsUsuariosComPontos();

	public int recuperarPontosUsuarioTipo(String usuario, String tipoPonto);
	
	public String recuperarTodosOsPontos(String usuario);
}
