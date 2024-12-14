// implementation of the CustomerService interface

package TicketingSystem.Customer;

import TicketingSystem.DTOS.TicketPoolDTOS;
import TicketingSystem.Repository.TicketPoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class CustomerServiceImp implements CustomerService {

    // injects the TicketPoolRepository to interact with the ticket data in the database
    @Autowired
    private TicketPoolRepository ticketPoolRepository;

    // retrieves all tickets for a customer
    @Override
    public List<TicketPoolDTOS> getAllTickets() {
        return ticketPoolRepository.findAll()
                .stream()
                .map(ticket -> {
                    TicketPoolDTOS dto = new TicketPoolDTOS();
                    dto.setId(ticket.getId());
                    dto.setEventName(ticket.getEventName());
                    dto.setDescription(ticket.getDescription());
                    dto.setPrice(ticket.getPrice());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
