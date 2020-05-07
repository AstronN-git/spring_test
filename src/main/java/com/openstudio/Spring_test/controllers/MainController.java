package com.openstudio.Spring_test.controllers;

import com.openstudio.Spring_test.entities.Product;
import com.openstudio.Spring_test.functions.Sha256;
import com.openstudio.Spring_test.services.LedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.openstudio.Spring_test.services.ProductService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MainController {

    ProductService productService;
    LedService ledService;

    @Autowired
    public void setLedService(LedService ledService) {
        this.ledService = ledService;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/index")
    public String homepage() {
        return "index";
    }

    @GetMapping("/shop")
    public String shoppage(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "shop";
    }

    @GetMapping("/details/{id}")
    public String detailspage(Model model, @PathVariable("id") long id) {
        Product selected = productService.getProductByID(id);
        model.addAttribute("selected", selected);
        return "details";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProductByID(@PathVariable("id") long id) {
        productService.deleteProductByID(id);
        return "redirect:/shop";
    }

    @GetMapping("/http_esp")
    @ResponseBody
    public String responseTest(@RequestParam("esp_id") int id) {
        if(ledService.isOn()) return "1";
        else return "0";
    }

    @GetMapping("/led")
    public String ledpage(Model model) {
        model.addAttribute("isOn", ledService.isOn() ? "включен" : "выключен");
        return "led";
    }

    @GetMapping("/led/switch")
    public String switchLed() {
        ledService.setOn(!ledService.isOn());
        return "redirect:/led";
    }

    @GetMapping("/admin")
    public String adminpage() {
        return "admin";
    }

    @GetMapping("/admin/stop-server")
    public String stopserver() {
        ledService.stopAll();
        System.exit(0);
        return "";
    }
}
