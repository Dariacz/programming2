package pl.sdaacademy.programming.rental.model;

import pl.sdaacademy.programming.rental.model.Car;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class CarDTO {


    private long id;
    private String producer;
    private String model;
    private String colour;
    private BigDecimal price;
    private boolean automatic;
    private Set<String> attributes = new HashSet<>();

    public CarDTO(Car car, int howManyHour) {
        this.id = car.getId();
        this.producer = car.getProducer();
        this.price = car.getPrice().multiply(BigDecimal.valueOf(howManyHour));
        this.model = car.getModel();
        this.colour = car.getColour();
        this.automatic = car.isAutomatic();
        this.attributes.addAll(car.getAttributes());
    }

    public long getId() {
        return id;
    }

    public String getProducer() {
        return producer;
    }

    public String getModel() {
        return model;
    }

    public String getColour() {
        return colour;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public boolean isAutomatic() {
        return automatic;
    }

    public Set<String> getAttributes() {
        return attributes;
    }

    @Override
    public String toString() {
        return "CarDTO{" +
                "id=" + id +
                ", producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", colour='" + colour + '\'' +
                ", price=" + price +
                ", automatic=" + automatic +
                ", attributes=" + attributes +
                '}';
    }
}



