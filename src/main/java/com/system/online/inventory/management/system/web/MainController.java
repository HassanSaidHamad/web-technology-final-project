package com.system.online.inventory.management.system.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

//    call index
    @GetMapping("/")
    public String showIndexPage() {
        return "index";
    }

//    call login form
    @GetMapping("/open_login_form")
    public String showLoginForm() {
        return "/login/login";
    }

    //    open dashboard
    @GetMapping("/open_my_dashboard")
    public String showMyDashboard() {
        return "/dashboard/my_users_dashboard";
    }





}
