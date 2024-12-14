// Controller to handle authentication-related operations
package TicketingSystem.Controller;


import TicketingSystem.DTOS.*;
import TicketingSystem.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    // injects the AuthService to handle business logic related to authentication
    @Autowired
    private AuthService authService;

    @Autowired
    private AuthController authController;

    // constant for the token prefix used in the "Authorization" header
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";

    // endpoint for client signup
    @PostMapping("/client/signup")
    public ResponseEntity<?> signupClient(@RequestBody SignupRequestDTOS signupRequestDTOS) {

        if (authService.presentByEmail(signupRequestDTOS.getEmail())) {
            return new ResponseEntity<>("Customer already exists", HttpStatus.NOT_ACCEPTABLE);
        }
        UserDTOS createdUser = authService.signupClient(signupRequestDTOS);
        return new ResponseEntity<>(createdUser, HttpStatus.OK);
    }

    // endpoint for company signup
    @PostMapping("/company/signup")
    public ResponseEntity<?> signupCompany(@RequestBody SignupRequestDTOS signupRequestDTOS) {

        if (authService.presentByEmail(signupRequestDTOS.getEmail())) {
            return new ResponseEntity<>("Company already exists", HttpStatus.NOT_ACCEPTABLE);
        }
        UserDTOS createdUser = authService.signupClient(signupRequestDTOS);
        return new ResponseEntity<>(createdUser, HttpStatus.OK);
    }
}
