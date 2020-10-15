//Alpha-X-Computer-System
//Software Design Alpha X Software Solution
package dao;

import entity.SuperEntity;
import java.util.List;

public interface CrudDAO <T extends SuperEntity,ID> extends SuperDAO{
    public boolean save(T t) throws Exception;
    public boolean delete(ID id) throws Exception;
    public boolean update(T t) throws Exception;
    public T search (ID id)throws Exception;
    public List<T> getAll() throws Exception;
}
