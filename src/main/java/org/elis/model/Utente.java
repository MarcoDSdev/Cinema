package org.elis.model;

import java.time.LocalDate;
import java.util.Objects;

public class Utente {
	
	private String username;
	private String email;
	private String password;
	private Ruolo ruolo;
	private LocalDate dataNascita;
	public Utente(String username, String email, String password, Ruolo ruolo, LocalDate dataNascita) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.ruolo = ruolo;
		this.dataNascita=dataNascita;
	}
	
	public Utente(String username, String password, Ruolo ruolo) {
		super();
		this.username = username;
		this.password = password;
		this.ruolo = ruolo;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Ruolo getRuolo() {
		return ruolo;
	}
	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}
	@Override
	public String toString() {
		return "Utente [username=" + username + ", email=" + email + ", password=" + password + ", ruolo=" + ruolo
				+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(email, password, ruolo, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utente other = (Utente) obj;
		return Objects.equals(email, other.email) && Objects.equals(password, other.password) && ruolo == other.ruolo
				&& Objects.equals(username, other.username);
	}
	public LocalDate getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}
	
	}
