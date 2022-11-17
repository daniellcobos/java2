package snowcastervz.patterns.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import snowcastervz.patterns.model.AppUser;
import snowcastervz.patterns.services.UserService;


@RestController
@RequestMapping("/api")
public class UserRestController {

    private UserService userService;

    @Autowired
    public UserRestController(UserService theUserService) {
        userService = theUserService;
    }

    // expose "/users" and return list of users
    @GetMapping("/users")
    public List<AppUser> findAll() {
        return userService.findAll();
    }

    // add mapping for GET /users/{userId}

    @GetMapping("/users/{userId}")
    public AppUser getUser(@PathVariable int userId) {

        AppUser theAppUser = userService.findById(userId);

        if (theAppUser == null) {
            throw new RuntimeException("User id not found - " + userId);
        }

        return theAppUser;
    }

    // add mapping for POST /users - add new user

    @PostMapping("/users")
    public AppUser addUser(@RequestBody AppUser theAppUser) {

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update



        userService.save(theAppUser);

        return theAppUser;
    }

    // add mapping for PUT /users - update existing user

    @PutMapping("/users")
    public AppUser updateUser(@RequestBody AppUser theAppUser) {

        userService.save(theAppUser);

        return theAppUser;
    }

    // add mapping for DELETE /users/{userId} - delete user

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable int userId) {

        AppUser tempAppUser = userService.findById(userId);

        // throw exception if null

        if (tempAppUser == null) {
            throw new RuntimeException("User id not found - " + userId);
        }

        userService.deleteById(userId);

        return "Deleted user id - " + userId;
    }

}
