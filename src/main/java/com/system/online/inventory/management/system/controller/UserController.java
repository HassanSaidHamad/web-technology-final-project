package com.system.online.inventory.management.system.controller;

import com.system.online.inventory.management.system.model.User;
import com.system.online.inventory.management.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    //    call user form
    @GetMapping("/open_user_reg_form")
    public String showUserRegForm(Model model) {
        model.addAttribute("user", new User());
        return "/signup-forms/user_registration_form";
    }


    //    save user
    @PostMapping("/save/users")
    public String saveProduct(@ModelAttribute(name = "product") User user,
                              @RequestParam("fileImage") MultipartFile multipartFile) throws IOException {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        user.setProfile(fileName);
        User savedUser = userService.saveUser(user);

        String uploadDir = "./user-profiles/" + savedUser.getUserId();
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            throw new IOException("Could not save the uploaded image: " + fileName);
        }

        return "redirect:/open_my_dashboard";

    }


//    save edited user data
    @PostMapping("/save/edited_user_data")
    public String editedUserData(User user) {
        userService.saveUser(user);
        return "redirect:/open_my_dashboard";
    }


    //    call view user form
    @GetMapping("/open_view_user_table_form")
    public String showUserTableForm(Model model) {
        List<User> userList = userService.findAllUsers();
        model.addAttribute("userList", userList);
        return "views/view_user_details_form";
    }


//    edit user
    @GetMapping("/edit/user/{id}")
    public String showEditForm(Model model, @PathVariable Integer  id) {
        User user = userService.updateUsers(id);
        model.addAttribute("user", user);
        return "/edit-forms/edit_user_registration_form";
    }


//    delete user
    @GetMapping("/delete/user/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userService.deleteUsers(id);
        return "redirect:/open_view_user_table_form";
    }


//    view personal info
    @GetMapping("/open_view_personal_account")
    public String showPersonalAccountForm() {
        return "/views/view_personal_account";
    }


  //    edit view personal info
    @GetMapping("/edit_view_personal_account")
    public String showEditPersonalAccountForm(Model model) {
        List<User> userList = userService.findAllUsers();
        model.addAttribute("userList", userList);
        return "/views/edit_view_personal_account";
    }



}
