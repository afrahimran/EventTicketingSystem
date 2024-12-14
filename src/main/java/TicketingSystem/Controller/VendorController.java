// controller to handle vendor-related operations
package TicketingSystem.Controller;

import TicketingSystem.DTOS.TicketPoolDTOS;
import TicketingSystem.Vendor.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/vendor")
public class VendorController {

    // injects the VendorService to handle business logic related to vendor operations
    @Autowired
    private VendorService vendorService;

    // endpoint for a vendor to create a new ticket
    @PostMapping("/ticket/{userId}")
    public ResponseEntity<?> postTicket(@PathVariable Long userId, @ModelAttribute TicketPoolDTOS ticketPoolDTOS) {
        try {
            if (userId == null || ticketPoolDTOS == null) {
                return ResponseEntity.badRequest().body("Invalid input parameters");
            }
            
            boolean success = vendorService.postTicket(userId, ticketPoolDTOS);
            if (success) {
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.badRequest().body("Failed to create ticket");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error processing ticket image");
        }
    }

    // endpoint for a vendor to get all tickets
    @GetMapping("/tickets/{userId}")
    public ResponseEntity<?> getAllTickets(@PathVariable Long userId) {
        return ResponseEntity.ok(vendorService.getAllTickets(userId));
    }

    // endpoint to get details of a specific ticket by its ID
    @GetMapping("/ticket/{ticketid}")
    public ResponseEntity<?> getTicketById(@PathVariable Long ticketid) {
        TicketPoolDTOS ticket = vendorService.getTicketById(ticketid);
        if(ticket != null) {
            return ResponseEntity.ok(ticket);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // endpoint to update an existing ticket
    @PutMapping("/ticket/{ticketid}")
    public ResponseEntity<?> updateTicket(@PathVariable Long ticketid, @ModelAttribute TicketPoolDTOS ticketPoolDTOS) throws IOException {
        boolean success = vendorService.updateTicket(ticketid, ticketPoolDTOS);
        if (success) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().body("Failed to update ticket");
    }
}
