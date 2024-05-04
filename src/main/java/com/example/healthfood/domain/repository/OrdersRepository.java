package com.example.healthfood.domain.repository;

import com.example.healthfood.domain.model.Orders;
import com.example.healthfood.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {

    List<Orders> findByUserId(User userId);
}
