package services;

import java.util.ArrayList;



public interface IService <T> {

    int add(T data);
    ArrayList <T> getAll();
    int update (T data);
    int update (int id, String lib);
    T show(int id);
    int remove(int id);
    int[] remove(int[] ids); // remove All
    
}
