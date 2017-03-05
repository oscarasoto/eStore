package com.estore.dao;

import com.estore.model.Cart;
import com.estore.model.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * @author oscarsoto on 2/27/17.
 *         There is no reasonable excuse for doing anything less than your best.
 *         - Martin, Robert C.
 */
public interface CartDao extends CrudRepository<Cart, Long> {

}
