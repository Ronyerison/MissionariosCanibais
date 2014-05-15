package br.com.easii.util;

import java.util.ArrayList;
import java.util.List;

public abstract class EstruturaDeDados{
	private List<Object> objetos = new ArrayList<Object>();
	
	public void inserir(Object objeto) {
		this.objetos.add(objeto);
	}
	public abstract void remover();
	
	public boolean vazia(){
		if(this.objetos.size() == 0){
			return true;
		}
		return false;
	}
	public List<Object> getObjetos() {
		return objetos;
	}
	public void setObjetos(List<Object> objetos) {
		this.objetos = objetos;
	}		
}

