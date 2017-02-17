package excecoes;

public class UpgradeExcecao extends Exception {
	private static final long serialVersionUID = 1L;
	
	public UpgradeExcecao() {
		super("Nao e possivel fazer upgrade");
	}
}
