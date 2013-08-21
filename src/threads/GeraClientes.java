package threads;

import java.util.Random;

import app.Banco;
import pojo.Cliente;

public class GeraClientes extends Thread {
	private Banco banco;
	private Random random2 = new Random();
	private Random random = new Random();
	private int x;
	private int x2;

	/*
	 * Para simular o ambiente, os clientes são criados aleatoriamente com
	 * número de operações também aleatórias. Cada operação deve impactar em um
	 * segundo de atendimento para a simulação; *
	 */

	public GeraClientes(Banco banco2) {
		this.banco = banco2;
		this.start();
	}

	/*
	 * Thread para gerar clientes com prioridade e número de operações
	 * aleatórias.
	 */

	@Override
	public void run() {

		for (int i = 1; i <= 20; i++) {
			x = 0;
			x2 = 0;
			x = random.nextInt(2);
			x2 = random2.nextInt(10);
			Cliente c = new Cliente(banco, i, x + 1, x2 + 1);
			try {
				Thread.currentThread().sleep(500);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		}

		Cliente a = new Cliente(banco, 69, 1, 1);
		Cliente b = new Cliente(banco, 74, 5, 1);

		System.out.println("Clientes gerados");
		super.run();
	}
}
