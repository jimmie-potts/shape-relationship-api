package com.nuvalence.shaperelationship.rectangle.rules;

import com.nuvalence.shaperelationship.dto.ShapeCoordinate;
import com.nuvalence.shaperelationship.enums.ShapeRelationship;
import com.nuvalence.shaperelationship.rectangle.dto.Rectangle;
import org.junit.Assert;
import org.junit.Test;

public class EqualEdgeRuleImplTest {
  EqualEdgeRuleImpl rule = new EqualEdgeRuleImpl();

  @Test
  public void calculateRelationship_equalEdge() {
    // Assemble
    Rectangle rectangle1 = new Rectangle(new ShapeCoordinate(0, 3), new ShapeCoordinate(3, 0));
    Rectangle rectangle2 = new Rectangle(new ShapeCoordinate(0, 2), new ShapeCoordinate(1, -3));

    // Act
    ShapeRelationship relationship = rule.calculateRelationship(rectangle1, rectangle2);

    // Assert
    Assert.assertEquals(ShapeRelationship.EQUAL_EDGE_LENGTH, relationship);
  }

  @Test
  public void calculateRelationship_notEqualEdge() {
    // Assemble
    Rectangle rectangle1 = new Rectangle(new ShapeCoordinate(0, 3), new ShapeCoordinate(3, -1));
    Rectangle rectangle2 = new Rectangle(new ShapeCoordinate(0, 2), new ShapeCoordinate(1, -3));

    // Act
    ShapeRelationship relationship = rule.calculateRelationship(rectangle1, rectangle2);

    // Assert
    Assert.assertEquals(ShapeRelationship.NONE, relationship);
  }
}
