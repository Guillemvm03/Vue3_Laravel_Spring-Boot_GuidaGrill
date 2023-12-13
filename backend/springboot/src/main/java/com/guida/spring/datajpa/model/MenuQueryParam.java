package com.guida.spring.datajpa.model;

public class MenuQueryParam {
    private String type;
    private String img_Menu;
    private String[] meals;
    private Integer page;
    private Integer limit;

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

    public String[] getMeals() {
        return meals;
    }

    public void setMeals(String[] meals) {
        this.meals = meals;
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
