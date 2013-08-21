package threads;

import java.util.ArrayList;

import app.IBanco;

import pojo.Caixa;
import pojo.Senha;

public class Painel {

	private IBanco banco;
	private Senha senha;
	private Caixa caixa_atual;
	private ArrayList<Caixa> caixas_livres = new ArrayList<Caixa>();

	public Painel(IBanco banco) {
		this.banco = banco;
	}

	public Senha senhaAtual() {
		ArrayList<Senha> senhas = banco.getEmissorSenha().getSenhas();

		if (caixas_livres.size() != 0) {

			Senha senha_mp = new Senha(0, 0);
			senha_mp.invalidar();

			for (int i = 0; i < senhas.size(); i++) { //Percorrendo a lista de senhas existentes.
				if (senhas.get(i).getPrioridade() > senha_mp.getPrioridade() //Compara se a prioridade da senha é maior e se a senha e válida.
						&& senhas.get(i).isValid()) {
					senha_mp = senhas.get(i);
				}
			}
			for (int i = 0; i < senhas.size(); i++) {
				if (senhas.get(i).getPrioridade() == senha_mp.getPrioridade()
						&& senhas.get(i).isValid()
						&& senhas.get(i).getNumero() < senha_mp.getNumero()) { //Compara se o número da senha é menor
					senha_mp = senhas.get(i);
				}
			}

			senha = senha_mp;
		}
		return senha;
	}

	public void caixa_livre(Caixa caixa) {
		caixas_livres.add(caixa);
		if (caixas_livres.size() == 1) {
			atualizar_nome_caixa_painel();
		}
	}

	private void atualizar_nome_caixa_painel() {

		caixa_atual = caixas_livres.get(0);

	}

	public Caixa getCaixaAtual() {

		atualizar_nome_caixa_painel();
		return caixa_atual;

	}

	public void caixa_ocupado(Caixa caixa) {

		caixas_livres.remove(caixa);

	}

}
