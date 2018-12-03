package ar.edu.unq.desapp.grupoG.repository;

import java.util.List;

public interface GenericRepository<T>{
	 
    T create(T t);
 
    void delete(T t);
 
    T find(T t);
 
    T update(T t);
     
    List<T> findAll();
}
