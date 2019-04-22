package userservice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import userservice.model.dto.response.profile.UserUpdatedResponse;
import userservice.model.entity.UserData;
import userservice.service.UserService;

@RestController
@RequestMapping("/internal")
public class UpdateUserController {

    @Autowired
    private UserService userService;

    @PutMapping(value = "/update")
    public UserUpdatedResponse updateUser(@RequestBody UserData userData){
        return this.userService.updateUser(userData);
    }


}
