import java.util.ArrayList;
import java.util.List;

public class Camel {

	private static List<String> camelc = new ArrayList<>();

	public static List<String> converterCamelCase(String original) {
		validar(original);
		String[] guardar = original.split("(?<!^)(?=[A-Z])");
		for (int i = 0; i < guardar.length; i++) {
			camelc.add(guardar[i]);
		}
		return camelc;
	}

	public static void limpar() {
		camelc.clear();
	}

	public static String validar(String original) {
		if (Character.isDigit(original.charAt(0))) {
			throw new CamelNumeroException("Não pode começar com números");
		} else {
			return original;
		}
	}
}
