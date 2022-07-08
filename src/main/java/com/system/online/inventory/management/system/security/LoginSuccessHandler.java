package com.system.online.inventory.management.system.security;

import com.system.online.inventory.management.system.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {



    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {

        MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();
        System.out.println("Username: " + myUserDetails.getUsername());
        System.out.println(myUserDetails.getUserInfo());

        String redirectUrl = request.getContextPath();
        if (myUserDetails.hasRole("ADMIN")) {
            redirectUrl += "/dashboard/my_users_dashboard";

        } else if (myUserDetails.hasRole("STAFF")) {

            redirectUrl += "/dashboard/my_users_dashboard";

        } else if (myUserDetails.hasRole("CUSTOMER")) {

            redirectUrl += "/dashboard/my_users_dashboard";

        }

        response.sendRedirect(redirectUrl);

    }
}
