package com.example.springboot_crud_study.dto;

import com.example.springboot_crud_study.entity.Coffee;

public class CoffeeDto {
    private Long id;
    private String name;
    private String price;

    public CoffeeDto(Long id, String name, String price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Coffee toEntity() {
        return new Coffee(id, name, price);
    }

    /*public void setId(Long id) {
        this.id = id;
    }*/

    /*public Long getId() {
        return id;
    }*/

    /*@Override
    public String toString() {
        return "ArticleForm{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }*/

    @Override
    public String toString() {
        return "CoffeeDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
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
}
