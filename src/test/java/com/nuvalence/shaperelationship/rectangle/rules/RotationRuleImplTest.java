package com.nuvalence.shaperelationship.rectangle.rules;

import com.nuvalence.shaperelationship.dto.ShapeCoordinate;
import com.nuvalence.shaperelationship.enums.ShapeRelationship;
import com.nuvalence.shaperelationship.rectangle.dto.Rectangle;
import org.junit.Assert;
import org.junit.Test;

public class RotationRuleImplTest {
  RotationRuleImpl rule = new RotationRuleImpl();

  @Test
  public void calculateRelationship_rotated() {
    // Assemble
    Rectangle rectangle1 = new Rectangle(new ShapeCoordinate(0, 2), new ShapeCoordinate(10, 0));
    Rectangle rectangle2 = new Rectangle(new ShapeCoordinate(10, 10), new ShapeCoordinate(12, 0));

    // Act
    ShapeRelationship relationship = rule.calculateRelationship(rectangle1, rectangle2);

    // Assert
    Assert.assertEquals(ShapeRelationship.ROTATED, relationship);
  }

  @Test
  public void calculateRelationship_notRotated() {
    // Assemble
    Rectangle rectangle1 = new Rectangle(new ShapeCoordinate(0, 2), new ShapeCoordinate(10, 0));
    Rectangle rectangle2 = new Rectangle(new ShapeCoordinate(10, 10), new ShapeCoordinate(14, 0));

    // Act
    ShapeRelationship relationship = rule.calculateRelationship(rectangle1, rectangle2);

    // Assert
    Assert.assertEquals(ShapeRelationship.NONE, relationship);
  }
}
