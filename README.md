# 🏡 RentEase – A Smart Property Rental Platform

**RentEase** is a powerful backend application built using **Spring Boot** that simplifies the process of renting properties. It provides a seamless interface for landlords to list properties, tenants to explore them, and for both parties to manage bookings securely and efficiently.

---

## 🚀 Tech Stack

- 🧠 **Java 17**
- ⚙️ **Spring Boot (MVC + JPA)**
- 🐘 **PostgreSQL**
- 🔄 **Lombok**
- 📦 **Maven**
- 🧪 **Postman** for API Testing

---

## ✨ Key Features

### ✅ 1. Landlord & Tenant Registration  
- Register new landlords and tenants via dedicated RESTful endpoints  
- View, update, or delete existing user accounts securely  
- Ensure unique identification and validation during onboarding  
- Manage user-related data with clean separation between roles  

---

### 🏠 2. Property Listing & Management  
- Landlords can add properties with details like location, rent, description  
- Update or delete listings dynamically through HTTP PUT and DELETE  
- View all listed properties or filter by specific ID  
- Each property is linked with a specific landlord for accountability  

---

### 🔍 3. Property Search by Tenants  
- Tenants can fetch all available rental properties  
- Search and filter properties based on criteria such as location or rent  
- View detailed information of a single property by its ID  
- Enables informed decision-making for tenants before booking  

---

### 📅 4. Booking System  
- Book properties by providing tenant and property information  
- Prevent duplicate or conflicting bookings via validations  
- Fetch booking history using booking ID or list all bookings  
- Supports full update and delete capabilities for scheduled bookings  

---

### 🔁 5. Real-Time Data Updates  
- Modify landlord, tenant, property, or booking information on the fly  
- Ensure consistency and persistence with Spring Data JPA  
- Returns updated objects after modification for frontend sync  
- Improves user experience by reducing stale data risks  

---

### 🗑️ 6. Safe Deletion with Cascade Checks  
- Deleting a landlord or tenant handles related records appropriately  
- Prevents orphan data in database using mapped relations  
- Ensures bookings or properties tied to deleted users are handled cleanly  
- Maintains referential integrity in all operations  

---

### 📡 7. RESTful APIs Ready for Integration  
- Designed to support frontend integration with clear JSON contracts  
- Easy to consume from React, Angular, or mobile clients  
- API endpoints return meaningful responses for every operation  
- Fully tested via Postman collections for robustness  

Developed By:-
Sauvir Wodehra(sauvirwodehras3136@gmail.com)
