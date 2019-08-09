package pl.sdaacademy.programming.rental.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.sdaacademy.programming.rental.model.CarDTO;
import pl.sdaacademy.programming.rental.data.CarRepository;
import pl.sdaacademy.programming.rental.model.CarParameter;
import pl.sdaacademy.programming.rental.utils.CarTestData;

import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)

class CarServiceImplTest {

    @InjectMocks
    private CarServiceImpl carService;

    @Mock
    private CarRepository carRepository;

    @Spy
    private CarFilter carFilter;

    @Test
    void shouldReturnListWith2Cars(){
        given(carRepository.getCars()).willReturn(CarTestData.getCars(0,2));

        List<CarDTO> result = carService.getCars(new CarParameter());

        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    void shuldReturnListWith1Car(){
        given(carRepository.getCars()).willReturn(CarTestData.getCars(0,2));

        List<CarDTO> result = carService.getCars(new CarParameter().setAutomatic(true));
        assertThat(result.size()).isEqualTo(1);
    }

}