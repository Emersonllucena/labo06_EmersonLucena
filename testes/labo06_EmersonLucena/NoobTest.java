package labo06_EmersonLucena;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import excecoes.*;
import jogo.*;
import usuario.*;

public class NoobTest {
	
	Usuario user1;
	Usuario user2;
	Map <String, Jogo> jogosComprados;
	
	@Before
	public void prepara() throws Exception {
		user1 = new Noob("Emerson", "emerson.lucena");
		user2 = new Noob("Jose Carlos", "zeca");
		
		jogosComprados = new HashMap<>();
		//jogosComprados.put(key, value)
	}

	@Test
	public void testConstrutor_Exception() {
		try {
			Usuario userErro = new Noob("   ", "badlogin");
			fail("string vazia");
		} catch (EntradaInvalidaExcecao e) {
			assertEquals("Campo nao pode ser nulo ou vazio", e.getMessage());
		}
		
		try {
			Usuario userErro = new Noob("Irineu", null);
			fail("string vazia");
		} catch (EntradaInvalidaExcecao e) {
			assertEquals("Campo nao pode ser nulo ou vazio", e.getMessage());
		}
	}
	
	@Test
	public void testConstrutor2_Exception() {		
		try {
			Usuario userErro = new Noob("Joao", "jao", -5, 10, jogosComprados);
			fail("saldo negativo");
		} catch (Exception e) {
			assertEquals("Valor invalido", e.getMessage());
		}
		
		try {
			Usuario userErro = new Noob("Joao", "jao", 745, 10, null);
			fail("colecao de jogos null");
		} catch (Exception e) {
			assertEquals("jogosComprados nao pode ser null", e.getMessage());
		}
	}
	
	@Test
	public void testRegistraJogada() {
		fail("Not yet implemented");
		/**
		 * TODO (5h30min)
		 * fazer classe de testes de jogo primeiro (2h)
		 * terminar classes de teste (2h)
		 * fazer to_string, equals e hash_code (30min)
		 * fazer javadoc (1h)
		 */
	}

	@Test
	public void testCompraJogo() {
		fail("Not yet implemented");
	}

	@Test
	public void testPodeFazerUpgrade() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testUsuarioStringString() {
		fail("Not yet implemented");
	}

	@Test
	public void testUsuarioStringStringDoubleIntMapOfStringJogo() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdicionaJogo() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetJogo() {
		fail("Not yet implemented");
	}

	@Test
	public void testInfoUsuario() {
		fail("Not yet implemented");
	}

}
