package com.nuvalence.shaperelationship.rectangle.validator;

import com.nuvalence.shaperelationship.dto.ShapeCoordinate;
import com.nuvalence.shaperelationship.rectangle.dto.Rectangle;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class RectangleValidator implements ConstraintValidator<ValidCoordinates, Rectangle> {

  @Override
  public void initialize(ValidCoordinates constraintAnnotation) {}

  @Override
  public boolean isValid(Rectangle value, ConstraintValidatorContext context) {
    ShapeCoordinate upperLeftValue = value.getUpperLeft();
    ShapeCoordinate bottomRightValue = value.getBottomRight();

    if (upperLeftValue.getX() >= bottomRightValue.getX()
        || upperLeftValue.getY() <= bottomRightValue.getY()) {
      return false;
    }
    return true;
  }
}
