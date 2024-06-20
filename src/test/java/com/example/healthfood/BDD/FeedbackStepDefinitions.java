package com.example.healthfood.BDD;

import com.example.healthfood.application.service.FeedbackService;
import com.example.healthfood.domain.model.Feedback;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FeedbackStepDefinitions {

    @Autowired
    private FeedbackService feedbackService;

    private List<Feedback> feedbacks;
    private Feedback newFeedback;

    @Given("He consumido varias comidas de Health Food")
    public void he_consumido_varias_comidas_de_Health_Food() {
    }

    @When("Quiero compartir mi experiencia")
    public void quiero_compartir_mi_experiencia() {
        newFeedback = new Feedback();
        newFeedback.setComment("¡Me encantó la comida!");
        newFeedback.setRating(5); // Puntuación del 1 al 5
        feedbackService.addFeedback(newFeedback);
    }

    @Then("Debería poder dejar comentarios y calificaciones en la aplicación para cada comida")
    public void debería_poder_dejar_comentarios_y_calificaciones_en_la_aplicación_para_cada_comida() {
        feedbacks = feedbackService.getAllFeedbacks();
        Assert.assertFalse(feedbacks.isEmpty());
        Assert.assertEquals("¡Me encantó la comida!", feedbacks.get(0).getComment());
        Assert.assertEquals(5, feedbacks.get(0).getRating());
    }
}
