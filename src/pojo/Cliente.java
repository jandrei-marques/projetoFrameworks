package pojo;

import java.util.Random;

import app.Banco;

public class Cliente extends Thread {
	
	private int ID;
	private int prioridade;
	private int nOperacoes;
	private Banco banco;
	private Senha senha;
	
//	private Random random = new Random();
//	private int i;
	
	public Cliente(Banco banco, int id, int prioridade, int nOperacoes) {
		this.ID = id;
		this.prioridade = prioridade;
		this.nOperacoes = nOperacoes;
		this.banco = banco;
		this.start();
		
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}
	public int getnOperacoes() {
		return nOperacoes;
	}
	public void setnOperacoes(int nOperacoes) {
		this.nOperacoes = nOperacoes;
	}
	
	@Override
	public void run() {
		//Aguarda um tempo aleatório para pegar uma nova senha.
	   // i=0;
//	    i=random.nextInt(1000);
//	    try {
//			Thread.currentThread().sleep(i);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	    senha = banco.getEmissorSenha().getSenha(this);
		this.getSenha().getNumero();
		
		/*Verificando se a senha do cliente é igual a senha atual do painel, se não for aguarda 5 segundos 
		* e verifica novamente.
		*/
		
		while(this.getSenha().getNumero() != banco.getPainel().senhaAtual().getNumero()){
			
			
//			System.out.println("------------------------------------------------");
//			System.out.println(" id -- "+this.getID());
//			System.out.println(" senha " + this.getSenha().getNumero());
//			System.out.println(" senha do painel " +banco.getPainel().senhaAtual().getNumero());
//			System.out.println(" prioridade " + this.getPrioridade());
			
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
			

			Caixa caixa_encaminhado = banco.getPainel().getCaixaAtual();
			
			System.out.println("Cliente:" +this.getID() +" Encaminhado para o Caixa: "+caixa_encaminhado.getDescricao());
			
			
			caixa_encaminhado.solicitar_atendimento(this);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		super.run();
	}

	public Senha getSenha() {
		return senha;
	}

	public void setSenha(Senha senha) {
		this.senha = senha;
	}


}
