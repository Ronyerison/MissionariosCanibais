/**
 * 
 */
package br.com.easii.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import br.com.easii.enums.PosicaoDoBarco;
import br.com.easii.find.BuscaCega;
import br.com.easii.problem.Estado;
import br.com.easii.util.EstruturaDeDados;
import br.com.easii.util.Fila;
import br.com.easii.util.Pilha;

/**
 * @author Ronyerison
 *
 */
public class TesteMissionarioscanibais {

	@Test
	public void testEquals() {
		Estado pai = new Estado(3, 3, PosicaoDoBarco.ESQUERDA, null, 0);
		Estado estado1 = new Estado(3, 3, PosicaoDoBarco.ESQUERDA, pai, 0);
		Estado estado2 = new Estado(3, 3, PosicaoDoBarco.ESQUERDA, pai, 1);
		boolean result = estado1.isEqual(estado2);
		Assert.assertEquals(true, result);
	}
	
	@Test
	public void testBuscaEmProfundidade() {
		Estado estado1 = new Estado(3, 3, PosicaoDoBarco.ESQUERDA, null, 0);
		BuscaCega buscaCega = new BuscaCega(estado1);
		buscaCega.buscaEmProfundidade();
//		EstruturaDeDados dados = new Pilha();
//		dados.inserir(1);
//		dados.inserir(2);
//		dados.inserir(3);
//		Assert.assertEquals(3, ((Pilha)dados).top());
//		dados.remover();
//		Assert.assertEquals(2, ((Pilha)dados).top());
	}
}
