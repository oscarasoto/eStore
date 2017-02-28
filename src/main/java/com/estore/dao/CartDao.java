package com.estore.dao;

import com.estore.model.Cart;

/**
 * @author oscarsoto on 2/27/17.
 *         There is no reasonable excuse for doing anything less than your best.
 *         - Martin, Robert C.
 */
public interface CartDao {

    Cart create(Cart cart);

    Cart read(Long cartId);

    void update(Long cartId, Cart cart);

    void delate(Long cartId);

}
