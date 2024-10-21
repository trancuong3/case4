package org.example.case_modul4.service;

import org.example.case_modul4.model.User;
import org.example.case_modul4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository; // Tiêm UserRepository

    @Autowired
    private PasswordEncoder passwordEncoder; // Tiêm PasswordEncoder

    public void registerUser(User user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword())); // Mã hóa mật khẩu
            userRepository.save(user); // Lưu người dùng vào cơ sở dữ liệu
            System.out.println("Người dùng đã được lưu thành công.");
        } catch (Exception e) {
            System.err.println("Lỗi khi lưu người dùng: " + e.getMessage());
        }
    }



}
