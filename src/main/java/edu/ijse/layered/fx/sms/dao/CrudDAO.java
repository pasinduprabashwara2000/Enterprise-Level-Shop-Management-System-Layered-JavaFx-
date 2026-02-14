package edu.ijse.layered.fx.sms.dao;

import java.util.ArrayList;

public interface CrudDAO <T> extends SuperDAO {

    String save(T t) throws Exception;
    String update(T t) throws Exception;
    String delete(String id) throws Exception;
    T search(String id) throws Exception;
    ArrayList<T> getAll() throws Exception;

}
