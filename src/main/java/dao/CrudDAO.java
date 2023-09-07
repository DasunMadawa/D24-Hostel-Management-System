package dao;

import java.util.List;

public interface CrudDAO <T> extends SuperDAO{
    public boolean add(T entity) throws Exception;
    public T search(String idOrName) throws Exception;
    public boolean update(T entity) throws Exception;
    public boolean delete(String id) throws Exception;
    public List<T> getAll() throws Exception;

}
