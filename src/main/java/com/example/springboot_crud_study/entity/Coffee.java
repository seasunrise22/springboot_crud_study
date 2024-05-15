package com.example.springboot_crud_study.entity;

import com.example.springboot_crud_study.dto.CoffeeDto;
import jakarta.persistence.*;

@Entity
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String price;

    public Coffee() {
    }

    public Coffee(Long id, String name, String price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    //    public void patch(Article article) {
    public void patch(CoffeeDto dto) {
        if (dto.getName() != null) {
            this.name = dto.getName();
        }

        if (dto.getPrice() != null) {
            this.price = dto.getPrice();
        }
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
