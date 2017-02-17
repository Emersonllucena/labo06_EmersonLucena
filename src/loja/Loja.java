package loja;

import java.util.HashMap;
import java.util.Map;

import excecoes.ArgumentoNuloExcecao;
import excecoes.EntradaInvalidaExcecao;
import excecoes.UpgradeExcecao;
import excecoes.ValorInvalidoExcecao;
import jogo.*;
import usuario.*;

public class Loja {
	private Map <String, Usuario> usuarios;
	private final String NL = System.lineSeparator();
	
	public Loja() {
		usuarios = new HashMap<>();
	}
	
	public void upgrade(String login) throws Exception {
		if(!validaString(login)) throw new EntradaInvalidaExcecao();
		
		Usuario usuario = usuarios.get(login);
		if(usuario == null) throw new ArgumentoNuloExcecao("usuario nao encontrado");
		if(!usuario.podeFazerUpgrade()) throw new UpgradeExcecao();
		
		usuarios.remove(login);
		
		String nome = usuario.getNome();
		double saldo = usuario.getSaldo();
		int x2p = usuario.getX2p();
		Map<String, Jogo> jogosComprados = usuario.getJogosComprados();
		
		Usuario usuarioUpgrade = new Veterano(nome, login, saldo, x2p, jogosComprados);
		usuarios.put(login, usuarioUpgrade);
	}
	
	public void adicionaUsuario(Usuario usuario) throws ArgumentoNuloExcecao {
		if(usuario == null) throw new ArgumentoNuloExcecao("usuario nao pode ser null");	
		usuarios.put(usuario.getLogin(), usuario);	
	}
	
	public void adicionaDinheiro(String login, int qtdDinheiro) throws Exception {
		if(!validaString(login)) throw new EntradaInvalidaExcecao();
		Usuario usuario = usuarios.get(login);
		
		if(usuario == null) throw new ArgumentoNuloExcecao("usuario nao encontrado");
		if(qtdDinheiro <= 0) throw new ValorInvalidoExcecao();
		
		usuario.setSaldo(usuario.getSaldo() + qtdDinheiro);
	}
	
	public boolean vendeJogo(String login, Jogo jogo) throws Exception {
		if(!validaString(login)) throw new EntradaInvalidaExcecao();
		
		Usuario usuario = usuarios.get(login);
		if(usuario == null) throw new ArgumentoNuloExcecao("usuario nao encontrado");
		if(jogo == null) throw new ArgumentoNuloExcecao("jogo nao pode ser nulo");
		
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
	
	public boolean validaString(String str) {
		if(str == null || str.trim().equals("")) return false;
		return true;
	}
}
