package com.example.inventory.controller;

import com.example.inventory.dto.OrderItemDTO;
import com.example.inventory.model.*;
import com.example.inventory.repository.*;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;

    public OrderController(OrderRepository orderRepository,
                           UserRepository userRepository,
                           ItemRepository itemRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
    }

    @PostMapping("/place")
    public Order placeOrder(@RequestParam String username, @RequestBody List<OrderItemDTO> orderItemsDTO) {
        User user = userRepository.findByUsername(username).orElseThrow();

        double total = 0;
        List<OrderItem> orderItems = new ArrayList<>();

        for (OrderItemDTO dto : orderItemsDTO) {
            Item item = itemRepository.findById(dto.getItemId()).orElseThrow();
            OrderItem orderItem = new OrderItem();
            orderItem.setItem(item);
            orderItem.setQuantity(dto.getQuantity());
            orderItems.add(orderItem);
            total += item.getPrice() * dto.getQuantity();
        }

        Order order = new Order(null, user, orderItems, total, LocalDateTime.now());
        return orderRepository.save(order);
    }

    @GetMapping("/my")
    public List<Order> getMyOrders(@RequestParam String username) {
        User user = userRepository.findByUsername(username).orElseThrow();
        return orderRepository.findByUser(user);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
