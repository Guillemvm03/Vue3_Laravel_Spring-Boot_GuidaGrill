package com.guida.spring.datajpa.model;


public class MealsQueryParam{
 
private Integer id_menu;
private String name;
private Float price;
private Integer quantity;
private String description;
private String img_meal;
private Integer page;
public Integer limit; 


public Integer getId_menu() {
    return id_menu;
}

public void setId_menu(Integer id_menu) {
    this.id_menu = id_menu;
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

public Integer getPage() {
    return page;
}

public void setPage(Integer page) {
    this.page = page;
}

public Integer getLimit() {
    return limit;
}

public void setLimit(Integer limit) {
    this.limit = limit;
}

}