package com.estore.dao;

import com.estore.model.Product;

import java.util.List;

/**
 * @author oscarsoto on 2/12/17.
 *         There is no reasonable excuse for doing anything less than your best.
 *         - Martin, Robert C.
 */
public interface ProductDao {

    void addProduct(Product product);

    Product getProductById(String id);

    List<Product> getAllProducts();

    void deleteProduct(String id);

}
