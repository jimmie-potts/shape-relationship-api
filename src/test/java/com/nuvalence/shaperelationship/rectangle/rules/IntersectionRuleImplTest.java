package com.nuvalence.shaperelationship.rectangle.rules;

import com.nuvalence.shaperelationship.dto.ShapeCoordinate;
import com.nuvalence.shaperelationship.enums.ShapeRelationship;
import com.nuvalence.shaperelationship.rectangle.dto.Rectangle;
import org.junit.Assert;
import org.junit.Test;

public class IntersectionRuleImplTest {
  IntersectionRuleImpl rule = new IntersectionRuleImpl(new ContainmentRuleImpl());

  @Test
  public void calculateRelationship_noIntersection_offset() {
    // Assemble
    Rectangle rectangle1 = new Rectangle(new ShapeCoordinate(-2, 2), new ShapeCoordinate(2, -2));
    Rectangle rectangle2 = new Rectangle(new ShapeCoordinate(-3, 6), new ShapeCoordinate(1, 3));

    // Act
    ShapeRelationship relationship = rule.calculateRelationship(rectangle1, rectangle2);

    // Assert
    Assert.assertEquals(ShapeRelationship.NONE, relationship);
  }

  @Test
  public void calculateRelationship_noIntersection_sameY() {
    // Assemble
    Rectangle rectangle1 = new Rectangle(new ShapeCoordinate(0, 3), new ShapeCoordinate(3, 0));
    Rectangle rectangle2 = new Rectangle(new ShapeCoordinate(4, 3), new ShapeCoordinate(7, 0));

    // Act
    ShapeRelationship relationship = rule.calculateRelationship(rectangle1, rectangle2);

    // Assert
    Assert.assertEquals(ShapeRelationship.NONE, relationship);
  }

  @Test
  public void calculateRelationship_noIntersection_sameX() {
    // Assemble
    Rectangle rectangle1 = new Rectangle(new ShapeCoordinate(0, 3), new ShapeCoordinate(3, 0));
    Rectangle rectangle2 = new Rectangle(new ShapeCoordinate(0, 7), new ShapeCoordinate(3, 4));

    // Act
    ShapeRelationship relationship = rule.calculateRelationship(rectangle1, rectangle2);

    // Assert
    Assert.assertEquals(ShapeRelationship.NONE, relationship);
  }

  @Test
  public void calculateRelationship_intersection_twoPoints() {
    // Assemble
    Rectangle rectangle1 = new Rectangle(new ShapeCoordinate(-5, 5), new ShapeCoordinate(5, -1));
    Rectangle rectangle2 = new Rectangle(new ShapeCoordinate(-4, 10), new ShapeCoordinate(2, 1));

    // Act
    ShapeRelationship relationship = rule.calculateRelationship(rectangle1, rectangle2);

    // Assert
    Assert.assertEquals(ShapeRelationship.INTERSECTION, relationship);
  }

  @Test
  public void calculateRelationship_intersection_fourPoints() {
    // Assemble
    Rectangle rectangle1 = new Rectangle(new ShapeCoordinate(-2, 2), new ShapeCoordinate(2, -2));
    Rectangle rectangle2 = new Rectangle(new ShapeCoordinate(-3, 1), new ShapeCoordinate(3, -1));

    // Act
    ShapeRelationship relationship = rule.calculateRelationship(rectangle1, rectangle2);

    // Assert
    Assert.assertEquals(ShapeRelationship.INTERSECTION, relationship);
  }
}
