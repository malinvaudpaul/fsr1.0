package com.lip6.services;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.lip6.daos.DAOPhoneNumber;
import com.lip6.entities.Contact;
import com.lip6.entities.PhoneNumber;

public class ServicePhoneNumber {

	void createPhoneNumber(int id, String phoneKind, String phoneNumber, Contact contact) {
		
		DAOPhoneNumber DaoPN = new DAOPhoneNumber();
		boolean success = DaoPN.addPhoneNumber(id, phoneKind, phoneNumber, contact);
		if (success) 
			System.out.println("Numéro ajout�!");
		
		else 
			System.out.println("Numéro non ajout�!");
	}
	
	public void DeletePhoneNumber(int id) {
		DAOPhoneNumber DaoPN = new DAOPhoneNumber();
		boolean success = DaoPN.RemovePhoneNumber(id);
		if (success) 
			System.out.println("Numéro supprimé!");
		
		else 
			System.out.println("Numéro non supprimé!");
	}
	
	public void UpdatePhoneNumber(int id,String phoneKind, String phoneNumber, Contact contact) {

		DAOPhoneNumber DaoPN = new DAOPhoneNumber();
		boolean success = DaoPN.UpdatePhoneNumber(id, phoneKind, phoneNumber, contact);
		if (success) 
			System.out.println("Numéro ajout�!");
		
		else 
			System.out.println("Numéro non ajout�!");
	}
	
	public void getPhoneNumber(int id) {
		DAOPhoneNumber DaoPN = new DAOPhoneNumber();
		PhoneNumber ph = DaoPN.getPhoneNumber(id);
		
	    System.out.println(ph.getId() + ph.getPhoneKind() + ph.getPhoneNumber() + ph.getContact());
	}
}
