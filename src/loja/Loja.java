package loja;

import java.util.HashMap;
import java.util.Map;

import jogo.*;
import usuario.*;

public class Loja {
	private Map <String, Usuario> usuarios;
	private final String NL = System.lineSeparator();
	
	public Loja() {
		usuarios = new HashMap<>();
	}
	
	public void upgrade(String login) {
		//TODO adicionar exception - ja veterano ou sem pontuacao
		Usuario usuario = usuarios.get(login);
		usuarios.remove(login);
		
		String nome = usuario.getNome();
		double saldo = usuario.getSaldo();
		int x2p = usuario.getX2p();
		Map<String, Jogo> jogosComprados = usuario.getJogosComprados();
		
		Usuario usuarioUpgrade = new Veterano(nome, login);
		usuarioUpgrade.setSaldo(saldo);
		usuarioUpgrade.setX2p(x2p);
		usuarioUpgrade.setJogosComprados(jogosComprados);
		
		usuarios.put(login, usuarioUpgrade);
	}
	
	public void adicionaUsuario(Usuario usuario) {
		usuarios.put(usuario.getLogin(), usuario);	
	}
	
	public void adicionaDinheiro(String login, int qtdDinheiro) {
		Usuario usuario = usuarios.get(login);
		usuario.setSaldo(usuario.getSaldo() + qtdDinheiro);
	}
	
	public boolean vendeJogo(String login, Jogo jogo) {
		Usuario usuario = usuarios.get(login);
		return usuario.compraJogo(jogo);
	}
	
	public String imprimeUsuarios() {
		String infoUsuarios = "";
		
		infoUsuarios += "=== Central P2-CG ===" + NL;
		
		for(Usuario usuario : usuarios.values()) {
			infoUsuarios += usuario.toString() + NL;
		}
		
		infoUsuarios += "--------------------------------------------" + NL;
		
		return infoUsuarios;
	}
}
