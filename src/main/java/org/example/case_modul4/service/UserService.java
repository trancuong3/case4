package org.example.case_modul4.service;

import org.example.case_modul4.model.User;
import org.example.case_modul4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<User> getAllUsers() {
        return userRepository.findAll(); // Lấy tất cả người dùng từ cơ sở dữ liệu
    }
    // Phương thức xóa người dùng theo ID
    public void deleteUserById(Integer id) {
        if (userRepository.existsById(Long.valueOf(id))) {
            userRepository.deleteById(Long.valueOf(id)); // Xóa người dùng nếu tồn tại
        } else {
            throw new RuntimeException("User không tồn tại"); // Ném ngoại lệ nếu không tìm thấy
        }
    }




}
