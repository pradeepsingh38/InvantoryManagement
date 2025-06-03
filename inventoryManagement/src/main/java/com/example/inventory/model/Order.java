package com.example.inventory.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> items;

    private double totalPrice;

    private LocalDateTime timestamp;

    // No-args constructor
    public Order() {}

    // Required constructor
    public Order(Long id, User user, List<OrderItem> items, double totalPrice, LocalDateTime timestamp) {
        this.id = id;
        this.user = user;
        this.items = items;
        this.totalPrice = totalPrice;
        this.timestamp = timestamp;
    }

    // Getters and setters
    public Long getId() { return id; }
    public User getUser() { return user; }
    public List<OrderItem> getItems() { return items; }
    public double getTotalPrice() { return totalPrice; }
    public LocalDateTime getTimestamp() { return timestamp; }

    public void setId(Long id) { this.id = id; }
    public void setUser(User user) { this.user = user; }
    public void setItems(List<OrderItem> items) { this.items = items; }
    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}

