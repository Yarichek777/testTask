package org.yarik.testTask;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.yarik.testTask.service.CarBrandService;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CarBrandServiceTest {
    private final CarBrandService carBrandService = Mockito.mock(CarBrandService.class);

    @Test
    public void getCarBrandCount(){
        assertEquals(0, carBrandService.findAllOrderByName().size());
    }


}
