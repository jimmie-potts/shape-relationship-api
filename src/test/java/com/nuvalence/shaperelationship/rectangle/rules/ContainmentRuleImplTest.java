package com.nuvalence.shaperelationship.rectangle.rules;

import com.nuvalence.shaperelationship.dto.ShapeCoordinate;
import com.nuvalence.shaperelationship.enums.ShapeRelationship;
import com.nuvalence.shaperelationship.rectangle.dto.Rectangle;
import org.junit.Assert;
import org.junit.Test;

public class ContainmentRuleImplTest {
  ContainmentRuleImpl rule = new ContainmentRuleImpl();

  @Test
  public void calculateRelationship_containment() {
    // Assemble
    Rectangle rectangle1 = new Rectangle(new ShapeCoordinate(0, 3), new ShapeCoordinate(3, 0));
    Rectangle rectangle2 = new Rectangle(new ShapeCoordinate(1, 2), new ShapeCoordinate(2, 1));

    // Act
    ShapeRelationship relationship = rule.calculateRelationship(rectangle1, rectangle2);

    // Assert
    Assert.assertEquals(ShapeRelationship.CONTAINMENT, relationship);
  }

  @Test
  public void calculateRelationship_noContainment() {
    // Assemble
    Rectangle rectangle1 = new Rectangle(new ShapeCoordinate(-2, 2), new ShapeCoordinate(2, 0 - 2));
    Rectangle rectangle2 = new Rectangle(new ShapeCoordinate(-3, 6), new ShapeCoordinate(1, 3));

    // Act
    ShapeRelationship relationship = rule.calculateRelationship(rectangle1, rectangle2);

    // Assert
    Assert.assertEquals(ShapeRelationship.NONE, relationship);
  }

  @Test
  public void calculateRelationship_containment_noContainment_withIntersection() {
    // Assemble
    Rectangle rectangle1 = new Rectangle(new ShapeCoordinate(-5, 5), new ShapeCoordinate(5, -1));
    Rectangle rectangle2 = new Rectangle(new ShapeCoordinate(-4, 10), new ShapeCoordinate(2, 1));

    // Act
    ShapeRelationship relationship = rule.calculateRelationship(rectangle1, rectangle2);

    // Assert
    Assert.assertEquals(ShapeRelationship.NONE, relationship);
  }

  @Test
  public void calculateRelationship_noContainment_withAdjacent() {
    // Assemble
    Rectangle rectangle1 = new Rectangle(new ShapeCoordinate(0, 3), new ShapeCoordinate(3, 0));
    Rectangle rectangle2 = new Rectangle(new ShapeCoordinate(3, 3), new ShapeCoordinate(6, 0));

    // Act
    ShapeRelationship relationship = rule.calculateRelationship(rectangle1, rectangle2);

    // Assert
    Assert.assertEquals(ShapeRelationship.NONE, relationship);
  }
}
