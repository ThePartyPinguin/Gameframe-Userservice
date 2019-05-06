package userservice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import userservice.model.dto.response.user.FullUserResponse;
import userservice.service.UserService;

import java.util.Date;

@RestController
@RequestMapping("/internal")
public class PrivateUserController {

    @Autowired
    private UserService userService;


//    @GetMapping(value = "get/{userId}")
//    public FullUserResponse getFullUserInfo(@RequestHeader("X-user-id") String userIdHeader, @PathVariable long userId){
//
//        long tempId = Long.parseLong(userIdHeader);
//
//        if(tempId != userId)
//            return new FullUserResponse(401, "User credentials not correct");
//
//        return this.userService.getFullUserResponse(userId);
//    }

    @GetMapping(value = "getuser/{userId}")
    public FullUserResponse getFullUserInfo(@PathVariable long userId){

        return this.userService.getFullUserResponse(userId);
    }

    @GetMapping(value = "getUserByUsername/{username}")
    public FullUserResponse getFullUserInfoByUsername(@PathVariable String username){

        return this.userService.getFullUserResponse(username);
    }

}
