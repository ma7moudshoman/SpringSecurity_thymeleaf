package registerlogin.login.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import registerlogin.login.Entity.UserRegistrationDto;
import registerlogin.login.Model.Role;
import registerlogin.login.Model.User;
import registerlogin.login.Repo.UserRepo;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl  implements UserService{


  private   UserRepo userRepo;
@Autowired
private BCryptPasswordEncoder passwordEncoder;
public UserServiceImpl(UserRepo userRepo){
    super();
    this.userRepo=userRepo;
}
    public User save(UserRegistrationDto userRegistrationDto){
        User user=new User (userRegistrationDto.getFirstname(), userRegistrationDto.getLastname(),
                userRegistrationDto.getEmail()
                , passwordEncoder.encode( userRegistrationDto.getPassword())
                , Arrays.asList(new Role("ROLE_USER")));
        return userRepo.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepo.findByEmail(username);
    if (user== null){
        throw  new UsernameNotFoundException("invalid username or password  ");
    }
    return new  org.springframework.security.core.userdetails.User(user.getEmail() , user.getPassword(),null);
    }
    private Collection<? extends GrantedAuthority>mapRolesToAuthorities(Collection<Role> roles){

return  roles.stream().map(role ->new  SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());


    }
}

