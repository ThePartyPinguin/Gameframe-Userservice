package tpp.gameframe.userservice.tests.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import userservice.model.entity.UserData;
import userservice.repository.IUserDao;
import userservice.repository.IUserDaoJpaImpl;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class UserDaoTests {

    @Autowired
    private IUserDao userDao;

    @MockBean
    private IUserDaoJpaImpl userDaoJpa;

    @Before
    public void setup(){
        UserData user = new UserData(1, "testUser", "test@test.nl");

        Mockito.when(userDao.findById(user.getUserId())).thenReturn(Optional.of(user));
        Mockito.when(userDao.findByUserNameOrEmail(user.getUserName(), user.getEmail())).thenReturn(Optional.of(user));
        Mockito.when(userDao.findByUserNameOrEmail("", user.getEmail())).thenReturn(Optional.of(user));
        Mockito.when(userDao.findByUserNameOrEmail(user.getUserName(), "")).thenReturn(Optional.of(user));
    }

    @Test
    public void whenValidId_thenUserShouldBeFound(){
        long id = 1;
        UserData foundUser = this.userDao.findById(id).orElse(null);


        assertThat(foundUser.getUserId()).isEqualTo(id);
    }

    @Test
    public void whenInvalidId_thenUserShouldNotBeFound(){
        long id = 2;
        UserData foundUser = this.userDao.findById(id).orElse(null);


        assertThat(foundUser).isEqualTo(null);
    }

    @Test
    public void whenValidUsername_thenUserShouldBeFound(){
        String username = "testUser";
        String email = "test@test.nl";
        UserData foundUser = this.userDao.findByUserNameOrEmail(username, "").orElse(null);


        assertThat(foundUser.getUserName()).isEqualTo(username);
        assertThat(foundUser.getEmail()).isEqualTo(email);
    }

    @Test
    public void whenValidEmail_thenUserShouldBeFound(){
        String username = "testUser";
        String email = "test@test.nl";
        UserData foundUser = this.userDao.findByUserNameOrEmail("", email).orElse(null);


        assertThat(foundUser.getUserName()).isEqualTo(username);
        assertThat(foundUser.getEmail()).isEqualTo(email);
    }

    @Test
    public void whenValidUsernameAndEmail_thenUserShouldBeFound(){
        String username = "testUser";
        String email = "test@test.nl";
        UserData foundUser = this.userDao.findByUserNameOrEmail(username, email).orElse(null);


        assertThat(foundUser.getUserName()).isEqualTo(username);
        assertThat(foundUser.getEmail()).isEqualTo(email);
    }


}
