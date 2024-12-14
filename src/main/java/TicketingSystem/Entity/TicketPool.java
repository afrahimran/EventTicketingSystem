// eentity representing a ticket pool

package TicketingSystem.Entity;

import TicketingSystem.DTOS.TicketPoolDTOS;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "ticket_pool")
public class TicketPool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String eventName;
    private String description;
    private Double price;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] img;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    public byte[] getImg() {
        return img;
    }
    public void setImg(byte[] img) {
        this.img = img;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    // converts this entity to its corresponding DTO
    public TicketPoolDTOS getTicketDto() {
        TicketPoolDTOS ticketPoolDTOS = new TicketPoolDTOS();
        ticketPoolDTOS.setId(id);
        ticketPoolDTOS.setEventName(eventName);
        ticketPoolDTOS.setDescription(description);
        ticketPoolDTOS.setPrice(price);
        ticketPoolDTOS.setVendorName(user.getName());
        ticketPoolDTOS.setReturnedImg(img);

        return ticketPoolDTOS;


    }
}
