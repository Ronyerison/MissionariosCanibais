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

public class Pilha extends EstruturaDeDados{
	
	@Override
	public void remover(){
		this.getObjetos().remove(getObjetos().size()-1);
	}
	
	/**
	 * @return retorna o ultimo elemento inserido sem removê-lo
	 */
	public Estado top(){
		return this.getObjetos().get(getObjetos().size()-1);
	}
}
