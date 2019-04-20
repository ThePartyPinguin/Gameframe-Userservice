package userservice.service;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import userservice.model.dto.request.RegisterNewUserRequest;
import userservice.model.dto.response.profile.UserUpdatedResponse;
import userservice.model.dto.response.user.FullUserResponse;
import userservice.model.entity.UserData;
import userservice.repository.IUserDao;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private IUserDao userDao;

    public void registerNewUser(RegisterNewUserRequest request){



        this.userDao.save(new UserData(request.getUserId(), request.getUserName(), request.getEmail()));
    }


    public FullUserResponse getFullUserResponse(long userId){

        Optional<UserData> data = this.userDao.findById(userId);

        if(!data.isPresent())
            return new FullUserResponse(404, "This user does not exist");

        UserData userData = data.get();

        return new FullUserResponse(200, "User found", userData);
    }

    public UserUpdatedResponse updateUser(UserData userData){

        Optional<UserData> data = this.userDao.findById(userData.getUserId());

        if(!data.isPresent()){
            return new UserUpdatedResponse(404, "User does not exist");
        }

        UserData updatedUserData = this.userDao.save(userData);

        return new UserUpdatedResponse(500, "User updated", true, updatedUserData);
    }

}
