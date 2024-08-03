package org.example.utility;

import org.example.entities.BaseEntity;

import java.util.ArrayList;
import java.util.List;

//metodların açıklamaları yazılcak.

public class DatabaseManager<T extends BaseEntity> implements ICrud<T> {

    //aynı paket içerisinden erişmek için protected yaptım.
    protected ArrayList<T> arrayList = new ArrayList<>();

    @Override
    public List<T> getList(List<T> t) {
        return arrayList;
    }

    @Override
    public T findById(String Id) {
        for (BaseEntity entity: arrayList){
            if(entity.getId().equalsIgnoreCase(Id)){
                return (T) entity;
            }
        }
        return null;
    }

    @Override
    public List<T> findAll() {
        return arrayList;
    }

    @Override
    public T crate(T t) {
       if(arrayList.add(t)){
           return t;
       }
       return null;
    }

    @Override
    public T delete(T t) {
        if(arrayList.remove(t)){
            return t;
        }
        return null;
    }
}
