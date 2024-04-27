package com.example.healthfood.domain.model;

import com.example.healthfood.domain.model.User;
import com.example.healthfood.domain.model.Food;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


@Setter
@Getter
@Entity
@Table(name = "Orders")
@Data
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private Date delivery_date;

    @Column(nullable = false)
    private Time delivery_hour;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    public LocalDate getDateReal(){
        long varDate=delivery_date.getTime();
        Instant instant = Instant.ofEpochMilli(varDate);
        LocalDate realDeliveryDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
        return realDeliveryDate;
    }
}
