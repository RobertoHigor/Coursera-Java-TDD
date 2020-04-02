import java.util.HashMap;
import java.util.Map;

public class Tradutor {
	private Map<String, String> traducoes = new HashMap<>();

	public Boolean estaVazio() {
		// TODO Auto-generated method stub
		return traducoes.isEmpty();
	}

	/* 
	 * No começo o método era apenas this.traducao = traducao
	 */
	public void adicionaTraducao(String palavra, String traducao) {
		//Se atradução já existe, repete a tradução antiga e adiciona uma vírgula para inserir a nova tradução
		if(traducoes.containsKey(palavra)) {
			traducao = traduzir(palavra) + ", " + traducao;
		}
		this.traducoes.put(palavra, traducao);
		
	}

	/*
	 * No começo apenas retornava a variável traducao
	 */
	public String traduzir(String palavra) {
		return traducoes.get(palavra);
	}

		public String traduzirFrase(String frase) {
		//Adiciona as palavras da frase separado por espaço no array frases
		String[] frases = frase.split(" ");
		String fraseTraduzida = "";
			
		for (String palavra : frases) {
			String traducao = primeiraTraducao(palavra);
			fraseTraduzida += " " + traducao;
		}
		//Nesse caso o trimm corta o primeiro espaço da string
		return fraseTraduzida.trim();
	}
		
	/*
	 * Foi utilizado Refactor > Extract Method para separar a checagem da primeira palavra em outro método
	 */
	private String primeiraTraducao(String palavra) {
		//Adiciona espaço antes de cada palavra (inclusive da primeira)
		String traducao = this.traduzir(palavra);
		//Se a tradução tiver uma vírgula (2 traduções pra uma palavra), então é pego a substring até antes da vírgula
		if(traducao.contains(","))
			traducao = traducao.substring(0, traducao.indexOf(","));
		return traducao;
	}

}
