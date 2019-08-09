package pl.sdaacademy.programming.rental.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.sdaacademy.programming.rental.model.Car;


import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;


public class CarLoader {

    private static final Logger LOG = LoggerFactory.getLogger(CarLoader.class);

    private ObjectMapper mapper = new ObjectMapper();

    // This is utility class so the method could be static. However, using static elements (apart from const) is treated
    // as antipattern thus this is the regular method.
    public void load(String fileName, CarRepository carRepository) {

        LOG.debug("loading cars from file {}", fileName);
        try (InputStream fileStream = Files.newInputStream(Paths.get(CarLoader.class.getClassLoader()
                .getResource(fileName).toURI()))) {

            Car[] cars = mapper.readValue(fileStream, Car[].class);
            carRepository.update(Arrays.asList(cars));
            LOG.debug("cars in repository {}", carRepository.getCars().size());

        } catch (Exception e) {
            LOG.error("cars not loaded", e);
        }
    }
}
