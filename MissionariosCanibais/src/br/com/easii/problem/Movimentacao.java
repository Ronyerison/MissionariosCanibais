/**
 * 
 */
package br.com.easii.problem;

import br.com.easii.enums.PosicaoDoBarco;

/**
 * @author Ronyerison
 *
 */
public class Movimentacao {
	
	/**
	 * @param estado
	 * @return Este método retorna um novo estado atualizando a quantidade de canibais em 1 na margem,
	 * altera a posição do barco
	 */
	public static Estado moverUmCanibal(Estado estado){
		if(estado.getPosicaoDoBarco().equals(PosicaoDoBarco.ESQUERDA)){
			return new Estado(estado.getMissionarios(), estado.getCanibais()-1, PosicaoDoBarco.DIREITA, estado, estado.getCusto()+1);
		}else{
			return new Estado(estado.getMissionarios(), estado.getCanibais()+1, PosicaoDoBarco.ESQUERDA, estado, estado.getCusto()+1);
		}
		
	}
	
	/**
	 * @param estado
	 * @return Este método retorna um novo estado atualizando a quantidade de canibais em 2 na margem,
	 * altera a posição do barco
	 */
	public static Estado moverDoisCanibais(Estado estado){
		if(estado.getPosicaoDoBarco().equals(PosicaoDoBarco.ESQUERDA)){
			return new Estado(estado.getMissionarios(), estado.getCanibais()-2, PosicaoDoBarco.DIREITA, estado, estado.getCusto()+1);
		}else{
			return new Estado(estado.getMissionarios(), estado.getCanibais()+2, PosicaoDoBarco.ESQUERDA, estado, estado.getCusto()+1);
		}
	}
	
	/**
	 * @param estado
	 * @return Este método retorna um novo estado atualizando a quantidade de missionarios em 1 na margem,
	 * altera a posição do barco
	 */
	public static Estado moverUmMissionario(Estado estado){
		if(estado.getPosicaoDoBarco().equals(PosicaoDoBarco.ESQUERDA)){
			return new Estado(estado.getMissionarios()-1, estado.getCanibais(), PosicaoDoBarco.DIREITA, estado, estado.getCusto()+1);
		}else{
			return new Estado(estado.getMissionarios()+1, estado.getCanibais(), PosicaoDoBarco.ESQUERDA, estado,  estado.getCusto()+1);
		}
	}
	
	/**
	 * @param estado
	 * @return Este método retorna um novo estado atualizando a quantidade de missionarios em 2 na margem,
	 * altera a posição do barco
	 */
	public static Estado moverDoisMissionarios(Estado estado){
		if(estado.getPosicaoDoBarco().equals(PosicaoDoBarco.ESQUERDA)){
			return new Estado(estado.getMissionarios()-2, estado.getCanibais(), PosicaoDoBarco.DIREITA, estado,  estado.getCusto()+1);
		}else{
			return new Estado(estado.getMissionarios()+2, estado.getCanibais(), PosicaoDoBarco.ESQUERDA, estado,  estado.getCusto()+1);
		}
	}
	
	/**
	 * @param estado
	 * @return Este método retorna um novo estado atualizando a quantidade de missionarios e canibais em 1 na margem,
	 * altera a posição do barco
	 */
	public static Estado moverUmDeCada(Estado estado){
		if(estado.getPosicaoDoBarco().equals(PosicaoDoBarco.ESQUERDA)){
			return new Estado(estado.getMissionarios()-1, estado.getCanibais()-1, PosicaoDoBarco.DIREITA, estado,  estado.getCusto()+1);
		}else{
			return new Estado(estado.getMissionarios()+1, estado.getCanibais()+1, PosicaoDoBarco.ESQUERDA, estado,  estado.getCusto()+1);
		}
	}
}
