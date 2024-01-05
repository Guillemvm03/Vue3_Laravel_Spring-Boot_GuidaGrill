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
import org.springframework.web.bind.annotation.DeleteMapping;
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

    @GetMapping("/reservations/table/{id}")
    public ResponseEntity<List<Reservations>> getReservationByTableId(@PathVariable("id") long id) {
        try {
            List<Reservations> reservations = reservationRepository.findByTableId(id);
            return new ResponseEntity<>(reservations, HttpStatus.OK);
    
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/reservations/user")
    public ResponseEntity<List<Reservations>> getReservationByUserId() {
        try {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                    .getPrincipal();
    
            User user = UserRepository.findByUsername(userDetails.getUsername()).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    
            System.out.println(user.getId());
            List<Reservations> reservations = reservationRepository.findByUserId(user.getId());
            return new ResponseEntity<>(reservations, HttpStatus.OK);
    
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
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


    @DeleteMapping("/reservations/{id}")
    public ResponseEntity<HttpStatus> deleteReservation(@PathVariable("id") long id) {
        try {
            reservationRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @PutMapping("/reservations/{id}")
    public ResponseEntity<Reservations> updateReservation(@PathVariable("id") long id, @RequestBody Reservations reservation) {
        Optional<Reservations> ReservationData = reservationRepository.findById(id);

        if (ReservationData.isPresent()) {
            Reservations _reservation = ReservationData.get();
            // _reservation.setUserId(reservation.getUserId());
            // _reservation.setTableId(reservation.getTableId());
            // _reservation.setMenuId(reservation.getMenuId());
            _reservation.setReservationTime(reservation.getReservationTime());
            _reservation.setApproved(reservation.isApproved());
            _reservation.setReservationDay(reservation.getReservationDay());
            _reservation.setCapacity(reservation.getCapacity());
            _reservation.setMsg(reservation.getMsg());
            return new ResponseEntity<>(reservationRepository.save(_reservation), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

