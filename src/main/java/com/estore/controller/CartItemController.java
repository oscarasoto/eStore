package com.estore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author oscarsoto on 3/1/17.
 *         There is no reasonable excuse for doing anything less than your best.
 *         - Martin, Robert C.
 */

//@Controller
//@RequestMapping("/cart")
public class CartItemController{

//    @GetMapping
//    public String get(HttpServletRequest request){
//        return "redirect:/cart" + request.getSession(true).getId();
//    }
//
//    @GetMapping("/{cartId}")
//    public String getCart(@PathVariable String cartId, Model model){
//        model.addAttribute("cartId", cartId);
//
//        return "cart";
//    }
}
