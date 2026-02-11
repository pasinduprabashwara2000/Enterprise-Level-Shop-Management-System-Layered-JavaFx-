package edu.ijse.layered.fx.sms.dao.custom.impl;

import edu.ijse.layered.fx.sms.dao.custom.CategoryDAO;
import edu.ijse.layered.fx.sms.dto.CategoryDTO;
import edu.ijse.layered.fx.sms.entity.CategoryEntity;
import edu.ijse.layered.fx.sms.util.CrudUtil;

public class CategoryDAOImpl implements CategoryDAO {

    @Override
    public String save(CategoryEntity categoryEntity) throws Exception {
        return CrudUtil.execute("INSERT INTO Category (name, description) VALUES(?,?)",
                    categoryEntity.getName(),
                    categoryEntity.getDescription());
    }

    @Override
    public String update(CategoryEntity categoryEntity) throws Exception {
        return CrudUtil.execute("UPDATE Category SET name=?, description=? WHERE categoryID=?",
                    categoryEntity.getName(),
                    categoryEntity.getDescription(),
                    categoryEntity.getCategoryID());
    }

    @Override
    public String delete(String id) throws Exception {
        return CrudUtil.execute("DELETE FROM Category WHERE categoryID=?",
                    id);
    }

    @Override
    public CategoryEntity search(String id) throws Exception {
        return CrudUtil.execute("SELECT * FROM Category WHERE categoryID=?",
                    id);
    }

    @Override
    public CategoryDTO getAll() throws Exception {
        return CrudUtil.execute("SELECT * FROM Category");
    }
}
