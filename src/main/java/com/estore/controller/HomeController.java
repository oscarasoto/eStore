package com.estore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.estore.dao.ProductDao;
import com.estore.model.Product;
import com.estore.security.BaseController;

import java.util.ArrayList;
import java.util.List;


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

    @GetMapping("products/accessories")
    public String getAccessories(Model model){
        List<Product> allProducts = (List<Product>) productDao.findAll();
        List<Product> allAccessories = getProductsByCategory(allProducts, "Accessory");
        model.addAttribute("products", allAccessories);
        return "products/productList";
    }

    @GetMapping("products/instruments")
    public String getInstruments(Model model){
        List<Product> allProducts = (List<Product>) productDao.findAll();
        List<Product> allInstruments = getProductsByCategory(allProducts, "Instrument");
        model.addAttribute("products", allInstruments);
        return "products/productList";
    }

    @GetMapping("products/records")
    public String getRecords(Model model){
        List<Product> allProducts = (List<Product>) productDao.findAll();
        List<Product> allRecords = getProductsByCategory(allProducts, "Record");
        model.addAttribute("products", allRecords);
        return "products/productList";
    }

    private List<Product> getProductsByCategory(List<Product> allProducts, String Category) {
        List<Product> productsByCategoy = new ArrayList<Product>();
        for(Product product : allProducts){
            if (Category.equalsIgnoreCase(product.getProductCategory())){
                productsByCategoy.add(product);
            }
        }
        return productsByCategoy;
    }
}
