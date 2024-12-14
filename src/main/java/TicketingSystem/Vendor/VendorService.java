
package TicketingSystem.Vendor;

import TicketingSystem.DTOS.TicketPoolDTOS;

import java.io.IOException;
import java.util.List;

public interface VendorService {

    boolean postTicket(Long userId, TicketPoolDTOS ticketPoolDTOS) throws IOException;

    List<TicketPoolDTOS> getAllTickets(Long userId);

    TicketPoolDTOS getTicketById(Long ticketid);

    boolean updateTicket(Long ticketId, TicketPoolDTOS ticketPoolDTOS) throws IOException;
}