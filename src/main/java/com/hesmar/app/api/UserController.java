package com.hesmar.app.api;

import com.hesmar.app.domain.User;
import com.hesmar.app.dto.request.LoginRequest;
import com.hesmar.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping()
    public ResponseEntity<Void> add(@RequestBody User user) {
        userService.add(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping()
    public ResponseEntity<Void> update(@RequestBody User user) {
        userService.update(user);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping()
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginRequest(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(userService.loginRequest(loginRequest));
    }

}