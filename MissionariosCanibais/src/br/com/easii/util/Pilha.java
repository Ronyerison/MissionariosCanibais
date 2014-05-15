/**
 * 
 */
package br.com.easii.util;

/**
 * @author Ronyerison
 *
 */

public class Pilha extends EstruturaDeDados{
	
	@Override
	public void remover(){
		this.getObjetos().remove(this.getObjetos().size()-1);
	}
	
	/**
	 * @return retorna o ultimo elemento inserido sem removê-lo
	 */
	public Object top(){
		return this.getObjetos().get(this.getObjetos().size()-1);
	}
}
