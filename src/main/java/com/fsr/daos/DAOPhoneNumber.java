package com.fsr.daos;

import com.fsr.entities.Contact;
import com.fsr.entities.PhoneNumber;
import com.fsr.util.JpaUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class DAOPhoneNumber implements IDAO<PhoneNumber> {

  public boolean addPhoneNumber(int id, String phoneKind, String phoneNumber, Contact contact) {

    boolean success = false;
    try {

      // A vérifier qu'il ne faut pas instancier l'entityManager autre part (il est normalement en
      // singleton)
      // Persistence.createEntityManagerFactory("projetJPA");
      EntityManager em = JpaUtil.getEmf().createEntityManager();

      PhoneNumber phone = new PhoneNumber(id, phoneKind, phoneNumber, contact);

      EntityTransaction tx = em.getTransaction();
      tx.begin();

      em.persist(phone);

      tx.commit();

      em.close();
      success = true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return success;
  }

  public boolean UpdatePhoneNumber(int id, String phoneKind, String phoneNumber, Contact contact) {

    boolean success = false;
    try {
      EntityManager em = JpaUtil.getEmf().createEntityManager();

      PhoneNumber ph = em.find(PhoneNumber.class, id);
      EntityTransaction tx = em.getTransaction();
      tx.begin();

      em.persist(ph);
      ph.setPhoneKind(phoneKind);
      ph.setPhoneNumber(phoneNumber);
      ph.setContact(contact);

      tx.commit();
      em.close();
      success = true;

    } catch (Exception e) {
      e.printStackTrace();
    }
    return success;
  }

  public boolean DeletePhoneNumber(int id) {

    boolean success = false;
    try {
      EntityManager em = JpaUtil.getEmf().createEntityManager();

      PhoneNumber ph = em.find(PhoneNumber.class, id);

      EntityTransaction tx = em.getTransaction();
      tx.begin();

      em.remove(ph);
      tx.commit();
      success = true;

      em.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return success;
  }

  public PhoneNumber GetPhoneNumber(int id) {
    try {
      EntityManager em = JpaUtil.getEmf().createEntityManager();

      PhoneNumber ph = em.find(PhoneNumber.class, id);

      return ph;
    } catch (Exception e) {
      e.printStackTrace();
      return new PhoneNumber();
    }
  }

  @Override
  public List<PhoneNumber> readAll() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean create(PhoneNumber entity) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public PhoneNumber read(int id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean update(int id, PhoneNumber entity) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean delete(int id) {
    // TODO Auto-generated method stub
    return false;
  }
}
