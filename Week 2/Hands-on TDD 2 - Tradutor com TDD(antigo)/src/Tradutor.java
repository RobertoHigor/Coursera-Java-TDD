
public class Tradutor {
	
	private String traducao;
	
	public boolean estaVazio() {
		return traducao == null;
	}

	public void addTraducao(String palavra, String traducao) {
		this.traducao = traducao;
	}

	public Object traduzir(String string) {
		return traducao;
	}

}
