package jogo;

public class JogoRPG extends Jogo {
	
	public JogoRPG(String nome, double preco) {
		super(nome, preco);
	}

	@Override
	public int registraJogada(int pontuacao, boolean zerou) {
		if(this.getMaiorScore() < pontuacao) {
			this.setMaiorScore(pontuacao);
		}
		if(zerou) {
			this.aumentaQtdZeradas();
		}
		
		this.aumentaQtdJogadas();
		
		return 10;
	}
	
	@Override
	public String toString() {
		return infoJogo("RPG");
	}
}
