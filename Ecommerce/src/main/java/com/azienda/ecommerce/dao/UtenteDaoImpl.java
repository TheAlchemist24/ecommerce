package com.azienda.ecommerce.dao;

import java.util.List;
import javax.persistence.EntityManager;
import com.azienda.ecommerce.model.Utente;

public class UtenteDaoImpl  implements DaoInterface<Utente>  {
	
	private EntityManager eManager;

	public UtenteDaoImpl(EntityManager eManager) {
		this.eManager = eManager;
	}

	@Override
	public Utente create(Utente obj) {
		eManager.persist(obj);
		return obj;
	}
	
	@Override 
	public List<Utente> retrive(){
		return eManager.createQuery("SELECT u FROM Profilo u", Utente.class).getResultList();
	}

	@Override 
	public Utente update(Utente obj) {
		eManager.persist(obj);
		return obj;
	}

	@Override
	public void delete(Utente obj) {
		eManager.remove(obj);
	}
	
	public Utente findByUsername(String username) {
		return eManager.createQuery("select u form Utente u where u.username =:parusername", Utente.class)
				.setParameter("parusername",username).getSingleResult();
	}
	
	public Utente findByUsernameAndPassword(String username, String password) {
		return eManager.createQuery("select u form Utente u where u.username =:parusername AND u.password=:parpassword", Utente.class)
				.setParameter("parusername",username)
			.setParameter("parpassword",password).getSingleResult();
	}
}