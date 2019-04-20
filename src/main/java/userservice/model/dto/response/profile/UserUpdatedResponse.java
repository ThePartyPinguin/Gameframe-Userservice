package userservice.model.dto.response.profile;

import userservice.model.dto.response.Response;
import userservice.model.entity.UserData;

public class UserUpdatedResponse extends Response {

    private boolean userUpdated;
    private UserData userDto;

    public UserUpdatedResponse(int responseCode, String responseMessage, boolean userUpdated, UserData userDto) {
        super(responseCode, responseMessage);
        this.userUpdated = userUpdated;
        this.userDto = userDto;
    }

    public UserUpdatedResponse(int responseCode, String responseMessage) {
        super(responseCode, responseMessage);
    }

    public UserUpdatedResponse() {
    }

    public boolean isUserUpdated() {
        return userUpdated;
    }

    public void setUserUpdated(boolean userUpdated) {
        this.userUpdated = userUpdated;
    }

    public UserData getUserDto() {
        return userDto;
    }

    public void setUserDto(UserData userDto) {
        this.userDto = userDto;
    }
}
