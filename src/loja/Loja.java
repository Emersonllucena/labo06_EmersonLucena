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
	
	public void upgrade(String login) {
		try {
			if(!validaString(login)) throw new EntradaInvalidaExcecao();
			
			Usuario usuario = usuarios.get(login);
			if(usuario == null) throw new ArgumentoNuloExcecao("usuario nao encontrado");
			if(!usuario.podeFazerUpgrade()) throw new UpgradeExcecao();
			
			usuarios.remove(login);
			
			//Captura informacoes do usuario antes do upgrade
			String nome = usuario.getNome();
			double saldo = usuario.getSaldo();
			int x2p = usuario.getX2p();
			Map<String, Jogo> jogosComprados = usuario.getJogosComprados();
			
			Usuario usuarioUpgrade = new Veterano(nome, login, saldo, x2p, jogosComprados);
			usuarios.put(login, usuarioUpgrade);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void adicionaUsuario(Usuario usuario) {
		try {
			if(usuario == null) throw new ArgumentoNuloExcecao("usuario nao pode ser null");	
			usuarios.put(usuario.getLogin(), usuario);			
		} catch (ArgumentoNuloExcecao e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void adicionaDinheiro(String login, int qtdDinheiro) {
		try {
			if(!validaString(login)) throw new EntradaInvalidaExcecao();
			Usuario usuario = usuarios.get(login);
			
			if(usuario == null) throw new ArgumentoNuloExcecao("usuario nao encontrado");
			if(qtdDinheiro <= 0) throw new ValorInvalidoExcecao();
			
			usuario.setSaldo(usuario.getSaldo() + qtdDinheiro);			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public boolean vendeJogo(String login, Jogo jogo) {
		try {
			if(!validaString(login)) throw new EntradaInvalidaExcecao();
			
			Usuario usuario = usuarios.get(login);
			if(usuario == null) throw new ArgumentoNuloExcecao("usuario nao encontrado");
			if(jogo == null) throw new ArgumentoNuloExcecao("jogo nao pode ser nulo");
			
			return usuario.compraJogo(jogo);			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
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
	
	public Usuario getUsuario(String login) {
		return usuarios.get(login);
	}
}
