package com.platzi.springboot.fundamentos.fundamentos.controller;

import com.platzi.springboot.fundamentos.fundamentos.entity.User;
import com.platzi.springboot.fundamentos.fundamentos.repository.UserRepository;
import com.platzi.springboot.fundamentos.fundamentos.usecase.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private GetUser getUser;
    private CreateUser createUser;
    private DeleteUser deleteUser;
    private UpdateUser updateUser;
    private GetPaginateUser getPaginateUser;

    public UserRestController(GetUser getUser, CreateUser createUser, DeleteUser deleteUser, UpdateUser updateUser, GetPaginateUser getPaginateUser) {
        this.getUser = getUser;
        this.createUser = createUser;
        this.deleteUser = deleteUser;
        this.updateUser = updateUser;
        this.getPaginateUser = getPaginateUser;
    }

    @GetMapping("")
    List<User> get() {
        return getUser.getAll();
    }

    @PostMapping("")
    ResponseEntity<User> newUser(@RequestBody User newUser) {
        return new ResponseEntity<>(createUser.save(newUser), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    ResponseEntity deleteUser(@PathVariable Long id) {
        deleteUser.remove(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    ResponseEntity<User> replaceUser(@RequestBody User newUser, @PathVariable Long id) {
        return updateUser.update(id, newUser)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.noContent().build());
    }

    /*
    @GetMapping("/pageable")
    List<User> getUserPageable(@RequestParam int page, @RequestParam int size) {
        return getPaginateUser.getPaginateUser(PageRequest.of(page, size));
    }
     */
    @GetMapping("/pageable")
    List<User> getUserPageable(Pageable pageable) {
        return getPaginateUser.getPaginateUser(pageable);
    }

}
