package pl.sdaacademy.programming.rental.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.sdaacademy.programming.rental.model.Car;
import pl.sdaacademy.programming.rental.model.CarParameter;
import pl.sdaacademy.programming.rental.utils.CarTestData;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


class CarFilterTest {

    private CarFilter carFilter = new CarFilter();

    @Test
    void shouldReturnCarIfNothingInSearchParametr() {
        Car car = CarTestData.getCar(1);

        boolean result = carFilter.isValid(car, new CarParameter());

        assertThat(result).isTrue();
    }

    @ParameterizedTest(name = "Found car for parametr (0)")
    @MethodSource("provideParametrsWhichWillFoundCar")
    void shouldReturnCar(CarParameter parametr) {
        Car car = CarTestData.getCar(1);

        boolean result = carFilter.isValid(car, parametr);

        assertThat(result).isTrue();
    }

    private static Stream<Arguments> provideParametrsWhichWillFoundCar() {
        return Stream.of(
                Arguments.of(new CarParameter().setColour("Black")),
                Arguments.of(new CarParameter().setModel("Yaris")),
                Arguments.of(new CarParameter().setProducer("Toyota")),
                Arguments.of(new CarParameter().setAutomatic(false)),
                Arguments.of(new CarParameter().setPrice(BigDecimal.valueOf(4.51))),
                Arguments.of(new CarParameter().setAttributes(new HashSet<>(Arrays.asList("PETROL", "GPS")))),
                Arguments.of(new CarParameter().setColour("Black").setAttributes(new HashSet<>(Arrays.asList("PETROL", "GPS")))),
                Arguments.of(new CarParameter().setColour("Black").setModel("Yaris").setAttributes(new HashSet<>(Arrays.asList("PETROL", "GPS")))),
                Arguments
                        .of(new CarParameter().setColour("Black").setModel("Yaris").setProducer("Toyota").setAttributes(new HashSet<>(Arrays.asList("PETROL", "GPS")))),
                Arguments.of(new CarParameter().setColour("Black").setModel("Yaris").setProducer("Toyota").setAutomatic(false)
                        .setAttributes(new HashSet<>(Arrays.asList("PETROL", "GPS")))),
                Arguments.of(new CarParameter().setColour("Black").setModel("Yaris").setProducer("Toyota").setAutomatic(false).setPrice(BigDecimal.valueOf(4.5))
                        .setAttributes(new HashSet<>(Arrays.asList("PETROL", "GPS")))));

    }

    @ParameterizedTest(name = "Not found car for parametr (0)")
    @MethodSource("provideParametrsWhichWillNotFoundCar")
    void shouldNotReturnCar(CarParameter parametr) {
        Car car = CarTestData.getCar(1);

        boolean result = carFilter.isValid(car, parametr);

        assertThat(result).isFalse();
    }

    private static Stream<Arguments> provideParametrsWhichWillNotFoundCar() {
        return Stream.of(
                Arguments.of(new CarParameter().setColour("Red")),
                Arguments.of(new CarParameter().setModel("Cuba")),
                Arguments.of(new CarParameter().setProducer("Fiat")),
                Arguments.of(new CarParameter().setAutomatic(true)),
                Arguments.of(new CarParameter().setPrice(BigDecimal.valueOf(4.51))),
                Arguments.of(new CarParameter().setAttributes(new HashSet<>(Arrays.asList("PETROL", "GPS", "METAL"))))
        );

    }


}

