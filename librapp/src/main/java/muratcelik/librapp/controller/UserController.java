package muratcelik.librapp.controller;

import lombok.RequiredArgsConstructor;
import muratcelik.librapp.entity.User;
import muratcelik.librapp.service.implementation.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

/**
 * @author Murat Çelik
 */
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //GetAll
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<Collection<User>> getAllUser() {  //Collection
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }

    //GetById
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<User>> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    //Add
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<String> addUser(@RequestBody User user) {
        userService.addUser(user);
        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }

    //Delete
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    //Update
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id) {
        user.setId(id);
        userService.updateUser(user);
        return ResponseEntity.noContent().build();
    }

//    //FindBy
//    @RequestMapping(value = "/user/{userName}", method = RequestMethod.GET)
//    public User findUserByName(@PathVariable String userName) {
//        return userService.findUserByName(userName);
//    }

}
