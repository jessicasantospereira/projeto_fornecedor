package gestao_for.negocio.impl;

import gestao_for.negocio.IStrategy;

public abstract class AbstractValidador 
	implements IStrategy {
	
	protected StringBuilder sb = new StringBuilder();

	protected boolean isNull(Object obj){
		if(obj == null || obj.toString().trim() == "")
			return true;
		return false;
	}

}
