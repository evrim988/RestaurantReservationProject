package org.example.utility;

import java.util.List;

public interface ICrud<T> {

    List<T> getList(List<T> t);

    T findById(String Id);

    List<T> findAll();

    T crate(T t);

    T delete(T t);

}
