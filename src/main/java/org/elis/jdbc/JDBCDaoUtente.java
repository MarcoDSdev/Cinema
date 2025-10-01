package org.elis.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.elis.dao.DaoUtente;
import org.elis.model.Ruolo;
import org.elis.model.Utente;


public class JDBCDaoUtente implements DaoUtente{

	@Override
	public void insert(Utente entity) {
		try (Connection c = JDBCDaoFactory.getConnection()) {
			PreparedStatement ps = c.prepareStatement ("Insert into Utente (username, password, email, data_nascita, ruolo) values (?,?,?,?,?)");
			ps.setString(1, entity.getUsername());
			ps.setString(2, entity.getPassword());
			ps.setString(3, entity.getEmail());
			ps.setDate(4, Date.valueOf(entity.getDataNascita()));
			ps.setInt(5, entity.getRuolo().ordinal());
			ps.executeUpdate();
		}
		catch(SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void update(Utente entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Utente entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Utente selectById(long iD) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utente> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utente selectByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	public static JDBCDaoUtente instance;
	public static JDBCDaoUtente getInstance() {
		if (instance == null)
			instance = new JDBCDaoUtente();

		return instance;
	}

	@Override
	public Utente loginUtente(String username, String password) {
		try (Connection c = JDBCDaoFactory.getConnection()) {
	        PreparedStatement ps = c.prepareStatement("SELECT * FROM Utente WHERE email = ? AND password = ?");
	        ps.setString(1, username);
	        ps.setString(2, password);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            int indiceRuolo = rs.getInt("ruolo"); 
	            Ruolo ruolo = Ruolo.values()[indiceRuolo];
	            return new Utente(username, password, ruolo);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
}
