package repositories.List;

import java.util.ArrayList;

import entities.AbstractEntities;

import repositories.ITables;

public class Tables <T extends AbstractEntities> implements ITables <T> {
    


    private ArrayList<T> tables = new ArrayList<>();

    @Override
    public int insert(T data) {
        tables.add(data);
        return 1;
    }

    @Override
    public int update(T data) {
        int pos = indexOf(data);
        if (pos != -1) {
            tables.set(pos, data);
            return 1;
        }
        return 0;
    }

    private int indexOf(T data) {
        return 0;
    }

    @Override
    public ArrayList<T> findAll() {
        return tables;
    }

    @Override
    public T findById(int id) {
        int pos = indexOf(id);
        if (pos != -1) {
            return tables.get(pos);
        }
        return null;
    }

    @Override
    public int delete(int id) {
        int pos = indexOf(id);
        if (pos != -1) {
            tables.remove(pos);
            return 1;
        }
        return 0;
    }

    @Override
    public int indexOf(int id) {
        int pos = 0;
        for (T t : tables) {
            if (t.getId()==id) {
                return pos;
            }
            pos++;
        }
        return -1; 
    }
        
}


