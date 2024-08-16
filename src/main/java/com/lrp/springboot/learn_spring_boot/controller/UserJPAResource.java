package com.lrp.springboot.learn_spring_boot.controller;

import com.lrp.springboot.learn_spring_boot.exception.UserNotFoundException;
import com.lrp.springboot.learn_spring_boot.model.Post;
import com.lrp.springboot.learn_spring_boot.model.User;
import com.lrp.springboot.learn_spring_boot.repository.jpa.PostRepository;
import com.lrp.springboot.learn_spring_boot.repository.jpa.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

/**
 * We're creating new controller as this is a sample project only and to still have Controller without DB connection.
 */
@RestController
@RequiredArgsConstructor
public class UserJPAResource {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public Optional<User> retrieveUser(@PathVariable Integer id) {
        return userRepository.findById(id);
    }

    @GetMapping("/jpa/users/hateoas/{id}")
    public EntityModel<User> retrieveUserWithHateoas(@PathVariable Integer id) {
        Optional<User> user = userRepository.findById(id);
        EntityModel<User> entityModel = EntityModel.of(user.get());

        //To not hardcode the link. Get the link based on specific method
        WebMvcLinkBuilder link = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
        User newUser = userRepository.save(user);

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

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userRepository.deleteById(id);
    }


    /**
     * Delete user, but returns the deleted user info.
     */
    @DeleteMapping("/jpa/users/info/{id}")
    public ResponseEntity<User> deleteUserWithInfo(@PathVariable Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
        userRepository.deleteById(id);

        return ResponseEntity
                .accepted()
                .body(user.get());
    }

    @GetMapping ("/jpa/user/{id}/posts")
    public List<Post> retrievePostByUser(@PathVariable int id) {

        List<Post> posts = userRepository.findById(id)
                .map(User::getPost)
                .get();

        if (posts.isEmpty()) {
            throw new UserNotFoundException("Empty Post for user: " + id);
        }

        return posts;
    }

    @PostMapping ("/jpa/user/{userId}/posts")
    public ResponseEntity<Post> postMessage (@PathVariable int userId, @Valid @RequestBody Post post) {
        Optional<User> user = userRepository.findById(userId);
        post.setUser(user.get());

        Post newPostByUser = postRepository.save(post);

        //Will create URI:  http://localhost:8080/jpa/user/{userId}/posts/{postsId}
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{postId}")
                .buildAndExpand(newPostByUser.getId())
                .toUri();

        //will return 201 (created) with the User Response.
        return ResponseEntity
                .created(location) //means 201 status
                .body(newPostByUser);

    }
}
