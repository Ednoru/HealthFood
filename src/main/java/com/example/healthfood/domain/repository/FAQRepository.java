package com.example.healthfood.domain.repository;

import com.example.healthfood.domain.model.FAQ;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FAQRepository extends JpaRepository<FAQ, Long> {
}
