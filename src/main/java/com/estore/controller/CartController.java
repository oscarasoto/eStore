package com.estore.controller;

import com.estore.dao.CartDao;
import com.estore.dao.ProductDao;
import com.estore.model.Cart;
import com.estore.model.CartItem;
import com.estore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author oscarsoto on 3/1/17.
 *         There is no reasonable excuse for doing anything less than your best.
 *         - Martin, Robert C.
 */
//@Controller
//@RequestMapping("/rest/cart")
public class CartController {

//    @Autowired
//    private CartDao cartDao;
//
//    @Autowired
//    private ProductDao productDao;
//
//    @GetMapping("/{cartId}")
//    public @ResponseBody Cart read (@PathVariable String cartId){
//        return cartDao.read(cartId);
//    }
//
//    @PutMapping("/{cartID}")
//    @ResponseStatus(value= HttpStatus.NO_CONTENT)
//    public void update (@PathVariable String cartId, @RequestBody Cart cart){
//        cartDao.update(cartId, cart);
//
//    }
//
//    @DeleteMapping("/{cartID}")
//    @ResponseStatus(value= HttpStatus.NO_CONTENT)
//    public void delete(@PathVariable String cartId){
//        cartDao.delete(cartId);
//    }
//
//    @PutMapping("/add/{productId}")
//    @ResponseStatus(value= HttpStatus.NO_CONTENT)
//    public void addItem(@PathVariable Long productId, HttpServletRequest request){
//        String sessionId = request.getSession(true).getId();
//        Cart cart = cartDao.read(sessionId);
//
//        if (cart == null) {
//            cart = cartDao.create((new Cart(sessionId)));
//
//        }
//
//        Product product = productDao.findOne(productId);
//        if(product == null){
//            throw new IllegalArgumentException(new Exception());
//        }
//
//        cart.addCartItem(new CartItem(product));
//
//        cartDao.update(sessionId, cart);
//    }
//
//    @PutMapping("/remove/{productId}")
//    @ResponseStatus(value= HttpStatus.NO_CONTENT)
//    public void removeItem(@PathVariable Long productId, HttpServletRequest request){
//        String sessionId = request.getSession(true).getId();
//        Cart cart = cartDao.read(sessionId);
//
//        if (cart == null) {
//            cart = cartDao.create((new Cart(sessionId)));
//
//        }
//
//        Product product = productDao.findOne(productId);
//        if(product == null){
//            throw new IllegalArgumentException(new Exception());
//        }
//
//        cart.removeCartItem(new CartItem(product));
//
//        cartDao.update(sessionId, cart);
//    }

}
