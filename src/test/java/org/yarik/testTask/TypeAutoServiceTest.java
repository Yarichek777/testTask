package org.yarik.testTask;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.yarik.testTask.model.TypeAuto;
import org.yarik.testTask.service.TypeAutoService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TypeAutoServiceTest {

    TypeAutoService typeAutoService = Mockito.mock(TypeAutoService.class);
    TypeAuto typeAuto = Mockito.mock(TypeAuto.class);

    @Test
    public void getTypesAutoCount(){
        assertEquals(0, typeAutoService.findAllOrderByType().size());
    }

}
