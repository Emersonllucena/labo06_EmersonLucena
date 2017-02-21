package jogo;

import java.util.Set;

public class JogoRPG extends Jogo {
	
	public JogoRPG(String nome, double preco) throws Exception {
		super(nome, preco);
	}
	
	public JogoRPG(String nome, double preco,  Set <Jogabilidade> estilosJogo) throws Exception {
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
		}
		
		return 10;
	}
	
	@Override
	public String toString() {
		return super.infoJogo("RPG");
	}
}
