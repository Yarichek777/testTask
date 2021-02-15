package org.yarik.testTask;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.yarik.testTask.service.UserService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserServiceTest {

    UserService userService = Mockito.mock(UserService.class);

    @Test
    public void getUsersCount(){
        assertEquals(0, userService.getAll().size());
    }

}
