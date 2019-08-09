package pl.sdaacademy.programming.rental.model;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;



public class CarParameter {

    private static final int MINUTES = 60;
    private String producer;
    private String model;
    private String colour;
    private BigDecimal price;
    private Boolean automatic;
    private Set<String> attributes = new HashSet<>();

    public LocalDateTime to;
    public LocalDateTime from;


    public String getProducer() {
        return producer;
    }

    public CarParameter setProducer(String producer) {
        this.producer = producer;
        return this;
    }

    public String getModel() {
        return model;
    }

    public CarParameter setModel(String model) {
        this.model = model;
        return this;
    }

    public String getColor() {
        return colour;
    }

    public CarParameter setColour(String colour) {
        this.colour = colour;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public CarParameter setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Boolean isAutomatic() {
        return automatic;
    }

    public CarParameter setAutomatic(Boolean automatic) {
        this.automatic = automatic;
        return this;
    }

    public Set<String> getAttributes() {
        this.attributes = attributes;
        return attributes;
    }

    public CarParameter setAttributes(Set<String> attributes) {
        this.attributes = attributes;
        return this;

    }

    public LocalDateTime getTo() {
        return to;

    }

    public CarParameter setTo(LocalDateTime to) {
        this.to = to;
        return this;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public CarParameter setFrom(LocalDateTime from) {
        this.from = from;
        return this;
    }

       public long howManyHours(){
        long minutes = Duration.between(from, to).toMinutes();
        long hours = (minutes / MINUTES);
        return hours + (minutes - hours * MINUTES >0 ? 1 : 0);
    }

    //1. -CarParam nie może być null
//            2.
////            -"from", "to" nie mogą być null
////            3.
////            - "to" nie może być < niż from







    @Override
    public String toString() {
        return "CarParameter{" +
                "producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", colour='" + colour + '\'' +
                ", price=" + price +
                ", automatic=" + automatic +
                ", attributes=" + attributes +
                ", to=" + to +
                ", from=" + from +
                '}';
    }
}
