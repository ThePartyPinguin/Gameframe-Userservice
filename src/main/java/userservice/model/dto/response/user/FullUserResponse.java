package userservice.model.dto.response.user;

import userservice.model.dto.response.Response;
import userservice.model.entity.UserData;

public class FullUserResponse extends Response {

    private UserData userData;

    public FullUserResponse(int responseCode, String responseMessage, UserData userData) {
        super(responseCode, responseMessage);
        this.userData = userData;
    }

    public FullUserResponse(int responseCode, String responseMessage) {
        super(responseCode, responseMessage);
    }

    public FullUserResponse() {
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }
}
