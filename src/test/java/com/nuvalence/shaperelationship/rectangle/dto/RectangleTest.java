package com.nuvalence.shaperelationship.rectangle.dto;

import com.nuvalence.shaperelationship.dto.ShapeCoordinate;
import org.junit.Assert;
import org.junit.Test;

public class RectangleTest {
  // Assemble
  Rectangle rectangle = new Rectangle(new ShapeCoordinate(-1, 5), new ShapeCoordinate(5, 0));

  @Test
  public void getLength() {
    // Act
    int result = rectangle.getLength();

    // Assert
    Assert.assertEquals(5, result);
  }

  @Test
  public void getWidth() {
    // Act
    int result = rectangle.getWidth();

    // Assert
    Assert.assertEquals(6, result);
  }

  @Test
  public void getPerimeter() {
    // Act
    int result = rectangle.getPerimeter();

    // Assert
    Assert.assertEquals(22, result);
  }

  @Test
  public void getArea() {
    // Act
    int result = rectangle.getArea();

    // Assert
    Assert.assertEquals(30, result);
  }
}
