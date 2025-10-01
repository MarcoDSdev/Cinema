package org.elis.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.elis.dao.DaoSala;
import org.elis.model.Sala;

public class JDBCDaoSala implements DaoSala {

	@Override
	public void insert(Sala entity) {
try(Connection c = JDBCDaoFactory.getConnection()) {
			
			PreparedStatement ps = c.prepareStatement("Insert into Sala (nome_sala, numero_posti) values(?,?)");
			ps.setString(1, entity.getNome());
			ps.setShort(2, Short.valueOf(entity.getNumeroPosti().toString()));
			ps.executeUpdate();
		}
	
		catch(SQLException e) {
	
		e.printStackTrace();
		}
		
	}

	@Override
	public void update(Sala entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Sala entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Sala selectById(long iD) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sala> selectAll() {
		try(Connection c = JDBCDaoFactory.getConnection())
		{
			Statement ps = c.createStatement();
			ResultSet rs = ps.executeQuery("select * from Sala");
			List<Sala> salaList = new ArrayList<>();
			
			while(rs.next())
			{
				long id = rs.getLong("id_sala");
				String nome = rs.getString("nome_sala");
				Integer numeroPosti = rs.getInt("numero_posti");
				Sala f = new Sala(id, nome, numeroPosti);
				
				salaList.add(f);
				
			}
		return salaList;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Sala selectByNumeroPosti(Integer numeroPosti) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sala selectSalaByNome(String nome) {
		try (Connection c = JDBCDaoFactory.getConnection()) {
			PreparedStatement ps = c.prepareStatement("select * from Sala where nome_sala = ? ");
			ps.setString(1, nome);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next() ) {
				
				long id = rs.getLong("id_sala");
				String nomeSala = rs.getString("nome_sala");
				Integer numeroPosti = rs.getInt("numero_posti");
				return new Sala(id,nomeSala,numeroPosti);
				
			}
		}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public static JDBCDaoSala instance;
	public static JDBCDaoSala getInstance() {
		if(instance == null) instance = new JDBCDaoSala();
		
		return instance;
	}
}
