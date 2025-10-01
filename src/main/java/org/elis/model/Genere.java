package org.elis.model;

import java.util.Objects;

public class Genere {
	
	private Long id;
	private String nome;

	public Genere(Long id, String nome) {
		super();
		this.nome = nome;
		this.id=id;
	}

	public Genere(String nome) {
		super();
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Genere [nome=" + nome + "]";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Genere other = (Genere) obj;
		return Objects.equals(nome, other.nome);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
