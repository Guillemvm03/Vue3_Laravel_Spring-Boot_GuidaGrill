package com.guida.spring.datajpa.model;

import java.util.Set;

import jakarta.persistence.*;


@Entity
@Table(name = "menu")

public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "type")
    private String type;

    @Column(name = "img_Menu")
    private String img_Menu;

    @Column(name="start_time")
    private String start_time;

    @Column(name="end_time")
    private String end_time;

    @OneToMany(mappedBy = "menu") 
    private Set<Meals> meals;

    @ManyToMany
    @JoinTable(
      name = "tables_menu",  
      joinColumns = @JoinColumn(name = "menus_id"), 
      inverseJoinColumns = @JoinColumn(name = "tables_id")) 
    private Set<Tables> tables;

    public Menu() {

    }

    public Menu(String type, String img_Menu) {
        this.type = type;
        this.img_Menu = img_Menu;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImg_Menu() {
        return img_Menu;
    }

    public void setImg_Menu(String img_Menu) {
        this.img_Menu = img_Menu;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time){
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time){
        this.end_time = end_time;
    }

    public Set<Meals> getMeals() {
        return meals;
    }

    public void setMeals(Set<Meals> meals) {
        this.meals = meals;
    }



    @Override
    public String toString() {
        return "Menu [id=" + id + 
        ", type=" + type + 
        ", img_Menu=" + img_Menu + 
        ", meals=" + meals +
        ", start_time=" + start_time +
        ", end_time=" + end_time +
				"]";
    }
}