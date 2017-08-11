package hu.helixlab.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Admin on 2017.08.09..
 */
@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    Iterable<User> getAllUser(){
        return userService.findAll();
    }

    @RequestMapping( path ="/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    User getUserById(@PathVariable int id){
        return userService.findUserById(id);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    User getUserById(@RequestBody User user){
        return userService.createUser(user);
    }

    @RequestMapping(path ="/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    User updateUserById(@PathVariable int id, @RequestBody User user){
        return userService.updateUserById(id,user);
    }

    @RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteUserById(@PathVariable int id){
        userService.deleteUserById(id);
    }
}
