package org.elis.model;

import java.util.Objects;

public class Film {
	
	private Long id;
	private String titolo;
	private Integer durata;
	private Genere genere;
	public Film(Long id, String titolo, Integer durata, Genere genere) {
		super();
		this.id = id;
		this.titolo = titolo;
		this.durata = durata;
		this.genere = genere;
	}
	
	
	
	
	public Film(String titolo, Integer durata, Genere genere) {
		super();
		this.titolo = titolo;
		this.durata = durata;
		this.genere = genere;
	}




	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public Integer getDurata() {
		return durata;
	}
	public void setDurata(Integer durata) {
		this.durata = durata;
	}
	public Genere getGenere() {
		return genere;
	}
	public void setGenere(Genere genere) {
		this.genere = genere;
	}
	@Override
	public int hashCode() {
		return Objects.hash(durata, genere, id, titolo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(durata, other.durata) && Objects.equals(genere, other.genere)
				&& Objects.equals(id, other.id) && Objects.equals(titolo, other.titolo);
	}

	
}
