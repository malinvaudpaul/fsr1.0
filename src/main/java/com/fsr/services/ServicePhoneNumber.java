package com.fsr.services;

import com.fsr.daos.DAOPhoneNumber;
import com.fsr.entities.Contact;
import com.fsr.entities.PhoneNumber;
import java.util.List;

public class ServicePhoneNumber implements IService<PhoneNumber> {

  public void createPhoneNumber(int id, String phoneKind, String phoneNumber, Contact contact) {

    DAOPhoneNumber DaoPN = new DAOPhoneNumber();
    boolean success = DaoPN.addPhoneNumber(id, phoneKind, phoneNumber, contact);
    if (success) System.out.println("Numéro ajout�!");
    else System.out.println("Numéro non ajout�!");
  }

  @Override
  public PhoneNumber read(int id) {
    DAOPhoneNumber DaoPN = new DAOPhoneNumber();
    PhoneNumber ph = DaoPN.getPhoneNumber(id);

    System.out.println(ph.getId() + ph.getPhoneKind() + ph.getPhoneNumber() + ph.getContact());
  }

  @Override
  public List<PhoneNumber> readAll() {
    // TODO Auto-generated method stub
    return null;
  }

  public void update(int id, String phoneKind, String phoneNumber, Contact contact) {

    DAOPhoneNumber DaoPN = new DAOPhoneNumber();
    boolean success = DaoPN.UpdatePhoneNumber(id, phoneKind, phoneNumber, contact);
    if (success) System.out.println("Numéro ajout�!");
    else System.out.println("Numéro non ajout�!");
  }

  @Override
  public void delete(int id) {
    DAOPhoneNumber DaoPN = new DAOPhoneNumber();
    boolean success = DaoPN.RemovePhoneNumber(id);
    if (success) System.out.println("Numéro supprimé!");
    else System.out.println("Numéro non supprimé!");
  }
}
