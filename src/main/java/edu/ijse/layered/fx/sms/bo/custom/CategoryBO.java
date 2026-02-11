package edu.ijse.layered.fx.sms.bo.custom;

import edu.ijse.layered.fx.sms.dto.CategoryDTO;
import java.util.ArrayList;

public interface CategoryBO {

    String save(CategoryDTO categoryDTO) throws Exception;
    String update(CategoryDTO categoryDTO) throws Exception;
    String delete(String id) throws Exception;
    CategoryDTO search(String id) throws Exception;
    ArrayList<CategoryDTO> getAll() throws Exception;

}
