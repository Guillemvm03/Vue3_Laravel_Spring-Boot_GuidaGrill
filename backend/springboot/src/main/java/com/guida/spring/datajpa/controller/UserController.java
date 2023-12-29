package com.guida.spring.datajpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.guida.spring.datajpa.model.User;
import com.guida.spring.datajpa.model.UserAndToken;
import com.guida.spring.datajpa.repository.UserRepository;
import com.guida.spring.datajpa.security.jwt.JwtUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;


// import jartaka.persistence;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;


    @GetMapping("/profile")
    public ResponseEntity<User> profile() {
                // return "hola";
        try {
          
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                    .getPrincipal();
                    //   System.out.println(userDetails);
            User user = userRepository.findByUsername(userDetails.getUsername()).get();
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            System.err.println(e);
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }



    @PostMapping("/login")
    public ResponseEntity<UserAndToken> loginUser(@RequestBody User user) {
        try {
            System.out.println(user.getUsername());
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtUtils.generateJwtToken(authentication);
            User user_ = userRepository.findByUsername(user.getUsername()).get();
            UserAndToken userToken = new UserAndToken(jwt, user_);

            return new ResponseEntity<>(userToken, HttpStatus.OK);

        } catch (Exception e) {
            System.err.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        try {
           

            if (userRepository.existsByUsername(user.getUsername()) > 0) {
                System.out.println("username exists");
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            } else if (userRepository.existsByEmail(user.getEmail()) > 0) {
                System.out.println("email exists");
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            } else {
                user.setType("client");
                user.setIs_active(true);
                user.setPassword(encoder.encode(user.getPassword()));
                User _user = userRepository.save(user);

                 System.out.println(_user);
                return new ResponseEntity<>(_user, HttpStatus.CREATED);
            }

            // return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
}

@PostMapping("/logout")
public ResponseEntity<?> logoutUser() {
    try {
        return new ResponseEntity<>(HttpStatus.OK);

    } catch (Exception e) {
        System.err.println(e);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

}