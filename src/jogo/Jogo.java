package jogo;

public abstract class Jogo {
	private final String NL = System.lineSeparator();
	private String nome;
	private double preco;
	private int maiorScore;
	private int qtdJogadas;
	private int qtdZeradas;
	
	public Jogo(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
		this.maiorScore = 0;
		this.qtdJogadas = 0;
		this.qtdZeradas = 0;
	}
	
	public abstract int registraJogada(int pontuacao, boolean zerou);
	
	public double getPreco() {
		return this.preco;
	}

	public int getMaiorScore() {
		return maiorScore;
	}

	public void setMaiorScore(int maiorScore) {
		this.maiorScore = maiorScore;
	}

	public int getQtdJogadas() {
		return qtdJogadas;
	}

	public void aumentaQtdJogadas() {
		this.qtdJogadas++;
	}

	public int getQtdZeradas() {
		return qtdZeradas;
	}

	public void aumentaQtdZeradas() {
		this.qtdZeradas++;
	}

	public String getNome() {
		return nome;
	}

	public String infoJogo(String tipoJogo) {
		String infoJogo = "";
		infoJogo += "+ " + nome + " - " + tipoJogo + ":" + NL;
		infoJogo += "==> Jogou " + qtdJogadas + "vez(es)" + NL;
		infoJogo += "==> Zerou " + qtdZeradas + "vez(es)" + NL;
		infoJogo += "==> Maior score: " + maiorScore + NL;
		
		return infoJogo;
	}
	
}