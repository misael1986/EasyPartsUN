package com.example.backend.commons;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public interface GenericServiveAPI<T, ID extends Serializable> {

    T save(T entity);//con este mismo edito - si le envio un ID existente

    <S extends  T> Iterable<S> saveAll(Iterable<S> entity);

    void delete(ID id);

    void deleteAll(String tabla)throws SQLException;

    T get(ID id);

    List<T> getAll();

}
