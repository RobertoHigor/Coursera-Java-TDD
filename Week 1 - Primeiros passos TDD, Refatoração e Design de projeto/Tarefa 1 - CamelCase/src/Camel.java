import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Roberto
 *
 */
public class Camel {

	public static List<String> converterCamelCase(String string) {
		List<String> lista = new ArrayList<String>();
		
		if(iniciaComNumero(string))
			throw new CamelNumeroException("Não pode iniciar com número");
		
		if(contemCaractereEspecial(string))
			throw new CamelCaractereEspecialException("Não pode conter caracteres especiais");
		
		/*
		 * String[] dividido = string.split("((?<=[a-z])(?=[0-9])" //Cortar se houver um número após uma letra minúscula
				+ "|"
				+ "(?<=[0-9])(?=[a-z]))" //Cortar após um número se houver uma letra minúscula após um número
				+ "|"
				+ "((?<=[a-z])(?=[A-Z])" //Cortar caso haja uma letra minúscula atrás e uma maiúscula a frente
				+ "|"
				+ "(?<=[A-Z])(?=[A-Z][a-z]))"); //O primeiro serve para cortar antes de uma letra maiúscula
				//O segundo serve para cortar antes de uma letra maíuscula que esteja atrás de uma minúscula
				//No caso de igula, tenhoCPFagora ele irá cortar no tenhoCPF agora
		*/
		String[] dividido = string.split("((?<=\\p{Lower})(?=\\p{Digit})"
				+ "|"
				+ "(?<=\\p{Digit})(?=\\p{Lower}))"
				+ "|"
				+ "((?<=\\p{Lower})(?=\\p{Upper})"
				+ "|"
				+ "(?<=\\p{Upper})(?=\\p{Upper}\\p{Lower}))");
		//(?=\\p{Digit})
		
		for (int i = 0; i < dividido.length; i++) {
			lista.add(dividido[i].toLowerCase());
		}
		return lista;
	}
	
	private static Boolean iniciaComNumero(String string) {
		return Character.isDigit(string.charAt(0));		
	}
	
	private static Boolean contemCaractereEspecial(String string) {
		//Regex comparando se existe algum caractere especial
		//O começo ^ é um elemento de negação, que é fechado pelo símbulo +$
		//Ou seja, o regex ^[a-z]+$ procura um elemento que não seja entre a-z
		//Por padrão, ele retorna true caso ache um elemento que não seja letra ou número
		return !string.matches("^[A-Za-z\\d]+$"); //Simbulo de negação no retorno para retornar true caso tenha caractere especial
	}

}
