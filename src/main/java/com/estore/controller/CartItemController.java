package com.estore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author oscarsoto on 3/1/17.
 *         There is no reasonable excuse for doing anything less than your best.
 *         - Martin, Robert C.
 */

@Controller
@RequestMapping("/cart")
public class CartItemController {

    public String get(){


        return "products/admin";
    }
}
