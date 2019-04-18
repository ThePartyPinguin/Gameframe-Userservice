package userservice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import userservice.model.dto.response.user.FullUserResponse;
import userservice.service.UserService;

import java.util.Date;

@RestController
@RequestMapping("/private")
public class PrivateUserController {

    @Autowired
    private UserService userService;


    @GetMapping(value = "/{userId}")
    public FullUserResponse getFullUserInfo(@RequestHeader("X-user-id") String userIdHeader, @PathVariable long userId){

        long tempId = Long.parseLong(userIdHeader);

        if(tempId != userId)
            return new FullUserResponse(401, "User credentials not correct");

        return this.userService.getFullUserResponse(userId);
    }

}
