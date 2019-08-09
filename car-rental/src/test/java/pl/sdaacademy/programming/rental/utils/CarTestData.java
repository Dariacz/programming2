package pl.sdaacademy.programming.rental.utils;

import pl.sdaacademy.programming.rental.model.Car;
import pl.sdaacademy.programming.rental.model.CarBuilder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;


public class CarTestData {

    private static final List<Car> CARS = initCars();

    private static List<Car> initCars() {
        List<Car> cars = new ArrayList<>();
        CarBuilder builder = new CarBuilder();
        builder.setId(1)
                .setProducer("Toyota")
                .setModel("Yaris")
                .setColour("Black")
                .setPrice(BigDecimal.valueOf(5.5))
                .setAutomatic(true)
                .setAttributes(new TreeSet<>(Arrays.asList("GPS", "PETROL")));
        cars.add(builder.createCar());
        builder.setId(2)
                .setAutomatic(false)
                .setPrice(new BigDecimal(4.5));
        cars.add(builder.createCar());
        return cars;
    }

    public static List<Car> getCars(int from, int to) {
        return CARS.subList(from, to);
    }

    public static Car getCar(int index) {
        return CARS.get(index);
    }
}