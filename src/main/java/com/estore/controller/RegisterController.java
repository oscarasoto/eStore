package com.estore.controller;

import com.estore.model.BillingAddress;
import com.estore.model.Customer;
import com.estore.model.ShippingAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

/**
 * @author oscarsoto on 3/5/17.
 *         There is no reasonable excuse for doing anything less than your best.
 *         - Martin, Robert C.
 */
@Controller
public class RegisterController {

//    @Autowired
//    private CustomerService customerService;

    @GetMapping("/register")
    public String registerCustomer(Model model) {

        Customer customer = new Customer();
        BillingAddress billingAddress = new BillingAddress();
        ShippingAddress shippingAddress = new ShippingAddress();
        customer.setBillingAddress(billingAddress);
        customer.setShippingAddress(shippingAddress);

        model.addAttribute("customer", customer);

        return "customers/registerCustomer";

    }

//    @PostMapping("/register")
//    public String registerCustomerPost(@Valid Customer customer, BindingResult result, Model model) {
//
//        if (result.hasErrors()) {
//            return "registerCustomer";
//        }
//
//        List<Customer> customerList=customerService.getAllCustomers();
//
//        for (int i=0; i< customerList.size(); i++) {
//            if(customer.getCustomerEmail().equals(customerList.get(i).getCustomerEmail())) {
//                model.addAttribute("emailMsg", "Email already exists");
//
//                return "registerCustomer";
//            }
//
//            if(customer.getUsername().equals(customerList.get(i).getUsername())) {
//                model.addAttribute("usernameMsg", "Username already exists");
//
//                return "registerCustomer";
//            }
//        }
//
//        customer.setEnabled(true);
//        customerService.addCustomer(customer);
//
//        return "registerCustomerSuccess";
//
//    }


}
