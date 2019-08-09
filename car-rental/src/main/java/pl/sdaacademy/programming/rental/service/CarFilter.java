package pl.sdaacademy.programming.rental.service;


import org.apache.commons.lang3.StringUtils;
import pl.sdaacademy.programming.rental.model.Car;
import pl.sdaacademy.programming.rental.model.CarParameter;

import java.util.function.BiPredicate;

public class CarFilter {


    private static final BiPredicate<String, String> CONDITION = (parametrValue, caraValue) -> (StringUtils.isBlank(parametrValue) || StringUtils.equals(parametrValue, caraValue));

    public boolean isValid(Car car, CarParameter carParametr) {

        return CONDITION.test(carParametr.getColor(), car.getColour())
                && CONDITION.test(carParametr.getModel(), car.getModel())
                && CONDITION.test(carParametr.getProducer(), car.getProducer())
                && (carParametr.isAutomatic() == null || carParametr.isAutomatic() == car.isAutomatic())
                && (carParametr.getPrice() == null || carParametr.getPrice().equals(car.getPrice()))
                && (carParametr.getAttributes().isEmpty() || car.getAttributes().containsAll(carParametr.getAttributes()));



    }
}
