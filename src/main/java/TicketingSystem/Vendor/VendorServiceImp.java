package TicketingSystem.Vendor;

import TicketingSystem.DTOS.TicketPoolDTOS;
import TicketingSystem.Entity.TicketPool;
import TicketingSystem.Entity.User;
import TicketingSystem.Enums.UserRole;
import TicketingSystem.Repository.TicketPoolRepository;
import TicketingSystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class VendorServiceImp implements VendorService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TicketPoolRepository ticketPoolRepository;

    private static final int MAX_TICKETS_ADDED = 100;

    @Transactional
    public boolean postTicket(Long userId, TicketPoolDTOS ticketPoolDTOS) throws IOException {
        if (ticketPoolDTOS == null || ticketPoolDTOS.getEventName() == null || ticketPoolDTOS.getPrice() == null) {
            return false;
        }

        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent() && optionalUser.get().getRole() == UserRole.CLIENT) {
            User user = optionalUser.get();
            if (user.getTicketsAdded() >= MAX_TICKETS_ADDED) {
                return false;
            }

            TicketPool ticket = new TicketPool();
            ticket.setEventName(ticketPoolDTOS.getEventName());
            ticket.setDescription(ticketPoolDTOS.getDescription());
            ticket.setImg(ticketPoolDTOS.getImg().getBytes());
            ticket.setPrice(ticketPoolDTOS.getPrice());
            ticket.setUser(user);

            ticketPoolRepository.save(ticket);
            user.setTicketsAdded(user.getTicketsAdded() + 1);
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public List<TicketPoolDTOS> getAllTickets(Long userId) {
        return ticketPoolRepository.findAllByUserId(userId).stream().map(TicketPool::getTicketDto).collect(Collectors.toList());
    }

    public TicketPoolDTOS getTicketById(Long ticketid) {
        Optional<TicketPool> optionalTicket = ticketPoolRepository.findById(ticketid);
        if(optionalTicket.isPresent()) {
            return optionalTicket.get().getTicketDto();
        }
        return null;
    }

    @Transactional
    public boolean updateTicket(Long ticketId, TicketPoolDTOS ticketPoolDTOS) throws IOException {
        if (ticketPoolDTOS == null) {
            return false;
        }

        Optional<TicketPool> optionalTicket = ticketPoolRepository.findById(ticketId);
        if (optionalTicket.isPresent()) {
            TicketPool ticket = optionalTicket.get();
            if (ticketPoolDTOS.getEventName() != null) {
                ticket.setEventName(ticketPoolDTOS.getEventName());
            }
            if (ticketPoolDTOS.getDescription() != null) {
                ticket.setDescription(ticketPoolDTOS.getDescription());
            }
            if (ticketPoolDTOS.getPrice() != null) {
                ticket.setPrice(ticketPoolDTOS.getPrice());
            }
            if (ticketPoolDTOS.getImg() != null) {
                ticket.setImg(ticketPoolDTOS.getImg().getBytes());
            }
            ticketPoolRepository.save(ticket);
            return true;
        }
        return false;
    }
}