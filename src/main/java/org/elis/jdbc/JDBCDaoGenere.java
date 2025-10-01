package org.elis.jdbc;
import java.sql.Connection;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import org.elis.dao.DaoGenere;
import org.elis.model.Genere;
import java.sql.ResultSet;
import java.util.ArrayList;
public class JDBCDaoGenere implements DaoGenere {

	@Override
	public void insert(Genere entity) {
		try(Connection c = JDBCDaoFactory.getConnection()) {
			
			PreparedStatement ps = c.prepareStatement("Insert into Genere (nome_genere) values(?)");
			ps.setString(1, entity.getNome());
			ps.executeUpdate();
		}
	
		catch(SQLException e) {
	
		e.printStackTrace();
		}
	
	}

	@Override
	public void update(Genere entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Genere> selectAll() {
		
		try(Connection c = JDBCDaoFactory.getConnection()) {
		Statement ps = c.createStatement();
		
		
			ResultSet rs = ps.executeQuery("select * from Genere");
			List <Genere> genereList = new ArrayList<>();
			
			while (rs.next()) {
				Long id = rs.getLong("id_genere");
				String nome = rs.getString("nome_genere");
				Genere s = new Genere(id, nome);
				genereList.add(s);
			}
			return genereList;
			}
		
		
		catch(SQLException e)
		{
			e.printStackTrace();
	}
		return null;
	}
	@Override
	public Genere SelectByNome(String nome) {
		try(Connection c = JDBCDaoFactory.getConnection()) {
			PreparedStatement ps = c.prepareStatement("select* from genere where nome_genere = (?)");
			ps.setString(1, nome);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				String nomeGenere = rs.getString("nome_genere");
				long id =rs.getLong("id_genere");
				return new Genere(id, nomeGenere);
			}
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delete(Genere entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Genere selectById(long iD) {
		// TODO Auto-generated method stub
		return null;
	}
	public static JDBCDaoGenere instance;
	public static JDBCDaoGenere getInstance() {
		if(instance == null) instance = new JDBCDaoGenere();
		
		return instance;
	}
	
}
