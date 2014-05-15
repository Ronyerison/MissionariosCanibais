package br.com.easii.util;

import java.util.ArrayList;
import java.util.List;

import br.com.easii.problem.Estado;

public abstract class EstruturaDeDados{
	private List<Estado> objetos = new ArrayList<Estado>();
	
	public void inserir(Estado objeto) {
		this.objetos.add(objeto);
	}
	public abstract void remover();
	
	public boolean vazia(){
		if(this.objetos.size() == 0){
			return true;
		}
		return false;
	}
	public List<Estado> getObjetos() {
		return objetos;
	}
	public void setObjetos(List<Estado> objetos) {
		this.objetos = objetos;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EstruturaDeDados [objetos=" + objetos + "]";
	}
	
}

