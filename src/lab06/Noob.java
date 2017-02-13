package lab06;

public class Noob extends Usuario {
	
	public Noob(String nome, String login) {
		super(nome, login);
	}
	
	public void registraJogada(String nomeDoJogo, int score, boolean zerou) {
		Jogo jogo = this.jogosComprados.get(nomeDoJogo);
		int pontuacao = jogo.registraJogada(score, zerou);
		this.x2p += (10 * (int)jogo.getPreco()) + pontuacao;
	}
}
