package org.elis.dao;



import org.elis.jdbc.JDBCDaoFactory;


public abstract class DaoFactory {

	public abstract DaoFilm getDaoFilm();
	public abstract DaoGenere getDaoGenere();
	public abstract DaoSala getDaoSala();
	public abstract DaoSpettacolo getDaoSpettacolo();
	public abstract DaoUtente getDaoUtente();
	
	public static DaoFactory getDaoFactory() {
		return new JDBCDaoFactory();
	}
}
