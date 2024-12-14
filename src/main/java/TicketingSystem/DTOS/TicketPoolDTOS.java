// Data Transfer Object for ticket pool information

package TicketingSystem.DTOS;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class TicketPoolDTOS {

    private Long id;              // ticket ID
    private String eventName;     // event name associated with the ticket
    private String description;   // description of the ticket
    private Double price;         // price of the ticket
    private MultipartFile img;    // image associated with the ticket (as a MultipartFile)
    private byte[] returnedImg;   // procesed image bytes (if applicable)
    private Long userId;          // user ID who created the ticket
    private String vendorName;    // name of the vendor associated with the ticket

    //getters and setters to retrieve and add info
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

    public MultipartFile getImg() {
        return img;
    }
    public void setImg(MultipartFile img) {
        this.img = img;
    }

    public byte[] getReturnedImg() {
        return returnedImg;
    }
    public void setReturnedImg(byte[] returnedImg) {
        this.returnedImg = returnedImg;
    }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getVendorName() { return vendorName; }
    public void setVendorName(String vendorName) { this.vendorName = vendorName; }
}
