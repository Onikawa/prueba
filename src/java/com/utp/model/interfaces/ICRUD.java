package com.utp.model.interfaces;



import java.util.List;

public interface ICRUD<T> {

    List<T> selectAll();

    public void insert(T t);

    public T selectById(String t);

    public void update(T t);

    public void delete(String id);

}
