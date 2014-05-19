/**
 * 
 */
package br.com.easii.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.easii.enums.PosicaoDoBarco;
import br.com.easii.find.AEstrela;
import br.com.easii.find.BuscaCega;
import br.com.easii.problem.Estado;
import br.com.easii.problem.Solution;

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
		Estado estadofinal = new Estado(0, 0, PosicaoDoBarco.DIREITA, null, 0);
		BuscaCega buscaCega = new BuscaCega(estado1);
		Solution solution = buscaCega.buscaEmProfundidade();
		System.out.println("\nProfundidade\n");
		System.out.println(solution.mostraCaminho());
		boolean result = estadofinal.isEqual(solution.getEstadoFinal());
		Assert.assertEquals(true, result);
	}
	
	@Test
	public void testBuscaEmLargura() {
		Estado estado1 = new Estado(3, 3, PosicaoDoBarco.ESQUERDA, null, 0);
		Estado estadofinal = new Estado(0, 0, PosicaoDoBarco.DIREITA, null, 0);
		BuscaCega buscaCega = new BuscaCega(estado1);
		Solution solution = buscaCega.buscaEmLargura();
		System.out.println("\nLargura\n");
		System.out.println(solution.mostraCaminho());
		boolean result = estadofinal.isEqual(solution.getEstadoFinal());
		Assert.assertEquals(true, result);
	}
	
	@Test
	public void testBuscaAEstrela() {
		Estado estado1 = new Estado(3, 3, PosicaoDoBarco.ESQUERDA, null, 0);
		Estado estadofinal = new Estado(0, 0, PosicaoDoBarco.DIREITA, null, 0);
		AEstrela aEstrela = new AEstrela(estado1);
		Solution solution = aEstrela.execute();
		System.out.println("\nAEstrela\n");
		System.out.println(solution.mostraCaminho());
		boolean result = estadofinal.isEqual(solution.getEstadoFinal());
		Assert.assertEquals(true, result);
	}
}
