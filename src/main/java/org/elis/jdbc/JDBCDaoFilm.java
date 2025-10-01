package org.elis.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.elis.dao.DaoFilm;
import org.elis.model.Film;
import org.elis.model.Genere;

public class JDBCDaoFilm implements DaoFilm {

	@Override
	public void insert(Film entity) {
		try (Connection c = JDBCDaoFactory.getConnection()) {

			PreparedStatement ps = c.prepareStatement("Insert into Film (titolo, durata, id_genere) values(?,?,?)");
			ps.setString(1, entity.getTitolo());
			ps.setShort(2, Short.valueOf(entity.getDurata().toString()));
			ps.setLong(3, entity.getGenere().getId());
			ps.executeUpdate();
		}

		catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void update(Film entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Film> selectAll() {
		try (Connection c = JDBCDaoFactory.getConnection()) {
			Statement ps = c.createStatement();
			ResultSet rs = ps.executeQuery("select * from film");
			List<Film> filmList = new ArrayList<>();

			while (rs.next()) {
				long id = rs.getLong("id_film");
				String titolo = rs.getString("titolo");
				long idGenere = rs.getLong("id_genere");
				Integer durata = rs.getInt("durata");
				Genere genere = null;

				PreparedStatement statementGenere = c.prepareStatement("select *from genere where id_genere=?");
				statementGenere.setLong(1, idGenere);
				ResultSet risultatoGenere = statementGenere.executeQuery();

				if (risultatoGenere.next()) {

					genere = new Genere(idGenere, risultatoGenere.getString("nome_genere"));
					Film f = new Film(id, titolo, durata, genere);
					filmList.add(f);
				}
			}
			return filmList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Film selectByTitolo(String titolo) {
		try (Connection c = JDBCDaoFactory.getConnection()) {
			PreparedStatement ps = c.prepareStatement(
					"select id_film, titolo, durata, film.id_genere, nome_genere from film JOIN Genere on film.id_genere = genere.id_genere where titolo = ?");
			ps.setString(1, titolo);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				long id = rs.getLong("id_film");
				String titoloFilm = rs.getString("titolo");
				String nomeGenere = rs.getString("nome_genere");
				int durata = rs.getInt("durata");
				long idGenere = rs.getLong("id_genere");
				Genere genere = new Genere(idGenere, nomeGenere);
				return new Film(id, titoloFilm, durata, genere);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void delete(Film entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public Film selectById(long iD) {
		// TODO Auto-generated method stub
		return null;
	}

	public static JDBCDaoFilm instance;

	public static JDBCDaoFilm getInstance() {
		if (instance == null)
			instance = new JDBCDaoFilm();

		return instance;
	}
}
