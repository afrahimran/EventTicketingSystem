// service interface for handling user authentication and registration operations

package TicketingSystem.Service;

import TicketingSystem.DTOS.SignupRequestDTOS;
import TicketingSystem.DTOS.UserDTOS;

public interface AuthService {

    // registers a new client based on the provided signup request details
    UserDTOS signupClient(SignupRequestDTOS signupRequestDTOS);

    // checks if a user with the given email already exists
    Boolean presentByEmail(String email);

    // registers a new company based on the provided signup request details
    UserDTOS signupCompany(SignupRequestDTOS signupRequestDTOS);
}
