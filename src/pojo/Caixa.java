package pojo;

import threads.Painel;
import app.Banco;

public class Caixa extends Thread {

	/*
	 * O Simular aumento/diminuição do número de atendentes (caixas) em função
	 * de horário de almoço, por exemplo;
	 */

	/*
	 * Gerar relatórios, que devem ser salvos em XML, contendo ao menos
	 * informações como o número de atendimentos diário por caixa, número médio
	 * de operações por atendimento, quantidade de clientes prioritários e tempo
	 * médio de atendimento considerando faixas de horário (de uma em uma hora).
	 */

	private Banco banco;
	private String descricao;
	private Cliente cliente_atual = null;
	private static int  count =0;

	public Caixa(Banco banco, String descricao) {
		this.banco = banco;
		this.descricao = descricao;
		this.start();
	}

	@Override
	public void run() {

		banco.getPainel().caixa_livre(this);

		while (banco.getStatusDoBanco() != banco.DESLIGADO) {

			while (cliente_atual == null) {
				try {
					Thread.sleep(500);

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (cliente_atual != null)
					break;

			}

			// System.out.println("cliente n eh mais nulo");

			banco.getPainel().caixa_ocupado(this);

			cliente_atual.getSenha().invalidar();

			int nOp = cliente_atual.getnOperacoes();

			try {
				Thread.sleep(nOp * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("---- CAIXA " + this.descricao
					+ "--Atendeu Cliente " + cliente_atual.getID() + "--- P "
					+ cliente_atual.getPrioridade());
			count=count+1;
			System.out.println("Clientes atendidos:"+ count);

			cliente_atual = null;

			banco.getPainel().caixa_livre(this);
		}

		super.run();
	}

	public void solicitar_atendimento(Cliente cliente) {

		if (cliente_atual == null) {
			cliente_atual = cliente;

		}

	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
