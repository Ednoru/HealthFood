package com.example.healthfood.domain.repository;

import com.example.healthfood.domain.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}