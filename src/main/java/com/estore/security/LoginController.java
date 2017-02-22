package com.estore.security;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author oscarsoto on 2/21/17.
 *         There is no reasonable excuse for doing anything less than your best.
 *         - Martin, Robert C.
 */
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }


}
