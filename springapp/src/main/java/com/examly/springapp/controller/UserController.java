package com.examly.springapp.controller;
import com.examly.springapp.model.User;
import com.examly.springapp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService service;
    public UserController(UserService service) { this.service = service; }
    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return new ResponseEntity<>(service.addUser(user), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(service.getAllUsers(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getUserById(id), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        return new ResponseEntity<>(service.updateUser(id, user), HttpStatus.OK);
    }
}
