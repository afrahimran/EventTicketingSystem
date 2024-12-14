package TicketingSystem.Service;

import TicketingSystem.DTOS.SignupRequestDTOS;
import TicketingSystem.DTOS.UserDTOS;
import TicketingSystem.Entity.User;
import TicketingSystem.Enums.UserRole;
import TicketingSystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImp implements AuthService{

    @Autowired
    private UserRepository userRepository;

    // registers a new client based on the provided signup request details
    public UserDTOS signupClient(SignupRequestDTOS signupRequestDTOS) {
        User user = new User();

        user.setName(signupRequestDTOS.getName());
        user.setLastname(signupRequestDTOS.getLastname());
        user.setEmail(signupRequestDTOS.getEmail());
        user.setPhone(signupRequestDTOS.getPhone());
        user.setPassword(signupRequestDTOS.getPassword());
        user.setRole(UserRole.CLIENT);

        return userRepository.save(user).getDto();
    }

    // Checks if a user with the given email already exists
    public Boolean presentByEmail(String email){
        return userRepository.findFirstByEmail(email) != null;
    }

    // registers a new company based on the provided signup request details
    public UserDTOS signupCompany(SignupRequestDTOS signupRequestDTOS) {
        User user = new User();

        user.setName(signupRequestDTOS.getName());
        user.setEmail(signupRequestDTOS.getEmail());
        user.setPhone(signupRequestDTOS.getPhone());
        user.setPassword(signupRequestDTOS.getPassword());
        user.setRole(UserRole.COMPANY);

        return userRepository.save(user).getDto();
    }
}
