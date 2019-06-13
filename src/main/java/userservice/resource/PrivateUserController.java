package userservice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import userservice.model.dto.response.user.FullUserResponse;
import userservice.service.UserService;


@RestController
@RequestMapping("/internal")
public class PrivateUserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "getuser/{userId}")
    public FullUserResponse getFullUserInfo(@PathVariable long userId){

        return this.userService.getFullUserResponse(userId);
    }

    @GetMapping(value = "getUserByUsername/{username}")
    public FullUserResponse getFullUserInfoByUsername(@PathVariable String username){

        return this.userService.getFullUserResponse(username);
    }

}
