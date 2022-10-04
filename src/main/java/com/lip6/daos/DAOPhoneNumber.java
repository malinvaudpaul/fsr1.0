package com.lip6.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.lip6.entities.Contact;
import com.lip6.entities.PhoneNumber;
import com.lip6.util.JpaUtil;

public class DAOPhoneNumber {

	public boolean addPhoneNumber(int id, String phoneKind, String phoneNumber, Contact contact) {
		
		boolean success = false; 
		try {
			
			//A vérifier qu'il ne faut pas instancier l'entityManager autre part (il est normalement en singleton)
			Persistence.createEntityManagerFactory("projetJPA");
			EntityManager em = JpaUtil.getEmf().createEntityManager();
			
			PhoneNumber phone = new PhoneNumber(id, phoneKind, phoneNumber, contact);
			
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			
			em.persist(phone);
			
			tx.commit();
			
			em.close();
			success=true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return success;
	}
	
}
