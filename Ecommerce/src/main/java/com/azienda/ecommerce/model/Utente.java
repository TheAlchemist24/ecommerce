package com.azienda.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Utente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String username;
	@Column(nullable = false)
	private String password;
	
	@ManyToOne
	@JoinColumn(name = "id_profilo")
	private Profilo profilo;
	
	@OneToOne
	@JoinColumn(name = "id_carrello", referencedColumnName="id")
	private Carrello carrello;
	
	public Utente() {}


	public Utente(Integer id, String username, String password, Profilo profilo) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.profilo = profilo;
	}


	public Utente(String username, String password, Profilo profilo) {
		super();
		this.username = username;
		this.password = password;
		this.profilo = profilo;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Profilo getProfilo() {
		return profilo;
	}


	public void setProfilo(Profilo profilo) {
		this.profilo = profilo;
	}


	@Override
	public String toString() {
		return "Utente [id=" + id + ", username=" + username + ", password=" + password + ", profilo=" + profilo + "]";
	}
	
	
}
