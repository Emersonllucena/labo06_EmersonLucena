package excecoes;

public class EntradaInvalidaExcecao extends Exception {
	private static final long serialVersionUID = 1L;
	
	public EntradaInvalidaExcecao() {
		super("Campo nao pode ser nulo ou vazio");
	}
}
