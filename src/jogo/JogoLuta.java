package jogo;

import java.util.Set;

public class JogoLuta extends Jogo {
	
	public JogoLuta(String nome, double preco) throws Exception {
		super(nome, preco);
	}
	
	public JogoLuta(String nome, double preco,  Set <Jogabilidade> estilosJogo) throws Exception {
		super(nome, preco, estilosJogo);
	}

	@Override
	public int registraJogada(int pontuacao, boolean zerou) {
		this.aumentaQtdJogadas();
		
		if(zerou) {
			this.aumentaQtdZeradas();
		}
		if(this.getMaiorScore() < pontuacao) {
			this.setMaiorScore(pontuacao);
			return this.getMaiorScore() / 1000;
		}
		
		return 0;
	}

	@Override
	public String toString() {
		return super.infoJogo("Luta");
	}
}
