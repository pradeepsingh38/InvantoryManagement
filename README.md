Tech Stack: Java, Spring Boot, Spring Security, JWT, JPA/Hibernate, MySQL, REST API

🔧 Project Description
The Inventory and Order Management System is a full-stack backend application designed to efficiently handle product inventory, user authentication, and customer orders. Built using Spring Boot, the system follows RESTful architecture and ensures secure access through JWT-based Spring Security.

✨ Key Features
👥 User Management
Register and authenticate users using Spring Security and JWT tokens.

Role-based access control for Admins and Customers.

📦 Inventory Management
Admins can add, update, and delete inventory items.

Each Item has attributes like name, description, price, and quantity.

🛒 Order Processing
Customers can place orders for one or more items.

Orders are saved with timestamp, total price, and list of OrderItem entities.

Users can view their order history, while admins can view all orders.

🔐 Authentication & Security
JWT tokens used for secure API access.

Unauthorized users cannot access protected endpoints.

Passwords are securely encoded using BCrypt.
