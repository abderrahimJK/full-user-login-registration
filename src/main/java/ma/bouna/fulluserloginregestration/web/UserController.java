package ma.bouna.fulluserloginregestration.web;

import lombok.var;
import ma.bouna.fulluserloginregestration.entities.User;
import ma.bouna.fulluserloginregestration.exceptions.NotFoundException;
import ma.bouna.fulluserloginregestration.exceptions.UserAlreadyExist;
import ma.bouna.fulluserloginregestration.record.UserRegistration;
import ma.bouna.fulluserloginregestration.service.UserServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class UserController {

    private final UserServiceImp userServiceImp;

    public UserController(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @GetMapping("user/{id}")
    public ResponseEntity<?> user(@PathVariable Long id){
        try{
            User user = userServiceImp.getUser(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error: Projet "+ id +" Not Found!");
        }
    }

    public ResponseEntity<?>  userRegistration(UserRegistration request) throws UserAlreadyExist {

        Optional<User> user = userServiceImp.getUserByMail(request.email());
        if(!user.isPresent()){
            return ResponseEntity.badRequest().body("User with email "+request.email()+"already exist");
        }
        var newUser = User.builder()
                        .firstName(request.firstName())
                        .lastName(request.lastName())
                        .email(request.email())
                        .password(request.password())
                        .role(request.role())
                        .build();

        return new ResponseEntity<>(userServiceImp.addUser(newUser), HttpStatus.CREATED);

    }
}
