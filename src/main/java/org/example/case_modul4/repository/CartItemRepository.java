package org.example.case_modul4.repository;

import org.example.case_modul4.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    List<CartItem> findByCart_Id(Integer id);
    void deleteByCart_Id(Integer id);
}
