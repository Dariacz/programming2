package pl.sdaacademy.programming.rental.service;

import pl.sdaacademy.programming.rental.model.CarDTO;
import pl.sdaacademy.programming.rental.model.CarParameter;

import java.util.List;

public interface CarService {

    List<CarDTO> getCars(CarParameter parameter);
}
