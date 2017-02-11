package us.oscarsoto.estore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import us.oscarsoto.estore.dao.ProductDao;
import us.oscarsoto.estore.model.Product;

import java.util.List;

/**
 * @author oscarsoto on 2/11/17.
 *         There is no reasonable excuse for doing anything less than your best.
 *         - Martin, Robert C.
 */

@Controller
public class HomeController {

    private ProductDao productDao = new ProductDao();

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/productList")
    public String getProducts(Model model){
        List<Product> products = productDao.getProductList();
        model.addAttribute("products", products);

        return "productList";
    }

}
