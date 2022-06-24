package gestao_for.controle.web;

import gestao_for.controle.IFachada;
import gestao_for.controle.impl.Fachada;

public abstract class AbstractCommand implements ICommand {

	protected IFachada fachada = new Fachada();
}
