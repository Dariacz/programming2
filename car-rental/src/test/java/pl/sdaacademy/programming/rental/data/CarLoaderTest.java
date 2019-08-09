package pl.sdaacademy.programming.rental.data;


import org.junit.jupiter.api.Test;



import static org.assertj.core.api.Assertions.assertThat;


class CarLoaderTest {

    private CarLoader loader = new CarLoader();

    @Test
    void shouldLoadCars() {
        CarRepository carRepository = new CarRepository();

        loader.load("cars.json", carRepository);

        assertThat(carRepository.getCars().size()).isEqualTo(8);
    }

    @Test
    void shouldNotLoadCarsIfInvalidFile() {
        CarRepository carRepository = new CarRepository();

        loader.load("cars-invalid.json", carRepository);

        assertThat(carRepository.getCars().size()).isEqualTo(0);

    }

}