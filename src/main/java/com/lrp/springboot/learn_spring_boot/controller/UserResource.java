package com.lrp.springboot.learn_spring_boot.controller;

import com.lrp.springboot.learn_spring_boot.dao.UserDaoService;
import com.lrp.springboot.learn_spring_boot.model.User;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    private final UserDaoService userService;

    public UserResource(UserDaoService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userService.retrieveAllUser();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable Integer id) {
        return userService.retrieveUser(id);
    }

    @GetMapping("/users/hateoas/{id}")
    public EntityModel<User> retrieveUserWithHateoas(@PathVariable Integer id) {
        User user = userService.retrieveUser(id);
        EntityModel<User> entityModel = EntityModel.of(user);

        //To not hardcode the link. Get the link based on specific method
        WebMvcLinkBuilder link = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
        User newUser = userService.addUser(user);

        //Will create URI:  http://localhost:8080/users/{id}
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newUser.getId())
                .toUri();

        //will return 201 (created) with the User Response.
        return ResponseEntity
                .created(location)
                .body(newUser);

        //To return status only without response
//        return ResponseEntity
//                .created(location)
//                .build();


    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }


    /**
     * Delete user, but returns the deleted user info.
     */
    @DeleteMapping("/users/info/{id}")
    public ResponseEntity<User> deleteUserWithInfo(@PathVariable Integer id) {
        User user = userService.deleteUserWithInfo(id);
        return ResponseEntity
                .accepted()
                .body(user);
    }
}
