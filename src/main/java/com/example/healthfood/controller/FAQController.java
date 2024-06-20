package com.example.healthfood.controller;

import com.example.healthfood.application.service.FAQService;
import com.example.healthfood.domain.model.FAQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/faqs")
public class FAQController {

    private final FAQService faqService;

    @Autowired
    public FAQController(FAQService faqService) {
        this.faqService = faqService;
    }

    @GetMapping
    public ResponseEntity<List<FAQ>> getAllFaqs() {
        List<FAQ> faqs = faqService.getAllFaqs();
        return new ResponseEntity<>(faqs, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FAQ> addFaq(@RequestBody FAQ faq) {
        FAQ savedFaq = faqService.addFaq(faq);
        return new ResponseEntity<>(savedFaq, HttpStatus.CREATED);
    }

    // Puedes agregar otros métodos según necesites (editar, eliminar, etc.)
}