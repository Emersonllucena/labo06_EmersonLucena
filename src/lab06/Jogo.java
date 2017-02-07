package lab06;

public class Jogo {
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
	
	public int registraJogada(int pontuacao, boolean zerou) {
		if(this.maiorScore < pontuacao) {
			this.maiorScore = pontuacao;
		}
		if(zerou) {
			this.qtdZeradas++;
		}
		
		this.qtdJogadas++;
		
		return x2p;
	}
}
