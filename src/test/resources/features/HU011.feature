Feature: Preguntas Frecuentes

  Como usuario quiero tener acceso a una sección de preguntas frecuentes para responder mis dudas de forma más rápida.

  Scenario: Acceso a preguntas frecuentes
    Given Estoy en la página principal de la aplicación
    When Hago clic en el módulo de preguntas frecuentes
    Then Debería ser redirigido al portal de preguntas frecuentes

  Scenario: Verificación de preguntas frecuentes
    Given Estoy en el portal de preguntas frecuentes
    When Veo la lista de preguntas frecuentes disponibles
    Then Debería ver al menos una pregunta y su respuesta asociada
