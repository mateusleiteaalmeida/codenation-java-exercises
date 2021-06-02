package com.challenge.endpoints;

import com.challenge.entity.User;
import com.challenge.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public Optional<User> findById(@PathVariable("userId") Long userId) {
        return this.userService.findById(userId);
    };

    @GetMapping
    public List<User> findByAccelerationNameOrCompanyId(@RequestParam(required = false) String accelerationName, @RequestParam(required = false) Long companyId) {
        if (accelerationName == null) return this.userService.findByCompanyId(companyId);
        return this.userService.findByAccelerationName(accelerationName);
    }
}
