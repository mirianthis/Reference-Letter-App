package gr.hua.dit.referenceLetterApp.controller;

import gr.hua.dit.referenceLetterApp.model.User;
import gr.hua.dit.referenceLetterApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/admin")
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class UserRestController {
    @Autowired
    UserService userService;


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/users")
    public List<User> getAllUsers(Authentication authentication) {

        return userService.findAllUsers();

    }

    @PostMapping(path = "/users")
    public ResponseEntity<User> saveUsers(@RequestBody User newUser,Authentication auth) {
        System.out.println(newUser.getIt()+"  "+auth.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body((userService.saveUser(newUser)));

    }

    //@PreAuthorize("@userSecurity.hasUserIt(authentication,#userIt)")
    @GetMapping("/users/{userIt}")
    public ResponseEntity<User> getUserByIt(@PathVariable("userIt") String userIt, Authentication authentication) {
        System.out.println("Inside getuserbyit method");
        return ResponseEntity.ok().body(userService.findUserByIt(userIt).get());

    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable("userId") String UserId,@RequestBody User newUser) {
        return ResponseEntity.ok().body(userService.updateUser(UserId,newUser));

    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Object> deleteUser(@PathVariable("userId") String UserId) {
        userService.deleteUser(UserId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }



}
