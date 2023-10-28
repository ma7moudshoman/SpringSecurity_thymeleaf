package registerlogin.login.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import registerlogin.login.Entity.UserRegistrationDto;
import registerlogin.login.Service.UserService;
import registerlogin.login.Service.UserServiceImpl;

@Controller

@RequestMapping("/registration")
public class UserRegistrationController {

private UserServiceImpl userService;
public  UserRegistrationController(UserServiceImpl userService){
    this.userService=userService;
}
@GetMapping("/")
public  String showRegistrationForm(){
    return "registration";
}
    //Get       http://localhost:6060/userAccount
@PostMapping("/userAccount")
public String registerUserAccount(@ModelAttribute ("user") UserRegistrationDto userRegistrationDto ){
    userService.save(userRegistrationDto);
    return "redirect:/registration?success ";
}

}
