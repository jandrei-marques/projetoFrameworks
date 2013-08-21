package app;

import pojo.Caixa;
import threads.EmissorSenha;
import threads.Painel;

public interface IBanco {
	EmissorSenha getEmissorSenha();
	Painel getPainel();
	Caixa getCaixa();
	
	
}
