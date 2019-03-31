package com.nuvalence.shaperelationship.rectangle.validator;

import com.nuvalence.shaperelationship.dto.ShapeCoordinate;
import com.nuvalence.shaperelationship.rectangle.dto.Rectangle;
import javax.validation.ConstraintValidatorContext;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RectangleValidatorTest {
  @Mock ConstraintValidatorContext constraintValidatorContext;

  RectangleValidator rectangleValidator = new RectangleValidator();

  @Test
  public void isValid_withValidRectangle() {
    // Assemble
    Rectangle rectangle = new Rectangle(new ShapeCoordinate(0, 5), new ShapeCoordinate(5, 0));

    // Act
    boolean result = rectangleValidator.isValid(rectangle, constraintValidatorContext);

    // Assert
    Assert.assertTrue(result);
  }

  @Test
  public void isValid_withInvalidRectangle_X() {
    // Assemble
    Rectangle rectangle = new Rectangle(new ShapeCoordinate(0, 5), new ShapeCoordinate(-10, 0));

    // Act
    boolean result = rectangleValidator.isValid(rectangle, constraintValidatorContext);

    // Assert
    Assert.assertFalse(result);
  }

  @Test
  public void isValid_withInvalidRectangle_Y() {
    // Assemble
    Rectangle rectangle = new Rectangle(new ShapeCoordinate(0, 5), new ShapeCoordinate(5, 10));

    // Act
    boolean result = rectangleValidator.isValid(rectangle, constraintValidatorContext);

    // Assert
    Assert.assertFalse(result);
  }
}
