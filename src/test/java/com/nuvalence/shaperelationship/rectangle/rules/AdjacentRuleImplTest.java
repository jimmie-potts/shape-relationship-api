package com.nuvalence.shaperelationship.rectangle.rules;

import com.nuvalence.shaperelationship.dto.ShapeCoordinate;
import com.nuvalence.shaperelationship.enums.ShapeRelationship;
import com.nuvalence.shaperelationship.rectangle.dto.Rectangle;
import org.junit.Assert;
import org.junit.Test;

public class AdjacentRuleImplTest {

  AdjacentRuleImpl rule = new AdjacentRuleImpl();

  @Test
  public void calculateRelationship() {
    Rectangle rectangle1 = new Rectangle(new ShapeCoordinate(0, 3), new ShapeCoordinate(3, 0));
    Rectangle rectangle2 = new Rectangle(new ShapeCoordinate(4, 3), new ShapeCoordinate(6, 0));

    ShapeRelationship relationship = rule.calculateRelationship(rectangle1, rectangle2);

    Assert.assertEquals(ShapeRelationship.NONE, relationship);
  }

  @Test
  public void getSharedCoordinates() {
    int[] test = rule.getSharedCoordinates(8, 1, 3, 8);
    Assert.assertEquals(3, test[0]);
    Assert.assertEquals(8, test[1]);
  }
}
