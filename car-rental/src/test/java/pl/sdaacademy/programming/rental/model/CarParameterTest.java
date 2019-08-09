package pl.sdaacademy.programming.rental.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDateTime;
import java.util.stream.Stream;

class CarParameterTest {
    @ParameterizedTest(name = "Hours for parametr {0}")
    @MethodSource("carParametersProvider")
    void shouldReturnCorrectNumberOfHours(CarParameter parameter, long expectedHours) {

        long hours = parameter.howManyHours();

        assertThat(hours).isEqualTo(expectedHours);
    }

    private static Stream<Arguments> carParametersProvider() {
        return Stream.of(
                Arguments.of(new CarParameter()
                                .setFrom(LocalDateTime.of(2019, 6, 1, 10, 0))
                                .setTo(LocalDateTime.of(2019, 6, 1, 11, 0))
                        , 1),
                Arguments.of(new CarParameter()
                                .setFrom(LocalDateTime.of(2019, 6, 1, 10, 0))
                                .setTo(LocalDateTime.of(2019, 6, 1, 10, 10))
                        , 1),
                Arguments.of(new CarParameter()
                                .setFrom(LocalDateTime.of(2019, 6, 1, 10, 10))
                                .setTo(LocalDateTime.of(2019, 6, 1, 11, 10))
                        , 1),
                Arguments.of(new CarParameter()
                                .setFrom(LocalDateTime.of(2019, 6, 1, 10, 10))
                                .setTo(LocalDateTime.of(2019, 6, 1, 11, 9))
                        , 1),
                Arguments.of(new CarParameter()
                                .setFrom(LocalDateTime.of(2019, 6, 1, 10, 10))
                                .setTo(LocalDateTime.of(2019, 6, 3, 11, 9))
                        , 49)
        );
    }

}