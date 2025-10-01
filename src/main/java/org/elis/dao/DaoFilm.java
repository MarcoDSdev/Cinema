package org.elis.dao;

import org.elis.model.Film;

public interface DaoFilm extends DaoGeneral<Film> {

	Film selectByTitolo(String titolo);
}
