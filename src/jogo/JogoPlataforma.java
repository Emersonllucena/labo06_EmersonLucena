package jogo;

import java.util.Set;

public class JogoPlataforma extends Jogo {
	
	public JogoPlataforma(String nome, double preco) throws Exception {
		super(nome, preco);
	}
	
	public JogoPlataforma(String nome, double preco,  Set <Jogabilidade> estilosJogo) throws Exception {
		super(nome, preco, estilosJogo);
	}

	@Override
	public int registraJogada(int pontuacao, boolean zerou) {
		this.aumentaQtdJogadas();
		
		if(this.getMaiorScore() < pontuacao) {
			this.setMaiorScore(pontuacao);
		}
		if(zerou) {
			this.aumentaQtdZeradas();
			return 20;
		}
		
		return 0;
	}
	
	@Override
	public String toString() {
		return super.infoJogo("Plataforma");
	}
}
