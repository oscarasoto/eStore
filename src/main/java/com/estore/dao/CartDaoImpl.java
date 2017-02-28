package com.estore.dao;

import com.estore.model.Cart;

import java.util.HashMap;
import java.util.Map;

/**
 * @author oscarsoto on 2/27/17.
 *         There is no reasonable excuse for doing anything less than your best.
 *         - Martin, Robert C.
 */
public class CartDaoImpl implements CartDao{

    private Map<Long, Cart> listOfCarts;

    public CartDaoImpl(){
        listOfCarts = new HashMap<Long, Cart>();
    }

    @Override
    public Cart create(Cart cart) {

        if(listOfCarts.keySet().contains(cart.getCartId())){
            throw new IllegalArgumentException(String.format("Cannot create a cart. A cart with the given id(%) " +
            "already " + "exists", cart.getCartId()));
        }

        listOfCarts.put(cart.getCartId(), cart);

        return cart;
    }

    @Override
    public Cart read(Long cartId) {
        return listOfCarts.get(cartId);
    }

    @Override
    public void update(Long cartId, Cart cart) {
        if(!listOfCarts.keySet().contains(cartId)){
            throw new IllegalArgumentException(String.format("Cannot update cart. The cart with the given id(%) " +
                    "does not " + "exist", cart.getCartId()));
        }

        listOfCarts.put(cartId, cart);

    }

    @Override
    public void delate(Long cartId) {
        if(!listOfCarts.keySet().contains(cartId)){
            throw new IllegalArgumentException(String.format("Cannot delete cart. The cart with the given id(%) " +
                    "does not " + "exist", cartId));
        }
        listOfCarts.remove(cartId);

    }
}
