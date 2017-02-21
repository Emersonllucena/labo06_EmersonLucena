package usuario;

import java.util.Map;

import excecoes.ArgumentoNuloExcecao;
import excecoes.EntradaInvalidaExcecao;
import jogo.Jogo;

public class Noob extends Usuario {
	
	public Noob(String nome, String login) throws EntradaInvalidaExcecao {
		super(nome, login);
	}
	
	public Noob(String nome, String login, double saldo, int x2p, Map<String, Jogo> jogosComprados) throws Exception {
		super(nome, login, saldo, x2p, jogosComprados);
	}
	
	public void registraJogada(String nomeDoJogo, int score, boolean zerou) throws Exception {
		if(!validaString(nomeDoJogo)) throw new EntradaInvalidaExcecao();
		Jogo jogo = this.getJogo(nomeDoJogo);
		if(jogo == null) throw new ArgumentoNuloExcecao("jogo nao pode ser null");
		
		int pontuacao = jogo.registraJogada(score, zerou);
		this.setX2p(this.getX2p() + pontuacao);
	}
	
	public boolean compraJogo(Jogo jogo) throws ArgumentoNuloExcecao {
		if(jogo == null) throw new ArgumentoNuloExcecao("jogo nao pode ser null");
		
		if(this.getSaldo() < jogo.getPreco() * 0.9) return false;
		
		this.setSaldo(this.getSaldo() - jogo.getPreco() * 0.9);
		this.setX2p(this.getX2p() + (int)jogo.getPreco() * 10);
		
		this.adicionaJogo(jogo);
		return true;
	}

	public boolean podeFazerUpgrade() {
		if(this.getX2p() >= 1000) return true;
		return false;
	}

	@Override
	public String toString() {
		return infoUsuario("Noob");
	}
}
