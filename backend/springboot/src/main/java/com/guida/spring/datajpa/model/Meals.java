package com.guida.spring.datajpa.model;

import jakarta.persistence.*;


@Entity
@Table(name = "meals")
public class Meals {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_menu")
    private Menu menu;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Float price;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "description")
    private String description;

    @Column(name = "img_meal")
    private String img_meal;

    public Meals() {

    }

    public Meals(Menu menu, String name, Float price, Integer quantity, String description, String img_meal) {
        this.menu = menu;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.img_meal = img_meal;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
    	return name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }

    public Float getPrice() {
    	return price;
    }

    public void setPrice(Float price) {
    	this.price = price;
    }

    public Integer getQuantity() {
    	return quantity;
    }

    public void setQuantity(Integer quantity) {
    	this.quantity = quantity;
    }

    public String getDescription() {
    	return description;
    }

    public void setDescription(String description) {
    	this.description = description;
    }

    public String getImg_meal() {
    	return img_meal;
    }

    public void setImg_meal(String img_meal) {
    	this.img_meal = img_meal;
    }

    
    @Override
    public String toString() {
        return "Meals [id=" + id +
                ", name=" + name +
                ", price=" + price +
                ", quantity=" + quantity +
                ", description=" + description +
                ", img_meal=" + img_meal + "]";
    }
}

