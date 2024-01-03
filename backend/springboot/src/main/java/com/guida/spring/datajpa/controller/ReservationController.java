package com.guida.spring.datajpa.controller;

import com.guida.spring.datajpa.model.Reservations;
import com.guida.spring.datajpa.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ReservationController {

    @Autowired
    ReservationRepository reservationRepository;

    @GetMapping("/reservations")
    public ResponseEntity<List<Reservations>> getAllReservations() {
        try {
            List<Reservations> reservations = reservationRepository.findAll();
            return new ResponseEntity<>(reservations, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/reservations/{id}")
    public ResponseEntity<Reservations> getReservationById(@PathVariable("id") long id) {
        try {
            Reservations reservation = reservationRepository.findById(id).get();
            return new ResponseEntity<>(reservation, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @PostMapping("/reservations")
    // public ResponseEntity<Reservations> createReservation(@RequestBody Reservations reservation) {
    //     try {
    //         Reservations _reservation = reservationRepository
    //                 .save(new Reservations(reservation.getReservationId(), reservation.getReservationDate(), reservation.getReservationTime(), reservation.getReservationPartySize(), reservation.getReservationStatus(), reservation.getReservationName(), reservation.getReservationEmail(), reservation.getReservationPhone(), reservation.getReservationNotes()));
    //         return new ResponseEntity<>(_reservation, HttpStatus.CREATED);
    //     } catch (Exception e) {
    //         return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }

}
