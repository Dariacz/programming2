package pl.sdaacademy.programming.rental.data;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class CarRepositoryTest {

    private CarLoader loader = new CarLoader();

    @Test
    void shouldLoadCars(){
        CarRepository carRepository = new CarRepository();

        loader.load("cars.json", carRepository);

        Assertions.assertThat(carRepository.getCars().size()).isEqualTo(8);
    }










}