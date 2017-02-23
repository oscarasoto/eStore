package com.estore.controller;

import com.estore.dao.ProductDao;
import com.estore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * @author oscarsoto on 2/21/17.
 *         There is no reasonable excuse for doing anything less than your best.
 *         - Martin, Robert C.
 */
@Controller
public class AdminController {

    @Value("${file-upload-path}")
    private String uploadPath;

    @Autowired
    ProductDao productDao;

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
    public String addProduct(@Valid Product product, Errors validation, @RequestParam(name = "file") MultipartFile uploadedFile, Model model){


        productDao.save(product);

        String filename = "product"+product.getProductId()+uploadedFile.getOriginalFilename();
        String filepath = Paths.get(uploadPath, filename).toString();
        File destinationFile = new File(filepath);

        uploadFile(uploadedFile, model, product, filename, destinationFile);

        productDao.save(product);

        return "redirect:/admin/productInventory";
    }

    @GetMapping("/admin/productInventory/deleteProduct/{productId}")
    public String deleteProduct(@PathVariable Long productId){

        Product existingProduct = productDao.findOne(productId);

        String filename = existingProduct.getProductImage();
        String filepath = Paths.get(uploadPath, filename).toString();

        File destinationFile = new File(filepath);

        destinationFile.delete();

        productDao.delete(existingProduct);


        return "redirect:/admin/productInventory";
    }


    @GetMapping("/admin/productInventory/editProduct/{productId}")
    public String editProduct(@PathVariable Long productId, Model model){

        model.addAttribute("product", productDao.findOne(productId));
        return "products/editProduct";
    }

    @PostMapping("/admin/productInventory/editProduct/{productId}")
    public String editProduct(@PathVariable Long productId, @Valid Product editedProduct, Errors validation, @RequestParam(name = "file") MultipartFile uploadedFile, Model model){

        if(validation.hasErrors()){
            model.addAttribute("errors", validation);
            model.addAttribute("product", editedProduct);
            return "products/editProduct";
        }

        Product existingProduct = productDao.findOne(productId);

        // Updates product information
        existingProduct.setProductName(editedProduct.getProductName());
        existingProduct.setProductCategory(editedProduct.getProductCategory());
        existingProduct.setProductDescription(editedProduct.getProductDescription());
        existingProduct.setProductPrice(editedProduct.getProductPrice());
        existingProduct.setProductCondition(editedProduct.getProductCondition());
        existingProduct.setProductStatus(editedProduct.getProductStatus());
        existingProduct.setUnitInStock(editedProduct.getUnitInStock());
        existingProduct.setProductManufacturer(editedProduct.getProductManufacturer());

        if (!uploadedFile.isEmpty()){

            // Delete current image from uploads folder
            String filename = existingProduct.getProductImage();
            String filepath = Paths.get(uploadPath, filename).toString();
            File destinationFile = new File(filepath);
            destinationFile.delete();

            // Upload new image to uploads folder
            filename = "product"+editedProduct.getProductId()+uploadedFile.getOriginalFilename();
            filepath = Paths.get(uploadPath, filename).toString();
            destinationFile = new File(filepath);
            uploadFile(uploadedFile, model, existingProduct, filename, destinationFile);

        }

        productDao.save(existingProduct);


        return "redirect:/admin/productInventory";
    }

    private void uploadFile(@RequestParam(name = "file") MultipartFile uploadedFile, Model model, Product existingProduct, String filename, File destinationFile) {
        try {
            uploadedFile.transferTo(destinationFile);
            existingProduct.setProductImage(filename);
            model.addAttribute("message", "File successfully uploaded!");
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("message", "Oops! Something went wrong! " + e);
        }
    }


}
