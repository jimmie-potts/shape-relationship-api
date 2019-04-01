package com.nuvalence.shaperelationship.rectangle.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;

@Constraint(validatedBy = RectangleValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCoordinates {
  String message() default
      "Coordinates are not valid! Please verify Upper Left and Bottom Right X and Y values";

  String upperLeft();

  String bottomRight();

  Class<?>[] groups() default {};

  Class<?>[] payload() default {};
}
