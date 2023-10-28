package registerlogin.login.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import registerlogin.login.Entity.UserRegistrationDto;
import registerlogin.login.Repo.UserRepo;

@Service
public interface UserService extends UserDetailsService {
}
