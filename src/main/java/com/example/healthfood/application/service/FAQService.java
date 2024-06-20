package com.example.healthfood.application.service;

import com.example.healthfood.domain.model.FAQ;
import com.example.healthfood.domain.repository.FAQRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FAQService {
    private final FAQRepository faqRepository;

    @Autowired
    public FAQService(FAQRepository faqRepository) {
        this.faqRepository = faqRepository;
    }

    public List<FAQ> getAllFaqs() {
        return faqRepository.findAll();
    }

    public FAQ addFaq(FAQ faq) {
        return faqRepository.save(faq);
    }
}
