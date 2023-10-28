package registerlogin.login.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import registerlogin.login.Model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

User findByEmail(String email);
}
