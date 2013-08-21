package pojo;

public class Senha {
	
	private int numero;
	private int prioridade;
	private boolean valida = true;
	
	
	public Senha(int d, int numero) {
		this.prioridade = d;
		this.numero = numero;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	public void invalidar(){
		valida = false;
	}
	
	public boolean isValid(){
		return valida;
	}
	
	
	
}
