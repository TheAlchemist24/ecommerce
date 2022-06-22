package com.azienda.ecommerce.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.azienda.ecommerce.model.Profilo;

public class ProfiloDaoImpl  implements DaoInterface<Profilo> {
	

	private EntityManager eManager;

	public ProfiloDaoImpl(EntityManager eManager) {
		this.eManager = eManager;
	}

	@Override
	public Profilo create(Profilo obj) {
		eManager.persist(obj);
		return obj;
	}
	
	@Override 
	public List<Profilo> retrive(){
		return eManager.createQuery("SELECT p FROM Profilo p", Profilo.class).getResultList();
	}

	@Override 
	public Profilo update(Profilo obj) {
		eManager.persist(obj);
		return obj;
	}

	@Override
	public void delete(Profilo obj) {
		eManager.remove(obj);
	}
	
	public Profilo findByNome(String nome) {
		return eManager.createQuery("select p form Profilo p where p.nome =:parnome", Profilo.class)
				.setParameter("parnome",nome).getSingleResult();
	}
	
	
}