package org.elis.dao;

import org.elis.model.Utente;

public interface DaoUtente extends DaoGeneral<Utente>{

	Utente selectByUsername(String username);
	Utente loginUtente (String username, String password);
}
