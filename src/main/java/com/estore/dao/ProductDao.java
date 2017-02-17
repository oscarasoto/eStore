package com.estore.dao;

import com.estore.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author oscarsoto on 2/12/17.
 *         There is no reasonable excuse for doing anything less than your best.
 *         - Martin, Robert C.
 */
public interface ProductDao extends CrudRepository<Product, Long>{

}
