package org.example.case_modul4.controller;

import org.apache.catalina.User;
import org.example.case_modul4.model.Cart;
import org.example.case_modul4.repository.CartRepository;
import org.example.case_modul4.repository.UserRepository;
import org.example.case_modul4.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;
    @Autowired
    private CartRepository cartRepository;

    @GetMapping("/cart")
    public String viewCart() {
//        if (userId != null) {
//            Cart cart = cartService.getCartByUser(userId);
//            model.addAttribute("cart", cart);
//            return "cart"; // Trả về view cart.html (tạo view này nếu chưa có)
//        }
        return "redirect:/cart"; // Nếu chưa đăng nhập, chuyển hướng đến trang đăng nhập
    }
}