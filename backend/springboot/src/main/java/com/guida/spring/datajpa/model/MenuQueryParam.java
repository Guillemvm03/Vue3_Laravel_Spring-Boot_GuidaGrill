package com.guida.spring.datajpa.model;

public class MenuQueryParam {
    private String type;
    private String img_Menu;
    private String start_time;
    private String end_time;
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

        public String getStart_time() {
        return start_time;
    }   

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time){
        this.end_time = end_time;
    }

    
}
