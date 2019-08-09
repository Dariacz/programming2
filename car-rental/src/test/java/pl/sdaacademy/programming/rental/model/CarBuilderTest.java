package pl.sdaacademy.programming.rental.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


class CarBuilderTest {
    private CarBuilder builder = new CarBuilder();

    @Test
    void shouldCreateCar() {
        builder.setModel("Astra")
                .setProducer("Opel")
                .setColour("Blue")
                .setPrice(BigDecimal.valueOf(10.0))
                .setId(1)
                .setAutomatic(true)
                .setAttributes(new HashSet<>(Arrays.asList("metalic, PETROL")));

        Car car = builder.createCar();

        CarAssert.assertThat(car)
                .hasId(1)
                .hasProducer("Opel")
                .hasModel("Astra")
                .hasColour("Blue")
                .isAutomatic()
                .hasPrice(BigDecimal.valueOf(10.0))
                .hasAttributes("metalic,PETROL");
    }

    @Test
    void shouldNotCreateSinceIdNotSet() {
        builder.setModel("Astra")
                .setProducer("Opel")
                .setColour("Blue")
                .setPrice(BigDecimal.valueOf(10.0))
                .setAttributes(new HashSet<>(Arrays.asList("metalic, PETROL")));

        assertThatIllegalArgumentException().isThrownBy(() -> builder.createCar())
                .withMessage("Id must be set");
    }

    @Test
    void shouldNotCreateSinceModelNotSet() {
        builder.setId(1l)
                .setProducer("Opel")
                .setColour("Blue")
                .setPrice(BigDecimal.valueOf(10.0))
                .setAttributes(new HashSet<>(Arrays.asList("metalic, PETROL")));

        assertThatIllegalArgumentException().isThrownBy(() -> builder.createCar())
                .withMessage("Required attributes must be set");
    }

    @Test
    void shouldNotCreateSinceProducerNotSet() {
        builder.setId(1l)
                .setModel("Astra")
                .setColour("Blue")
                .setPrice(BigDecimal.valueOf(10.0))
                .setAttributes(new HashSet<>(Arrays.asList("metalic, PETROL")));

        assertThatIllegalArgumentException().isThrownBy(() -> builder.createCar())
                .withMessage("Required attributes must be set");
    }

    @Test
    void shouldNotCreateSinceColourNotSet() {
        builder.setId(1l)
                .setModel("Astra")
                .setProducer("Opel")
                .setPrice(BigDecimal.valueOf(10.0))
                .setAttributes(new HashSet<>(Arrays.asList("metalic, PETROL")));

        assertThatIllegalArgumentException().isThrownBy(() -> builder.createCar())
                .withMessage("Required attributes must be set");
    }

    @Test
    void shouldNotCreateSincePriceNotSet() {
        builder.setId(1l)
                .setModel("Astra")
                .setProducer("Opel")
                .setColour("Blue")
                .setAttributes(new HashSet<>(Arrays.asList("metalic, PETROL")));

        assertThatIllegalArgumentException().isThrownBy(() -> builder.createCar())
                .withMessage("Price must be set to value greater than 0");
    }

    @Test
    void shouldNotCreateCarSincePrice0() {
        builder.setModel("Astra")
                .setProducer("Opel")
                .setColour("Blue")
                .setPrice(BigDecimal.valueOf(0.0))
                .setId(1)
                .setAttributes(new HashSet<>(Arrays.asList("metalic, PETROL")));

        assertThatIllegalArgumentException().isThrownBy(() -> builder.createCar())
                .withMessage("Price must be set to value greater than 0");
    }

    @Test
    void shouldNotCreateCarSincePriceLessThan0() {
        builder.setModel("Astra")
                .setProducer("Opel")
                .setColour("Blue")
                .setPrice(BigDecimal.valueOf(-10.0))
                .setId(1)
                .setAttributes(new HashSet<>(Arrays.asList("metalic, PETROL")));

        assertThatIllegalArgumentException().isThrownBy(() -> builder.createCar())
                .withMessage("Price must be set to value greater than 0");
    }

    @Test
    void shouldCreateCarWithoutAttributes() {
        builder.setModel("Astra")
                .setProducer("Opel")
                .setColour("Blue")
                .setPrice(BigDecimal.valueOf(10.0))
                .setId(3);

        Car car = builder.createCar();

        CarAssert.assertThat(car)
                .isManual();
    }

}