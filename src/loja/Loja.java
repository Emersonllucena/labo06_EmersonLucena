package loja;

import java.util.HashMap;
import java.util.Map;

import jogo.Jogo;
import usuario.Usuario;

public class Loja {
	private Map <String, Usuario> usuarios;
	private final String NL = System.lineSeparator();
	
	public Loja() {
		usuarios = new HashMap<>();
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
		
		if(usuario.getSaldo() < jogo.getPreco())
			return false;
		
		usuario.setSaldo(usuario.getSaldo() - jogo.getPreco());
		usuario.adicionaJogo(jogo);
		return true;
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
