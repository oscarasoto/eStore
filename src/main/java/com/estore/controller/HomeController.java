package com.estore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import com.estore.dao.ProductDao;
import com.estore.model.Product;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;


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

    @GetMapping("/admin/productInventory")
    public String productInventory(Model model){
        model.addAttribute("products", productDao.findAll());

        return "products/productInventory";
    }

    @GetMapping("/admin/productInventory/addProduct")
    public String addProduct(Model model){
        model.addAttribute("product", new Product());
        return "products/addProduct";
    }

    @PostMapping("/admin/productInventory/addProduct")
    public String addProductPost(@Valid Product product){

        productDao.save(product);

        return "redirect:/admin/productInventory";
    }

    @GetMapping("/admin/productInventory/deleteProduct/{productId}")
    public String deleteProduct(@PathVariable Long productId){

        Product existingProduct = productDao.findOne(productId);
        productDao.delete(existingProduct);

        return "redirect:/admin/productInventory";
    }
}
