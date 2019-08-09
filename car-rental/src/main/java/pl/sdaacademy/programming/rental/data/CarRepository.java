package pl.sdaacademy.programming.rental.data;

import pl.sdaacademy.programming.rental.model.Car;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;


public class CarRepository {

    private final Collection<Car> cars = new HashSet<>();

    void update(Collection<Car> cars) {
        this.cars.addAll(cars);
    }

    public Collection<Car> getCars() {
        return Collections.unmodifiableCollection(cars);
    }
}
