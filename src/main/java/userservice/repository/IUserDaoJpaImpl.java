package userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import userservice.model.entity.UserData;

@Service
public interface IUserDaoJpaImpl extends JpaRepository<UserData, Long>, IUserDao {
}
