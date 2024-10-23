package org.example.case_modul4.service;

import org.apache.catalina.User;
import org.example.case_modul4.model.Cart;
import org.example.case_modul4.model.CartItem;
import org.example.case_modul4.repository.CartItemRepository;
import org.example.case_modul4.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    // Tim kiem gio hang theo user.
    public Cart getCartByUser(User user) {
        return cartRepository.findByUser(user).orElse(null);
    }
    //Them san pham vao gio hang
    public void addCartItem(Cart cart, CartItem cartItem) {
        cart.addCartItem(cartItem);
        cartRepository.save(cart);
    }
    //Xoa san pham khoi gio hang
    public void removeCartItem(Cart cart, CartItem cartItem) {
        cart.removeCartItem(cartItem);
        cartItemRepository.delete(cartItem);
        cartRepository.save(cart);
    }
    //Lay tat ca cac san pham trong gio hang
    public List<CartItem> getCartItems(Cart cart) {
        return cartItemRepository.findByCart_Id(cart.getId());
    }
    //Xoa gio hang
    public void deleteCart(Integer cartItemId) {
        cartItemRepository.deleteByCart_Id(cartItemId);
        cartRepository.deleteById(cartItemId);
    }
}
