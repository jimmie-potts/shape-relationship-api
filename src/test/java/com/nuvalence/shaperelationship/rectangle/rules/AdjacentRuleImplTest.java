package com.nuvalence.shaperelationship.rectangle.rules;

import com.nuvalence.shaperelationship.dto.ShapeCoordinate;
import com.nuvalence.shaperelationship.enums.ShapeRelationship;
import com.nuvalence.shaperelationship.rectangle.dto.Rectangle;
import org.junit.Assert;
import org.junit.Test;

public class AdjacentRuleImplTest {

  AdjacentRuleImpl rule = new AdjacentRuleImpl();

  @Test
  public void calculateRelationship_notAdjacent() {
    // Assemble
    Rectangle rectangle1 = new Rectangle(new ShapeCoordinate(0, 3), new ShapeCoordinate(3, 0));
    Rectangle rectangle2 = new Rectangle(new ShapeCoordinate(4, 3), new ShapeCoordinate(6, 0));

    // Act
    ShapeRelationship relationship = rule.calculateRelationship(rectangle1, rectangle2);

    // Assert
    Assert.assertEquals(ShapeRelationship.NONE, relationship);
  }

  @Test
  public void calculateRelationship_adjacent() {
    // Assemble
    Rectangle rectangle1 = new Rectangle(new ShapeCoordinate(0, 3), new ShapeCoordinate(3, 0));
    Rectangle rectangle2 = new Rectangle(new ShapeCoordinate(3, 3), new ShapeCoordinate(6, 0));

    // Act
    ShapeRelationship relationship = rule.calculateRelationship(rectangle1, rectangle2);

    // Assert
    Assert.assertEquals(ShapeRelationship.ADJACENT, relationship);
  }
}
