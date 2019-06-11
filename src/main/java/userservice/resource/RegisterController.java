package userservice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import userservice.model.dto.request.RegisterNewUserRequest;
import userservice.service.UserService;

@RestController
@RequestMapping("/internal")
public class RegisterController {

    @Autowired
    private UserService userService;

    @RequestMapping("/register/new")
    public void registerNewUser(@RequestBody RegisterNewUserRequest request){
        this.userService.registerNewUser(request);
    }

}
