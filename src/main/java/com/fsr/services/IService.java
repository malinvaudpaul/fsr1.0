package com.fsr.services;

import java.util.List;

public interface IService<T> {
  public T read(int id);

  public List<T> readAll();

  public void delete(int id);
}
