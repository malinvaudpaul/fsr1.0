package com.fsr.daos;

import com.fsr.entities.ContactGroup;
import java.util.List;

public class DAOContactGroup implements IDAO<ContactGroup> {

  @Override
  public List<ContactGroup> readAll() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean delete(int id) {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public boolean create(ContactGroup entity) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public ContactGroup read(int id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean update(int id, ContactGroup entity) {
    // TODO Auto-generated method stub
    return false;
  }
}
