package com.example.healthfood.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.validation.executable.ExecutableValidator;
import jakarta.validation.metadata.BeanDescriptor;
import org.springframework.stereotype.Component;

import java.util.Set;

//@Component
public class CustomValidator /*implements Validator */{
    /*
    @Override

    public boolean supports(Class<?> clazz) {
        return FoodDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        FoodDTO foodDTO = (FoodDTO) target;

        // Ejemplo de validación: el precio debe ser mayor que cero
        if (foodDTO.getPrice() <= 0) {
            errors.rejectValue("price", "food.price.invalid", "Price must be greater than zero");
        }

        // Puedes agregar más validaciones según tus necesidades
    }

    @Override
    public <T> Set<ConstraintViolation<T>> validate(T t, Class<?>... classes) {
        return Set.of();
    }

    @Override
    public <T> Set<ConstraintViolation<T>> validateProperty(T t, String s, Class<?>... classes) {
        return Set.of();
    }

    @Override
    public <T> Set<ConstraintViolation<T>> validateValue(Class<T> aClass, String s, Object o, Class<?>... classes) {
        return Set.of();
    }

    @Override
    public BeanDescriptor getConstraintsForClass(Class<?> aClass) {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> aClass) {
        return null;
    }

    @Override
    public ExecutableValidator forExecutables() {
        return null;
    }
    */
}
