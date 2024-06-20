package com.example.healthfood.BDD;

import com.example.healthfood.application.service.FAQService;
import com.example.healthfood.domain.model.FAQ;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FaqStepDefinitions {

    @Autowired
    private FAQService faqService;

    private List<FAQ> faqs;
    private String currentPage;

    @Given("Estoy en la página principal de la aplicación")
    public void estoy_en_la_página_principal_de_la_aplicación() {
        currentPage = "home";
    }

    @When("Hago clic en el módulo de preguntas frecuentes")
    public void hago_clic_en_el_módulo_de_preguntas_frecuentes() {
        currentPage = "faq";
    }

    @Then("Debería ser redirigido al portal de preguntas frecuentes")
    public void debería_ser_redirigido_al_portal_de_preguntas_frecuentes() {
        Assert.assertEquals("faq", currentPage);
    }

    @When("Veo la lista de preguntas frecuentes disponibles")
    public void veo_la_lista_de_preguntas_frecuentes_disponibles() {
        faqs = faqService.getAllFaqs();
    }

    @Then("Debería ver al menos una pregunta y su respuesta asociada")
    public void debería_ver_al_menos_una_pregunta_y_su_respuesta_asociada() {
        Assert.assertFalse(faqs.isEmpty());
        Assert.assertNotNull(faqs.get(0).getQuestion());
        Assert.assertNotNull(faqs.get(0).getAnswer());
    }
}
