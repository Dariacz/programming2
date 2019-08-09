package pl.sdaacademy.programming.rental.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    void shouldDeserializeFromJSON() throws IOException{
        String jsonCar = "{\n" +
                "    \"id\": 1,\n" +
                "    \"producer\": \"Opel\",\n" +
                "    \"model\": \"Astra\",\n" +
                "    \"color\": \"Blue\",\n" +
                "    \"price\": 10.0,\n" +
                "    \"automatic\": true,\n" +
                "    \"attributes\": [\n" +
                "      \"metalic, PETROL\"\n" +
                "    ]\n" +
                "  }";
        Car car = mapper.readValue(jsonCar, Car.class);

        CarAssert.assertThat(car)
                .hasId(1)
                .hasProducer("Opel")
                .hasModel("Astra")
                .hasColour("Blue")
                .isAutomatic()
                .hasPrice(BigDecimal.valueOf(10.0))
                .hasAttributes("metalic, PETROL ");

    }


}