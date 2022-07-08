package com.system.online.inventory.management.system.controller;

import com.system.online.inventory.management.system.model.Product;
import com.system.online.inventory.management.system.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ProductController {

    @Autowired
    private ProductService productService;

    //call product form
    @GetMapping("/open_product_form")
    public String showProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "/signup-forms/product_form";
    }

    //    save products
    @PostMapping("/save/products")
    public String saveProduct(@ModelAttribute(name = "product") Product product,
                              @RequestParam("fileImage") MultipartFile multipartFile) throws IOException {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        product.setProImage(fileName);
        Product savedProduct = productService.saveProducts(product);

        String uploadDir = "./product-images/" + savedProduct.getProImage();
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

        return "redirect:/open_view_product_table_form";

    }

//    view products
    @GetMapping("/open_view_product_table_form")
    public String showViewProductForm(Model model) {
        List<Product> productList = productService.findAllProducts();
        model.addAttribute("productList", productList);
        return "/views/view_product_form";
    }

//    edit
    @GetMapping("/edit/product/{proId}")
    public String editProduct(Model model, @PathVariable Integer proId) {
        Product product = productService.editProduct(proId);
        model.addAttribute("product", product);
        return "/edit-forms/edit_product_form";
    }

//    delete
    @GetMapping("/delete/product/{proId}")
    public String deleteProduct(@PathVariable Integer proId) {
        productService.deleteProducts(proId);
        return "redirect:/open_view_product_table_form";
    }


}
