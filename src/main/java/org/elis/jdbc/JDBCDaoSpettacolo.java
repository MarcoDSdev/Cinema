package org.elis.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.elis.dao.DaoSpettacolo;
import org.elis.model.Film;
import org.elis.model.Sala;
import org.elis.model.Spettacolo;

public class JDBCDaoSpettacolo implements DaoSpettacolo {

	@Override
	public void insert(Spettacolo entity) {
		try (Connection c = JDBCDaoFactory.getConnection()) {
			PreparedStatement ps = c
					.prepareStatement("insert into spettacolo (id_film, data_ora, id_sala) values(?,?,?)");
			ps.setLong(1, entity.getFilm().getId());
			ps.setTimestamp(2, Timestamp.valueOf(entity.getData()));
			ps.setLong(3, entity.getSala().getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Spettacolo entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Spettacolo entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public Spettacolo selectById(long iD) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Spettacolo> selectAll() {
		try (Connection c = JDBCDaoFactory.getConnection()) {
			Statement ps = c.createStatement();
			ResultSet rs = ps.executeQuery("select * from spettacolo");
			List<Spettacolo> spettacoloList = new ArrayList<>();
			while (rs.next()) {
				long id = rs.getLong("id_spettacolo");
				Long idSala = rs.getLong("id_sala");
				Long idFilm = rs.getLong("id_film");
				LocalDateTime data = rs.getTimestamp("data_ora").toLocalDateTime();
				Sala sala = null;

				PreparedStatement statementSala = c.prepareStatement("select * from sala where id_sala = ?");
				statementSala.setLong(1, idSala);
				ResultSet risultatoSala = statementSala.executeQuery();

				PreparedStatement statementFilm = c.prepareStatement("select * from film where id_film = ?");
				statementFilm.setLong(1, idFilm);
				ResultSet risultatoFilm = statementFilm.executeQuery();

				if (risultatoSala.next() && risultatoFilm.next()) {
					sala = new Sala(idSala, risultatoSala.getString("nome_sala"), null);
					Film film = null;
					film = new Film(idFilm, risultatoFilm.getString("titolo"), null, null);
					Spettacolo f = new Spettacolo(id, film, sala, data);
					spettacoloList.add(f);
				}
				
			}
			return spettacoloList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Spettacolo selectByFilm(String film) {
		// TODO Auto-generated method stub
		return null;
	}

	public static JDBCDaoSpettacolo instance;

	public static JDBCDaoSpettacolo getInstance() {
		if (instance == null)
			instance = new JDBCDaoSpettacolo();

		return instance;
	}
}
