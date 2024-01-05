package com.guida.spring.datajpa.model;

import java.sql.Time;

public class ReservationQueryParam {
    
    

private Integer user_id;
private Integer table_id;	
private Integer menu_id;
// private String table[];	
private Time reservation_time;	
private Boolean approved;	
private String reservation_day;	
private Integer capacity;	
private String msg;

public Integer getUser_id() {
    return user_id;
}

public void setUser_id(Integer user_id) {
    this.user_id = user_id;
}

public Integer getTable_id() {
    return table_id;
}

public void setTable_id(Integer table_id) {
    this.table_id = table_id;
}

public Integer getMenu_id() {
    return menu_id;
}

public void setMenu_id(Integer menu_id) {
    this.menu_id = menu_id;
}

public Time getReservation_time() {
    return reservation_time;
}

public void setReservation_time(Time reservation_time) {
    this.reservation_time = reservation_time;
}

public Boolean getApproved() {
    return approved;
}

public void setApproved(Boolean approved) {
    this.approved = approved;
}

public String getReservation_day() {
    return reservation_day;
}

public void setReservation_day(String reservation_day) {
    this.reservation_day = reservation_day;
}

public Integer getCapacity() {
    return capacity;
}

public void setCapacity(Integer capacity) {
    this.capacity = capacity;
}

public String getMsg() {
    return msg;
}

public void setMsg(String msg) {
    this.msg = msg;
}

// public String[] getTable() {
//     return table;
// }

// public void setTable(String[] table) {
//     this.table = table;

// }

}
