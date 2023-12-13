package com.guida.spring.datajpa.model;

// import lombok.AllArgsConstructor;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;


// @Getter
// @Setter
// @NoArgsConstructor
// @AllArgsConstructor


public class TableQueryParam {

    private Integer table_number;
    private Integer capacity;
    private String category;
    private boolean available;
    private String status;
    private String img_table;
    private String[] menu; 
    private boolean all;
    private Integer page;
    private Integer limit;



    public Integer getTable_number() {
        return table_number;
    }

    public void setTable_number(Integer table_number) {
        this.table_number = table_number;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImg_table() {
        return img_table;
    }

    public void setImg_table(String img_table) {
        this.img_table = img_table;
    }

    public String[] getMenu() {
        return menu;
    }

    public void setMenu(String[] menu) {
        this.menu = menu;
    }

    public boolean all() {
        return all;
    }
    
    public void setAll(boolean all){
        this.all = all;
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
