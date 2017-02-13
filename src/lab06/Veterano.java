package lab06;

public class Veterano extends Usuario {

	public Veterano(String nome, String login) {
		super(nome, login);
	}
	
	public void registraJogada(String nomeDoJogo, int score, boolean zerou) {
		Jogo jogo = this.jogosComprados.get(nomeDoJogo);
		int pontuacao = jogo.registraJogada(score, zerou);
		this.x2p += (15 * (int)jogo.getPreco()) + pontuacao;
	}
}
