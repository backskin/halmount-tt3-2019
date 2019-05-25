package com.haulmont.model.db;

import java.sql.*;
import java.util.List;

public abstract class AbstractDBController<E,K> {

    private SingletonDatabase db;

    AbstractDBController() {
        db = SingletonDatabase.getInstance();
    }

    public abstract List<E> getAll();
    public abstract E getEntityById(K id);
    public abstract void update(E entity);
    public abstract boolean delete(K id);
    public abstract boolean create(E entity);

    protected ResultSet sendQuery(String sql) throws SQLException {

        Statement statement = db.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        statement.close();
        return rs;
    }
}