package com.example.healthfood;

import com.example.healthfood.application.service.OrdersService;
import com.example.healthfood.controller.OrdersController;
import com.example.healthfood.domain.model.Orders;
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

class OrdersControllerTest {

    @Mock
    private OrdersService ordersService;

    @InjectMocks
    private OrdersController ordersController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllOrders() {
        // Set up test data
        List<Orders> orders = new ArrayList<>();
        orders.add(new Orders());
        orders.add(new Orders());

        // Mock OrdersService behavior
        when(ordersService.getAllOrders()).thenReturn(orders);

        // Call the controller method
        ResponseEntity<List<Orders>> response = ordersController.getAllOrders();

        // Verify the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(orders, response.getBody());
    }

    @Test
    void testGetOrdersById() {
        // Set up test data
        Long orderId = 1L;
        Orders orders = new Orders();
        orders.setId(orderId);

        // Mock OrdersService behavior
        when(ordersService.getOrdersById(orderId)).thenReturn(orders);

        // Call the controller method
        ResponseEntity<Orders> response = ordersController.getOrdersById(orderId);

        // Verify the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(orders, response.getBody());
    }

    @Test
    void testGetOrdersByUserId() {
        // Set up test data
        User user = new User();
        user.setId(1L);
        List<Orders> orders = new ArrayList<>();
        orders.add(new Orders());
        orders.add(new Orders());

        // Mock OrdersService behavior
        when(ordersService.getOrdersByUserId(user)).thenReturn(orders);

        // Call the controller method
        ResponseEntity<List<Orders>> response = ordersController.getOrdersByUserId(user);

        // Verify the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(orders, response.getBody());
    }

    @Test
    void testSaveOrders() {
        // Set up test data
        Orders orders = new Orders();

        // Mock OrdersService behavior
        when(ordersService.addOrders(orders)).thenReturn(orders);

        // Call the controller method
        ResponseEntity<Orders> response = ordersController.saveOrders(orders);

        // Verify the response
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(orders, response.getBody());
    }

    @Test
    void testDeleteOrders() {
        // Set up test data
        Long orderId = 1L;

        // Call the controller method
        ResponseEntity<Void> response = ordersController.deleteOrders(orderId);

        // Verify the response
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(ordersService, times(1)).deleteOrders(orderId);
    }
}
