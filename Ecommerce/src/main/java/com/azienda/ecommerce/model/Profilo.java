package com.azienda.ecommerce.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Profilo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String nome;
	
	@OneToMany(mappedBy = "profilo")
	private List<Utente> utenti = new ArrayList<>();
	
	public Profilo() {}

	public Profilo(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Profilo(String nome) {
		this.nome = nome;
	}
		
	public List<Utente> getUtenti() {
		return utenti;
	}

	public void setUtenti(List<Utente> utenti) {
		this.utenti = utenti;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Profilo [id=" + id + ", nome=" + nome + "]";
	}
	
	
	
}