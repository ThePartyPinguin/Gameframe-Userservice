package userservice.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class UserData {

    @Id
    @Column(name = "USER_ID", nullable = false)
    private long userId;

    @Column(name = "USER_USERNAME", nullable = false)
    private String userName;

    @Column(name = "USER_FULLNAME")
    private String fullName;

    @Column(name = "USER_EMAIL", nullable = false)
    private String email;

    public UserData(long userId, String userName, String email) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
    }

    public UserData() {
    }

    public long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
