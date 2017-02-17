package jogo;

public class JogoPlataforma extends Jogo {
	
	public JogoPlataforma(String nome, double preco) throws Exception {
		super(nome, preco);
	}

	@Override
	public int registraJogada(int pontuacao, boolean zerou) {
		if(this.getMaiorScore() < pontuacao) {
			this.setMaiorScore(pontuacao);
		}
		if(zerou) {
			this.aumentaQtdZeradas();
			return 20;
		}
		
		this.aumentaQtdJogadas();
		
		return 0;
	}
	
	public String infoJogo() {
		return super.infoJogo("Plataforma");
	}
}
