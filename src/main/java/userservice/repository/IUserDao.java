package userservice.repository;

import userservice.model.entity.UserData;

import java.util.Optional;

public interface IUserDao {

    UserData save(UserData userData);
    Optional<UserData> findById(long id);
    Optional<UserData> findByUserNameOrEmail(String userName, String email);

}
