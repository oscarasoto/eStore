package com.estore.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author oscarsoto on 2/27/17.
 *         There is no reasonable excuse for doing anything less than your best.
 *         - Martin, Robert C.
 */
public class Cart {
    private Long cartId;
    private Map<Long, CartItem> cartItems;
    private double grandTotal;

    private Cart(){
        cartItems = new HashMap<Long, CartItem>();
        grandTotal = 0;
    }

    public Cart(Long cartId){
        this();
        this.cartId = cartId;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Map<Long, CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Map<Long, CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public void addCartItem (CartItem item){
        Long productId = item.getProduct().getProductId();

        if(cartItems.containsKey(productId)){
            CartItem existingCartItem = cartItems.get(productId);
            existingCartItem.setQuantity(existingCartItem.getQuantity()+item.getQuantity());
            cartItems.put(productId, existingCartItem);
        } else {
            cartItems.put(productId, item);
        }

        updateGrandTotal();
    }

    public void removeCartItem (CartItem item){
        Long productId = item.getProduct().getProductId();
        cartItems.remove(productId);
        updateGrandTotal();

    }

    private void updateGrandTotal() {
        grandTotal = 0;
        for (CartItem item : cartItems.values()){
            grandTotal += item.getTotalPrice();
        }
    }


}
