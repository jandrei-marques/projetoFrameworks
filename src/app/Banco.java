package app;

import java.util.ArrayList;
import java.util.Date;

import pojo.Caixa;
import pojo.Cliente;
import threads.EmissorSenha;
import threads.GeraClientes;
import threads.Painel;

public class Banco implements IBanco {

	private EmissorSenha es;
	private Painel painel = new Painel(this);
	private ArrayList<Caixa> caixas = new ArrayList<Caixa>();
	private static final int NUMERO_DE_CAIXAS = 5;
	private static int STATUS_DO_BANCO = 1;
	public static final int DESLIGADO = 0;

	public static void main(String[] args) throws InterruptedException {

		Banco banco = new Banco();
		banco.gerarCaixas(NUMERO_DE_CAIXAS);

		Thread.sleep(2000);

		banco.gerarClientes();

	}

	// Metodo para gerarClientes.
	public void gerarClientes() {
		GeraClientes gc = new GeraClientes(this);
	}

	@Override
	public EmissorSenha getEmissorSenha() {
		if (es == null) {
			es = new EmissorSenha();
		}
		return es;
	}

	@Override
	public Painel getPainel() {
		if (painel == null) {
			painel = new Painel(this);
		}
		return painel;
	}

	@Override
	public Caixa getCaixa() {
		return null;
	}

	// Metodo que geram os caixas do banco.
	public void gerarCaixas(int nCaixas) {
		for (int i = 0; i < nCaixas; i++) {
			caixas.add(new Caixa(this, String.valueOf(i)));
		}

		System.out.println("-- Caixas gerados --");
	}

	public static int getStatusDoBanco() {
		return STATUS_DO_BANCO;
	}

}
