package com.guida.spring.datajpa.model;

import jakarta.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "reservations")
public class Reservations {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "table_id", nullable = false)
    private Tables table;

    @ManyToOne
    @JoinColumn(name = "menu_id", nullable = false)
    private Menu menu;

    @Column(name = "reservation_time")
    private Time reservationTime;

    @Column(name = "approved")
    private boolean approved;

    @Column(name = "reservation_day")
    private String reservationDay;

    // @Column(name = "created_at")
    // private Timestamp createdAt;

    // @Column(name = "updated_at")
    // private Timestamp updatedAt;

    public Reservations() {
    }

    public Reservations(User user, Tables table, Menu menu, Time reservationTime, boolean approved, String reservationDay) {
        this.user = user;
        this.table = table;
        this.menu = menu;
        this.reservationTime = reservationTime;
        this.approved = approved;
        this.reservationDay = reservationDay;
    }

    // Getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Tables getTable() {
        return table;
    }

    public void setTable(Tables table) {
        this.table = table;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Time getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(Time reservationTime) {
        this.reservationTime = reservationTime;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public String getReservationDay() {
        return reservationDay;
    }

    public void setReservationDay(String reservationDay) {
        this.reservationDay = reservationDay;
    }

    @Override
    public String toString() {
        return "Reservations{" +
                "id=" + id +
                ", user=" + user +
                ", table=" + table +
                ", menu=" + menu +
                ", reservationTime=" + reservationTime +
                ", approved=" + approved +
                ", reservationDay='" + reservationDay + '\'' +
                // ", createdAt=" + createdAt +
                // ", updatedAt=" + updatedAt +
                '}';
    }
}
