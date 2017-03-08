package com.estore.controller;

import com.estore.dao.BillingAddressDao;
import com.estore.dao.CustomerDao;
import com.estore.dao.ShippingAddressDao;
import com.estore.model.BillingAddress;
import com.estore.model.Customer;
import com.estore.model.ShippingAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
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

    @Autowired
    CustomerDao customerDao;

    @Autowired
    BillingAddressDao billingAddressDao;

    @Autowired
    ShippingAddressDao shippingAddressDao;

    @GetMapping("/register")
    public String registerCustomer(Model model) {

        Customer customer = new Customer();
        BillingAddress billingAddress = new BillingAddress();
        ShippingAddress shippingAddress = new ShippingAddress();
        customer.setBillingAddress(billingAddress);
        customer.setShippingAddress(shippingAddress);

        model.addAttribute("customer", customer);
        model.addAttribute("billingAddress", billingAddress);
        model.addAttribute("shippingAddress", shippingAddress);

        return "customers/registerCustomer";

    }

    @PostMapping("/register")
    public String registerCustomerPost(@Valid Customer customer, @Valid BillingAddress billingAddress, @Valid ShippingAddress shippingAddress,
                                       Errors validation, Model model) {

        if(validation.hasErrors()){
            model.addAttribute("errors", validation);
            model.addAttribute("customer", customer);
            model.addAttribute("billingAddress", billingAddress);
            model.addAttribute("shippingAddress", shippingAddress);
        }

        model.addAttribute("billingAddress", billingAddress);
        model.addAttribute("shippingAddress", shippingAddress);

        List<Customer> customerList = (List<Customer>) customerDao.findAll();

        for (int i=0; i< customerList.size(); i++) {
            if(customer.getCustomerEmail().equals(customerList.get(i).getCustomerEmail())) {
                model.addAttribute("emailMsg", "Email already exists");

                return "customers/registerCustomer";
            }

            if(customer.getUsername().equals(customerList.get(i).getUsername())) {
                model.addAttribute("usernameMsg", "Username already exists");

                return "customers/registerCustomer";
            }
        }

        customer.setEnabled(true);

        billingAddressDao.save(billingAddress);
        shippingAddressDao.save(shippingAddress);
        customerDao.save(customer);

        return "customers/registerCustomerSuccess";

    }

}
