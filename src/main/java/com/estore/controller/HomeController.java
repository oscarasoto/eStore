package com.estore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.estore.dao.ProductDao;
import com.estore.model.Product;

import java.io.IOException;
import java.util.List;

/**
 * @author oscarsoto on 2/11/17.
 *         There is no reasonable excuse for doing anything less than your best.
 *         - Martin, Robert C.
 */

@Controller
public class HomeController {

    @Autowired
    ProductDao productDao;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/products")
    public String getProducts(Model model){
        model.addAttribute("products", productDao.findAll());
        return "products/productList";
    }

    @GetMapping("products/{productId}")
    public String viewProduct(@PathVariable Long productId, Model model){

        Product existingProduct = productDao.findOne(productId);
        model.addAttribute("product", existingProduct);

        return "products/viewProduct";
    }

    @GetMapping("/admin")
    public String adminPage(){
        return "products/admin";
    }
}
