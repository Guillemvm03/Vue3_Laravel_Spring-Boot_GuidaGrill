package com.guida.spring.datajpa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.guida.spring.datajpa.model.Reservations;
import com.guida.spring.datajpa.model.User;
import com.guida.spring.datajpa.repository.ReservationRepository;
import com.guida.spring.datajpa.repository.UserRepository;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ReservationController {
    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    UserRepository UserRepository;

    @GetMapping("/reservations")
    public ResponseEntity<List<Reservations>> getAllReservations(@RequestParam(required = false) String title) {
        try {
            List<Reservations> reservations = new ArrayList<Reservations>();
        
            reservationRepository.findAll().forEach(reservations::add);            

            return new ResponseEntity<>(reservations, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/reservations/{id}")
    public ResponseEntity<Reservations> getReservationById(@PathVariable("id") long id) {
        Optional<Reservations> ReservationData = reservationRepository.findById(id);

        if (ReservationData.isPresent()) {
            return new ResponseEntity<>(ReservationData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/reservations")
    public ResponseEntity<Reservations> createReservation(@RequestBody Reservations reservation, HttpServletRequest request) {
        try {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                    .getPrincipal();
            User user = UserRepository.findByUsername(userDetails.getUsername()).get();

            Reservations _reservation = reservationRepository
                    .save(new Reservations(reservation.getId(), user.getId(), reservation.getTable_id(), reservation.getMenu_id(), reservation.getReservationTime(), reservation.isApproved(), reservation.getReservationDay(), reservation.getCapacity(), reservation.getMsg()));
            
            return new ResponseEntity<>(_reservation, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}