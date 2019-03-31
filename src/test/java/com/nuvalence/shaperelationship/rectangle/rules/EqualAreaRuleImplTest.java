package com.nuvalence.shaperelationship.rectangle.rules;

import com.nuvalence.shaperelationship.dto.ShapeCoordinate;
import com.nuvalence.shaperelationship.enums.ShapeRelationship;
import com.nuvalence.shaperelationship.rectangle.dto.Rectangle;
import org.junit.Assert;
import org.junit.Test;

public class EqualAreaRuleImplTest {
  EqualAreaRuleImpl rule = new EqualAreaRuleImpl();

  @Test
  public void calculateRelationship_equalArea() {
    // Assemble
    Rectangle rectangle1 = new Rectangle(new ShapeCoordinate(-5, 5), new ShapeCoordinate(5, -5));
    Rectangle rectangle2 =
        new Rectangle(new ShapeCoordinate(27, -100), new ShapeCoordinate(37, -110));

    // Act
    ShapeRelationship relationship = rule.calculateRelationship(rectangle1, rectangle2);

    // Assert
    Assert.assertEquals(ShapeRelationship.EQUAL_AREA, relationship);
  }

  @Test
  public void calculateRelationship_notEqualArea() {
    // Assemble
    Rectangle rectangle1 = new Rectangle(new ShapeCoordinate(0, 5), new ShapeCoordinate(5, -5));
    Rectangle rectangle2 =
        new Rectangle(new ShapeCoordinate(27, -100), new ShapeCoordinate(37, -110));

    // Act
    ShapeRelationship relationship = rule.calculateRelationship(rectangle1, rectangle2);

    // Assert
    Assert.assertEquals(ShapeRelationship.NONE, relationship);
  }
}
