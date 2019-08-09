package pl.sdaacademy.programming.rental.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.sdaacademy.programming.rental.utils.CarTestData;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarDTOTest {
    @Test
    void shouldTransferAllDataAndPriceMultipliedByHours() {

        CarDTO dto = new CarDTO(CarTestData.getCar(0), 4);

        assertThat(dto.getId()).isEqualTo(1);
        assertThat(dto.getProducer()).isEqualTo("Toyota");
        assertThat(dto.getModel()).isEqualTo("Yaris");
        assertThat(dto.getColour()).isEqualTo("Black");
        assertThat(dto.isAutomatic()).isEqualTo(true);
        assertThat(dto.getPrice()).isEqualTo(BigDecimal.valueOf(22.0));
        assertThat(dto.getAttributes()).containsExactly("PETROL", "GPS");
    }






}