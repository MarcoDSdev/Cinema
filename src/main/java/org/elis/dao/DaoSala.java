package org.elis.dao;

import org.elis.model.Sala;

public interface DaoSala extends DaoGeneral<Sala> {

	Sala selectByNumeroPosti(Integer numeroPosti);
	Sala selectSalaByNome (String nome);
	
	
}
