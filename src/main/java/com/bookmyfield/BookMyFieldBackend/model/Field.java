package com.bookmyfield.BookMyFieldBackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "fields")
public class Field {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private String description;
    private String timings;
    private double price;
    private String category;
    private String image;
    
    @Enumerated(EnumType.STRING)
    private FieldStatus status = FieldStatus.PENDING;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    // Constructor
    public Field(String name, String location, String description, String timings, double price, String category, String image, User owner) {
        this.name = name;
        this.location = location;
        this.description = description;
        this.timings = timings;
        this.price = price;
        this.category = category;
        this.image = image;
        this.status = FieldStatus.PENDING;
        this.owner = owner;
    }

    // Getters and Setters (Explicit)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTimings() {
        return timings;
    }

    public void setTimings(String timings) {
        this.timings = timings;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public FieldStatus getStatus() {
        return status;
    }

    public void setStatus(FieldStatus status) {
        this.status = status;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
