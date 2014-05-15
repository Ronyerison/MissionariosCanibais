/**
 * 
 */
package br.com.easii.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import br.com.easii.enums.PosicaoDoBarco;
import br.com.easii.problem.Estado;

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

}
