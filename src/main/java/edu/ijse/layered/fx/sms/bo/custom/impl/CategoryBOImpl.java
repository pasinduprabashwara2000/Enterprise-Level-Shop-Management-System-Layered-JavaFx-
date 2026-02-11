package edu.ijse.layered.fx.sms.bo.custom.impl;

import edu.ijse.layered.fx.sms.bo.custom.CategoryBO;
import edu.ijse.layered.fx.sms.dao.DAOFactory;
import edu.ijse.layered.fx.sms.dao.custom.CategoryDAO;
import edu.ijse.layered.fx.sms.dto.CategoryDTO;
import edu.ijse.layered.fx.sms.entity.CategoryEntity;
import java.util.ArrayList;

public class CategoryBOImpl implements CategoryBO {

    CategoryDAO categoryDAO = (CategoryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CATEGORY);

    @Override
    public String save(CategoryDTO categoryDTO) throws Exception {

        CategoryEntity categoryEntity = new CategoryEntity(
                null,
                categoryDTO.getName(),
                categoryDTO.getDescription()
        );

        return Boolean.parseBoolean(categoryDAO.save(categoryEntity)) ? "Category Save Successfully" : "Category Save Failed";
    }

    @Override
    public String update(CategoryDTO categoryDTO) throws Exception {

        CategoryEntity categoryEntity = new CategoryEntity(
                categoryDTO.getCategoryID(),
                categoryDTO.getName(),
                categoryDTO.getDescription()
        );

        return Boolean.parseBoolean(categoryDAO.update(categoryEntity)) ? "Category Updated Successfully" : "Category Updated Failed";

    }

    @Override
    public String delete(String id) throws Exception {
        return Boolean.parseBoolean(categoryDAO.delete(id)) ? "Category Deleted Successfully" : "Category Deleted Failed";
    }

    @Override
    public CategoryDTO search(String id) throws Exception {
        CategoryEntity categoryEntity = categoryDAO.search(id);
        return new CategoryDTO(
                categoryEntity.getCategoryID(),
                categoryEntity.getName(),
                categoryEntity.getDescription()
        );
    }

    @Override
    public ArrayList<CategoryDTO> getAll() throws Exception {

        ArrayList <CategoryEntity> categoryEntities = categoryDAO.getAll();
        ArrayList <CategoryDTO> categoryDTOS = new ArrayList<>();

        for (CategoryEntity categoryEntity : categoryEntities){
            categoryDTOS.add(new CategoryDTO(
                    categoryEntity.getCategoryID(),
                    categoryEntity.getName(),
                    categoryEntity.getDescription()
            ));
        }

        return null;
    }
}
