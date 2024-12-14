// repository interface for managing user entities

package TicketingSystem.Repository;

import TicketingSystem.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findFirstByEmail(String email); // finds the first user by their email
}
