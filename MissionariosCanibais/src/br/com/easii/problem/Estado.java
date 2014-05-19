/**
 * 
 */
package br.com.easii.problem;

import java.util.LinkedList;
import java.util.List;

import br.com.easii.enums.PosicaoDoBarco;

/**
 * @author Ronyerison
 * 
 */
public class Estado implements Comparable<Estado>{

	private Integer missionarios;
	private Integer canibais;
	private PosicaoDoBarco posicaoDoBarco;
	private Estado estadoPai;
	private Integer custo;

	/**
	 * @param missionarios
	 * @param canibais
	 * @param posicaoDoBarco
	 * @param estadoPai
	 * @param custo
	 */
	public Estado(Integer missionarios, Integer canibais,
			PosicaoDoBarco posicaoDoBarco, Estado estadoPai, Integer custo) {
		super();
		this.missionarios = missionarios;
		this.canibais = canibais;
		this.posicaoDoBarco = posicaoDoBarco;
		this.estadoPai = estadoPai;
		this.custo = custo;
	}

	/**
	 * @return the missionarios
	 */
	public int getMissionarios() {
		return missionarios;
	}

	/**
	 * @param missionarios
	 *            the missionarios to set
	 */
	public void setMissionarios(int missionarios) {
		this.missionarios = missionarios;
	}

	/**
	 * @return the canibais
	 */
	public int getCanibais() {
		return canibais;
	}

	/**
	 * @param canibais
	 *            the canibais to set
	 */
	public void setCanibais(int canibais) {
		this.canibais = canibais;
	}

	/**
	 * @return the posicaoDoBarco
	 */
	public PosicaoDoBarco getPosicaoDoBarco() {
		return posicaoDoBarco;
	}

	/**
	 * @param posicaoDoBarco
	 *            the posicaoDoBarco to set
	 */
	public void setPosicaoDoBarco(PosicaoDoBarco posicaoDoBarco) {
		this.posicaoDoBarco = posicaoDoBarco;
	}

	/**
	 * @return the estadoPai
	 */
	public Estado getEstadoPai() {
		return estadoPai;
	}

	/**
	 * @param estadoPai
	 *            the estadoPai to set
	 */
	public void setEstadoPai(Estado estadoPai) {
		this.estadoPai = estadoPai;
	}

	/**
	 * @return the custo
	 */
	public int getCusto() {
		return custo;
	}

	/**
	 * @param custo
	 *            the custo to set
	 */
	public void setCusto(int custo) {
		this.custo = custo;
	}

	/**
	 * @return True se o objetivo foi atingido e False se não
	 */
	public boolean isCompleted() {
		if (this.missionarios == 0 && this.canibais == 0
				&& this.posicaoDoBarco == PosicaoDoBarco.DIREITA) {
			return true;
		}
		return false;
	}

	/**
	 * @return True se a quantidade de missionarios em cada margem é maior ou
	 *         igual a quantidade de canibais
	 */
	public boolean isValid() {
		if (this.canibais > this.missionarios && this.missionarios != 0) {
			return false;
		} else if ((3 - this.canibais) > (3 - this.missionarios)
				&& (3 - this.missionarios) != 0) {
			return false;
		} else if (this.missionarios < 0 || this.canibais < 0) {
			return false;
		} else if(this.missionarios > 3 || this.canibais > 3){
			return false;
		}else{
			return true;
		}

	}

	/**
	 * @return Lista dos possiveis estados a serem expandidos para o estado
	 *         atual
	 */
	public List<Estado> expandir() {
		Estado novoEstado;
		List<Estado> fronteira = new LinkedList<>();
		novoEstado = Movimentacao.moverUmMissionario(this);
		if (novoEstado.isValid()) {
			fronteira.add(novoEstado);
		}
		novoEstado = Movimentacao.moverDoisMissionarios(this);
		if (novoEstado.isValid()) {
			fronteira.add(novoEstado);
		}
		novoEstado = Movimentacao.moverUmCanibal(this);
		if (novoEstado.isValid()) {
			fronteira.add(novoEstado);
		}
		novoEstado = Movimentacao.moverDoisCanibais(this);
		if (novoEstado.isValid()) {
			fronteira.add(novoEstado);
		}
		novoEstado = Movimentacao.moverUmDeCada(this);
		if (novoEstado.isValid()) {
			fronteira.add(novoEstado);
		}

		return fronteira;
	}

	public Estado getClone(Estado estado) {
		return new Estado(estado.getMissionarios(), estado.getCanibais(),
				estado.getPosicaoDoBarco(), estado.getEstadoPai(), null);
	}

	public boolean isEqual(Estado est) {
		Estado atual = this.getClone(this);
		if (atual.getCanibais() == est.getCanibais()
				&& atual.getMissionarios() == est.getMissionarios()
				&& atual.getPosicaoDoBarco().equals(est.getPosicaoDoBarco())) {
			return true;
		}

		return false;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String string = "";
		
		string = "Estado\n MIS = " + missionarios + " CAN = "+ canibais;
		string += (posicaoDoBarco == PosicaoDoBarco.ESQUERDA)?" ESQUERDA\t\t\t": "\t\t\tDIREITA ";
		string += " MIS = "+(3-missionarios) + " CAN = " +(3-canibais) +"\n" ;
		
		return string;
	}

	@Override
	public int compareTo(Estado o) {
		if(this.getMissionarios() < o.getMissionarios()){
			return -1;
		}else if(this.getMissionarios() > o.getMissionarios()){
			return 1;
		}else{
			return 0;
		}
	}
	
	public int compareAEstrela(Estado o) {
		if(this.getMissionarios()+this.getCusto() < o.getMissionarios()+o.getCusto()){
			return -1;
		}else if(this.getMissionarios()+this.getCusto() > o.getMissionarios()+o.getCusto()){
			return 1;
		}else{
			return 0;
		}
	}
	
}
