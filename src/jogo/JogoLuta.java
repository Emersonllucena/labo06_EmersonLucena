package jogo;

public class JogoLuta extends Jogo {
	
	public JogoLuta(String nome, double preco) throws Exception {
		super(nome, preco);
	}

	@Override
	public int registraJogada(int pontuacao, boolean zerou) {
		if(this.getMaiorScore() < pontuacao) {
			this.setMaiorScore(pontuacao);
			return this.getMaiorScore() / 1000;
		}
		if(zerou) {
			this.aumentaQtdZeradas();
		}
		
		this.aumentaQtdJogadas();
		
		return 0;
	}

	public String infoJogo() {
		return super.infoJogo("Luta");
	}
}
