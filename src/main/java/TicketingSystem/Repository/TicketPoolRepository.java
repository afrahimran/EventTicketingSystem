// repository interface for managing TicketPool entities

package TicketingSystem.Repository;

import TicketingSystem.Entity.TicketPool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketPoolRepository extends JpaRepository<TicketPool, Long> {
    List<TicketPool> findAllByUserId(Long userId); // finds all TicketPool entities associated with a specific user ID

    List<TicketPool> findAllBy(Long userId, String status); // finds all TicketPool entities by user ID and status.
}
