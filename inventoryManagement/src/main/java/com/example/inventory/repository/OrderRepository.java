package com.example.inventory.repository;

import com.example.inventory.model.Order;
import com.example.inventory.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
}