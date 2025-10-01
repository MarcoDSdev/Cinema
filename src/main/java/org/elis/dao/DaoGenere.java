package org.elis.dao;

import org.elis.model.Genere;

public interface DaoGenere extends DaoGeneral<Genere> {

		Genere SelectByNome(String nome);
}
