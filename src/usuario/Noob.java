package usuario;

import jogo.Jogo;

public class Noob extends Usuario {
	
	public Noob(String nome, String login) {
		super(nome, login);
	}
	
	public void registraJogada(String nomeDoJogo, int score, boolean zerou) {
		Jogo jogo = this.getJogo(nomeDoJogo);
		int pontuacao = jogo.registraJogada(score, zerou);
		this.setX2p(this.getX2p() + (10 * (int)jogo.getPreco()) + pontuacao);
	}

	@Override
	public String toString() {
		return infoUsuario("Noob");
	}
}
