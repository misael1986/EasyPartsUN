package com.example.backend.commons;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public abstract class GenericServiceImp<T, ID extends Serializable> implements GenericServiveAPI<T, ID> {

    public abstract JpaRepository<T, ID> getDao(); //clase de JPA - aqui la declaro

    @Override
    public T save(T entity) {
        return getDao().save(entity);
    }

    @Override
    public <S extends T> Iterable<S> saveAll(Iterable<S> entities){
        return getDao().saveAll(entities);
    }

    @Override
    public void delete(ID id) {
        getDao().deleteById(id);
    }

    @Override
    public T get(ID id) {
        Optional<T> obj = getDao().findById(id);
        if (obj.isPresent()) {
            return obj.get();
        }
        return null;
    }

    @Override
    public List<T> getAll() {
        List<T> returnlist = new ArrayList<>();
        getDao().findAll().forEach(obj -> returnlist.add(obj));
        return returnlist;
    }

    @Override
    public void deleteAll(String tabla) throws SQLException {
        getDao().deleteAll();
        Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/partes", "root", "password");
        Statement s = c.createStatement();
        String consult ="ALTER TABLE "+tabla+" AUTO_INCREMENT = 1;";
        s.executeUpdate(consult);

    }


}
