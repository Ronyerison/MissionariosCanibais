/**
 * 
 */
package br.com.easii.util;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Ronyerison
 *
 */
public class Fila {
	private List<Object> objetos = new LinkedList<Object>();
	
	public void inserir(Object objeto){
		this.objetos.add(objeto);
	}
	
	public Object remover(){
		return this.objetos.remove(0);
	}
	
	public boolean vazia(){
		if(this.objetos.size() == 0){
			return true;
		}
		return false;
	}
}
