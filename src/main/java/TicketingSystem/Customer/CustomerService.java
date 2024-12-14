// service interface for customer-related operations

package TicketingSystem.Customer;

import TicketingSystem.DTOS.TicketPoolDTOS;

import java.util.List;

public interface CustomerService {

    List<TicketPoolDTOS> getAllTickets();

}
