package threads;

import java.util.ArrayList;

import pojo.Cliente;
import pojo.Senha;

public class EmissorSenha {
	private ArrayList<Senha> senhas = new ArrayList<Senha>();
	

	public ArrayList<Senha> getSenhas() {
		return senhas;
	}

	public void setSenhas(ArrayList<Senha> senhas) {
		this.senhas = senhas;
	}
	
	public Senha getSenha(Cliente cliente){
		Senha s = new Senha(cliente.getPrioridade(), senhas.size()+1);
		senhas.add(s);
		return s;
	}

}
