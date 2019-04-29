package org.findem.findem.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.concurrent.Future;

@RestController
@RequestMapping(value = "/user", produces = "application/json")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity get(@RequestParam String email) {
    	Future<User> user = userRepository.findUserByUsername(email);
    	
    	try {
    		user.get().getName();
            return ResponseEntity.status(HttpStatus.OK).body(user.get());
    	}
    	catch(Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    	}
    }

    @RequestMapping(method = RequestMethod.POST)
    public void post(@RequestBody User user) {
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void put(@RequestBody User user) {
    }
}