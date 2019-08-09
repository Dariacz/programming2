package pl.sdaacademy.programming.rental.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.sdaacademy.programming.rental.model.CarDTO;
import pl.sdaacademy.programming.rental.data.CarRepository;
import pl.sdaacademy.programming.rental.model.CarParameter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarServiceImpl implements CarService {
    private static final Logger LOG = LoggerFactory.getLogger(CarServiceImpl.class);

    private final CarRepository carRepository;
    private final CarFilter carFilter;

    public CarServiceImpl(CarRepository carRepository, CarFilter carFilter) {
        this.carRepository = carRepository;
        this.carFilter = carFilter;
    }
    @Override
    public List<CarDTO> getCars(CarParameter carParameter) {
        LOG.info("entering getCars{{}}",carParameter);

        List<CarDTO> result = new ArrayList<>();
        result.addAll(carRepository.getCars().stream()
                .filter(car -> carFilter.isValid(car, carParameter))
                .map(car -> new CarDTO(car, 1))
                .collect(Collectors.toList()));

        LOG.info("finished getCars{{}}, found {} cars", carParameter, result.size());
        return result;
    }



}
