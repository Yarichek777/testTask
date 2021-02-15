package org.yarik.testTask;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.yarik.testTask.model.CarModel;
import org.yarik.testTask.service.CarModelService;

public class CarModelServiceTest {

    CarModelService carModelService = Mockito.mock(CarModelService.class);

    @Test
    public void getCarModelCount(){
        assertEquals(0, carModelService.findAllOrderByName().size());
    }


}
