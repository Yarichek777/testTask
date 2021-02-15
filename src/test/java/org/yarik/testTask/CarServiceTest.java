package org.yarik.testTask;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.yarik.testTask.service.CarService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarServiceTest {

    CarService carService = Mockito.mock(CarService.class);

    @Test
    public void getCarCount(@PageableDefault Pageable pageable){
        assertEquals(0, carService.findAllOrderByPrice(pageable).get().count());
    }

}
