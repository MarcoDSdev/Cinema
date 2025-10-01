package org.elis.dao;


import org.elis.model.Spettacolo;

public interface DaoSpettacolo extends DaoGeneral <Spettacolo> {
	
	Spettacolo selectByFilm(String film);
}
