package com.nuvalence.shaperelationship.rectangle.validator;

import com.nuvalence.shaperelationship.dto.ShapeCoordinate;
import com.nuvalence.shaperelationship.rectangle.dto.Rectangle;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Component;

@Component
public class RectangleValidator implements ConstraintValidator<ValidCoordinates, Rectangle> {
  private String upperLeft;
  private String bottomRight;

  @Override
  public void initialize(ValidCoordinates constraintAnnotation) {
    this.upperLeft = constraintAnnotation.upperLeft();
    this.bottomRight = constraintAnnotation.bottomRight();
  }

  @Override
  public boolean isValid(Rectangle value, ConstraintValidatorContext context) {
    ShapeCoordinate upperLeftValue =
        (ShapeCoordinate) new BeanWrapperImpl(value).getPropertyValue(upperLeft);
    ShapeCoordinate bottomRightValue =
        (ShapeCoordinate) new BeanWrapperImpl(value).getPropertyValue(bottomRight);

    if (upperLeftValue.getX() >= bottomRightValue.getX()
        || upperLeftValue.getY() <= bottomRightValue.getY()) {
      return false;
    }

    return true;
  }
}
