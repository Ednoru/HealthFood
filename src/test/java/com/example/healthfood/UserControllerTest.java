package com.example.healthfood;

import com.example.healthfood.application.service.UserService;
import com.example.healthfood.controller.UserController;
import com.example.healthfood.domain.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllUsers() {
        // Set up test data
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());

        // Mock UserService behavior
        when(userService.getAllUser()).thenReturn(users);

        // Call the controller method
        ResponseEntity<List<User>> response = userController.getAllUsers();

        // Verify the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(users, response.getBody());
    }

    @Test
    void testGetUserById() {
        // Set up test data
        Long userId = 1L;
        User user = new User();
        user.setId(userId);

        // Mock UserService behavior
        when(userService.getUserById(userId)).thenReturn(user);

        // Call the controller method
        ResponseEntity<User> response = userController.getUserById(userId);

        // Verify the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
    }

    @Test
    void testSaveUser() {
        // Set up test data
        User user = new User();

        // Mock UserService behavior
        when(userService.addUser(user)).thenReturn(user);

        // Call the controller method
        ResponseEntity<User> response = userController.saveUser(user);

        // Verify the response
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(user, response.getBody());
    }

    @Test
    void testDeleteUser() {
        // Set up test data
        Long userId = 1L;

        // Call the controller method
        ResponseEntity<User> response = userController.deleteUser(userId);

        // Verify the response
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(userService, times(1)).deleteUser(userId);
    }
}
