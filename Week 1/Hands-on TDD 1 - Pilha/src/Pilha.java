public class Pilha {
	
	private Object[] elementos;
	private int quantidade = 0;
	
	public Pilha(int maximo) {
		elementos = new Object[maximo];
	}

	public int tamanho() {
		return quantidade;
	}

	public Boolean estaVazia() {
		return quantidade == 0;
	}

	public void empilha(Object elemento) {
		if (quantidade >= elementos.length) // Se a variável quantidade for maior que o tamanho do array de Pilha
			throw new PilhaCheiaException("Não é posível empilhar mais elementos"); //Lançar exception
		this.elementos[quantidade] = elemento;
		quantidade++;
		
	}

	public Object topo() {		
		return elementos[quantidade-1];
	}

	public Object desempilha() {
		if(estaVazia())
			throw new PilhaVaziaException("Não é possível desempilhar");
		Object topo = topo();
		quantidade--;
		return topo;
	}

}
