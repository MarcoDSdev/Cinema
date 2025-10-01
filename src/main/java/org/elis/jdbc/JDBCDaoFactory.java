package org.elis.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.elis.dao.DaoFactory;
import org.elis.dao.DaoFilm;
import org.elis.dao.DaoGenere;
import org.elis.dao.DaoSala;
import org.elis.dao.DaoSpettacolo;
import org.elis.dao.DaoUtente;

public class JDBCDaoFactory extends DaoFactory {

	protected static Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema", "root", "root");
	}
	
	@Override
	public DaoFilm getDaoFilm() {
		// TODO Auto-generated method stub
		return JDBCDaoFilm.getInstance();
	}

	@Override
	public DaoGenere getDaoGenere() {
		// TODO Auto-generated method stub
		return JDBCDaoGenere.getInstance();
	}

	@Override
	public DaoSala getDaoSala() {
		// TODO Auto-generated method stub
		return JDBCDaoSala.getInstance();
	}

	@Override
	public DaoSpettacolo getDaoSpettacolo() {
		// TODO Auto-generated method stub
		return JDBCDaoSpettacolo.getInstance();
	}

	@Override
	public DaoUtente getDaoUtente() {
		// TODO Auto-generated method stub
		return JDBCDaoUtente.getInstance();
	}

}
