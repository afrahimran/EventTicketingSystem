// controller to handle customer-related operations
package TicketingSystem.Controller;

import TicketingSystem.Customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    // injects the CustomerService to handle business logic related to customer operations
    @Autowired
    private CustomerService customerService;

    // endpoint to get all tickets for a customer
    @GetMapping("/tickets")
    public ResponseEntity<?> getAllTickets() {
        return ResponseEntity.ok(customerService.getAllTickets());
    }

}
