package repositories;

import java.util.ArrayList;

import entities.AbstractEntities;


// interface generique 
public interface ITables <T extends AbstractEntities> { 
    
    
    
    int insert(T data);

    int update(T data);

    ArrayList<T> findAll();

    T findById(int id);

    int delete(int id);

    int indexOf(int id);

    

    
}



