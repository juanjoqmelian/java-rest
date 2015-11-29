package com.luxuriem.example.resource;

import com.luxuriem.example.model.User;
import com.luxuriem.example.model.UserRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserResource {

    @Inject
    private UserRepository defaultUserRepository;


    @RequestMapping(method= RequestMethod.GET)
    public @ResponseBody List<User> getUsers() {
        return defaultUserRepository.findAll();
    }

    @RequestMapping(value = "/{email}", method= RequestMethod.GET)
    public @ResponseBody User getUser(@PathVariable(value="email") String email) {
        return defaultUserRepository.findByEmail(email);
    }

    @RequestMapping(method= RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<User> newUser(@RequestBody User user) {
        defaultUserRepository.save(user);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{email}")
                .buildAndExpand(user.getEmail()).toUri());
        return new ResponseEntity<>(user, httpHeaders, HttpStatus.CREATED);
    }
}
