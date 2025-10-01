package org.elis.utility;

import java.util.List;

import org.elis.dao.DaoFactory;
import org.elis.model.Film;
import org.elis.model.Genere;
import org.elis.model.Sala;
import org.elis.model.Spettacolo;
import org.elis.model.Utente;

public class BusinessLogic {
//rappresentano le funzionalia'dell'ápp	
	public static void creaSala(Sala s1) {

		DaoFactory.getDaoFactory().getDaoSala().insert(s1);
	}

	public static List<Sala> selectAllSale() {

		return DaoFactory.getDaoFactory().getDaoSala().selectAll();
	}

	public static void creaGenere(Genere s1) {
		DaoFactory.getDaoFactory().getDaoGenere().insert(s1);
	}

	public static List<Genere> selectAllGenere() {
		return DaoFactory.getDaoFactory().getDaoGenere().selectAll();

	}

	public static void creaFilm(Film s1) {
		DaoFactory.getDaoFactory().getDaoFilm().insert(s1);
	}

	public static List<Film> selectAllFilm() {
		return DaoFactory.getDaoFactory().getDaoFilm().selectAll();
	}

	public static void creaSpettacolo(Spettacolo s1) {
		DaoFactory.getDaoFactory().getDaoSpettacolo().insert(s1);
	}

	public static List<Spettacolo> selectAllSpettacolo() {
		return DaoFactory.getDaoFactory().getDaoSpettacolo().selectAll();
	}

	public static Film selectFilmByTitolo(String titoloFilm) {
		return DaoFactory.getDaoFactory().getDaoFilm().selectByTitolo(titoloFilm);
	}

	public static Sala selectSalaByNome(String nomeSala) {
		return DaoFactory.getDaoFactory().getDaoSala().selectSalaByNome(nomeSala);
	}

	public static Genere selectByNome(String nomeGenere) {
		return DaoFactory.getDaoFactory().getDaoGenere().SelectByNome(nomeGenere);
	}
	public static Utente selectByUsername(String username) {
		return DaoFactory.getDaoFactory().getDaoUtente().selectByUsername(username);
	}
	public static void creaUtente (Utente s1) {
		DaoFactory.getDaoFactory().getDaoUtente().insert(s1);
	}
	
	public static Utente loginUtente(String email , String Password ) {
		return DaoFactory.getDaoFactory().getDaoUtente().loginUtente(email, Password);
	}
}
