package org.elis.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Spettacolo {

	private Long id;
	private Film film;
	private Sala sala;
	private LocalDateTime data;
	
	
	
	
	public Long getId() {
		return id;
	}
	public Spettacolo(Long id, Film film, Sala sala, LocalDateTime data) {
		super();
		this.id = id;
		this.film = film;
		this.sala = sala;
		this.data = data;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(data, film, id, sala);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Spettacolo other = (Spettacolo) obj;
		return Objects.equals(data, other.data) && Objects.equals(film, other.film) && Objects.equals(id, other.id)
				&& Objects.equals(sala, other.sala);
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}


}


