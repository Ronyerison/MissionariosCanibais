/**
 * 
 */
package br.com.easii.util;

import java.util.LinkedList;

import br.com.easii.problem.Estado;


/**
 * @author Ronyerison
 *
 */
public class Fila extends EstruturaDeDados{
	
	@Override
	public void remover(){
		this.getObjetos().remove(0);
	}
	
	public Estado primeiroElemento(){
		return (Estado) this.getObjetos().get(0);
	}
}
