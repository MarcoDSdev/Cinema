package org.elis.model;

import java.io.Serializable;
import java.util.Objects;

public class Sala implements Serializable {
	
	private Long id;
	private String nome;
	private Integer numeroPosti;
	public Sala(Long id, String nome, Integer numeroPosti) {
		super();
		this.id=id;
		this.nome = nome;
		this.numeroPosti = numeroPosti;
	}
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getNumeroPosti() {
		return numeroPosti;
	}
	public String getNome() {
		return nome;
	}


	public void setNumeroPosti(Integer numeroPosti) {
		this.numeroPosti = numeroPosti;
	}
	@Override
	public String toString() {
		return "Sala [nome=" + nome + ", numeroPosti=" + numeroPosti + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(nome, numeroPosti);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sala other = (Sala) obj;
		return Objects.equals(nome, other.nome) && Objects.equals(numeroPosti, other.numeroPosti);
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	
}
