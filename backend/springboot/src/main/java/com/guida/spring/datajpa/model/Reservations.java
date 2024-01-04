package com.guida.spring.datajpa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
// import com.springboot.spring.model.Turns;
// import com.springboot.spring.model.User;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reservations")
public class Reservations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "table_id")
    private Long table_id;

    @Column(name = "menu_id")
    private Long menu_id;

    @Column(name = "reservation_time")
    private String reservationTime;

    @Column(name = "approved")
    private boolean approved;

    @Column(name = "reservation_day")
    private String reservationDay;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "msg")
    private String msg;

}