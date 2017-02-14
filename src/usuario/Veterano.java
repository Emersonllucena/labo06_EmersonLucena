package usuario;

import jogo.Jogo;

public class Veterano extends Usuario {

	public Veterano(String nome, String login) {
		super(nome, login);
	}
	
	public void registraJogada(String nomeDoJogo, int score, boolean zerou) {
		Jogo jogo = this.getJogo(nomeDoJogo);
		int pontuacao = jogo.registraJogada(score, zerou);
		this.setX2p(this.getX2p() + (15 * (int)jogo.getPreco()) + pontuacao);
	}
	
	@Override
	public String toString() {
		return infoUsuario("Veterano");
	}
}
