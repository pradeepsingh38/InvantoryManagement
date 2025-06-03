package com.example.inventory.model;


import jakarta.persistence.*;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Item item;

    private int quantity;

    public Long getId() { return id; }
    public Item getItem() { return item; }
    public int getQuantity() { return quantity; }

    public void setId(Long id) { this.id = id; }
    public void setItem(Item item) { this.item = item; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
