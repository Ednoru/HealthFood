package com.example.healthfood.application.service;

import com.example.healthfood.domain.model.Orders;
import com.example.healthfood.domain.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {
    private final OrdersRepository ordersRepository;

    @Autowired
    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    public Orders getOrdersById(Long id) {
        return ordersRepository.findById(id).orElse(null);
    }

    public Orders addOrders(Orders orders) {
        return ordersRepository.save(orders);
    }

    public void deleteOrders(Long id) {
        ordersRepository.deleteById(id);
    }

    public List<Orders> getOrdersByUserId(Long userId) {
        return ordersRepository.findByUserId(userId);
    }
}
