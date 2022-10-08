package com.lip6.api;

public interface IController<T> {
    public T create(T t) ;
    public T read(int id) ;
    public T update(T t) ;
    public void delete(int id) ;
}
