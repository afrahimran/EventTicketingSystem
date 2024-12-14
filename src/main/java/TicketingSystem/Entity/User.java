// entity representing a user

package TicketingSystem.Entity;

import TicketingSystem.DTOS.UserDTOS;
import TicketingSystem.Enums.UserRole;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String name;
    private String lastname;
    private String phone;
    private UserRole role;

    private int ticketsPurchased; // number of tickets purchased by the user
    private int ticketsAdded;     // number of tickets added by the user

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserRole getRole() {
        return role;
    }
    public void setRole(UserRole role) {
        this.role = role;
    }

    public int getTicketsPurchased() {
        return ticketsPurchased;
    }
    public void setTicketsPurchased(int ticketsPurchased) {
        this.ticketsPurchased = ticketsPurchased;
    }

    public int getTicketsAdded() {
        return ticketsAdded;
    }
    public void setTicketsAdded(int ticketsAdded) {
        this.ticketsAdded = ticketsAdded;
    }

    // converts this entity to its corresponding DTO
    public UserDTOS getDto(){
        UserDTOS userDTOS = new UserDTOS();
        userDTOS.setId(id);
        userDTOS.setEmail(email);
        userDTOS.setPassword(password);
        userDTOS.setName(name);
        userDTOS.setRole(role);
        return userDTOS;
    }
}
