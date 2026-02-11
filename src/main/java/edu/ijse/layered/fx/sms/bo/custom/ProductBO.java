package edu.ijse.layered.fx.sms.bo.custom;

import edu.ijse.layered.fx.sms.dto.ProductDTO;

import java.util.ArrayList;

public interface ProductBO {

    String save(ProductDTO productDTO) throws Exception;
    String update(ProductDTO productDTO) throws Exception;
    String delete(String id) throws Exception;
    ProductDTO search(String id) throws Exception;
    ArrayList<ProductDTO> getAll() throws Exception;

}
