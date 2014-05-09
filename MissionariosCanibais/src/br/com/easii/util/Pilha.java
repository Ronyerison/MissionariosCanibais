/**
 * 
 */
package br.com.easii.util;
import java.util.*;
/**
 * @author Ronyerison
 *
 */

public class Pilha {
	List<Object> objetos = new LinkedList<Object>();
	
	public void empilhar(Object object){
		this.objetos.add(object);
	}
	
	public Object desempilhar(){
		return this.objetos.remove(this.objetos.size()-1);
	}
	
	public boolean vazia(){
		if(this.objetos.size() == 0){
			return true;
		}
		return false;
	}
	
//	top -> retorna o ultimo elemento inserido sem removê-lo
	public Object top(){
		return this.objetos.get(this.objetos.size()-1);
	}
}
