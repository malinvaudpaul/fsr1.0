package com.lip6.daos;

import java.util.List;

public interface IDAO<T> {
	public T read(int id) ;
	public List<T> readAll() ;
	public void delete(int id) ;
}