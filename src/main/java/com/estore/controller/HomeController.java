package com.estore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.estore.dao.ProductDao;
import com.estore.model.Product;
import com.estore.security.BaseController;


/**
 * @author oscarsoto on 2/11/17.
 *         There is no reasonable excuse for doing anything less than your best.
 *         - Martin, Robert C.
 */

@Controller
public class HomeController extends BaseController {

    @Autowired
    ProductDao productDao;

    @GetMapping("/")
    public String home(Model model) {

        if(isLoggedIn()){
            String userName = loggedInUser().getUsername();
            model.addAttribute("showAdminMenu", userName.equals("admin"));
            model.addAttribute("showCustomerMenu", !userName.equals("admin"));
        }
        return "home";
    }

    @GetMapping("/contact")
    public String contact(){ return "contact"; }

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


}
