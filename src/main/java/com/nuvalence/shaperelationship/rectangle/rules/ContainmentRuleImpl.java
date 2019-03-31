package com.nuvalence.shaperelationship.rectangle.rules;

import com.nuvalence.shaperelationship.enums.ShapeRelationship;
import com.nuvalence.shaperelationship.rectangle.dto.Rectangle;
import com.nuvalence.shaperelationship.rules.RelationshipRule;

public class ContainmentRuleImpl implements RelationshipRule<Rectangle> {

  @Override
  public ShapeRelationship calculateRelationship(Rectangle rect1, Rectangle rect2) {
    if (rect1.getUpperLeft().getX() > rect2.getUpperLeft().getX()
        && rect1.getBottomRight().getX() < rect2.getBottomRight().getX()
        && rect1.getUpperLeft().getY() < rect2.getUpperLeft().getY()
        && rect1.getBottomRight().getY() > rect2.getBottomRight().getY()) {

      // Rect1 is contained in Rect2
      return ShapeRelationship.CONTAINMENT;
    } else if (rect2.getUpperLeft().getX() > rect1.getUpperLeft().getX()
        && rect2.getBottomRight().getX() < rect1.getBottomRight().getX()
        && rect2.getUpperLeft().getY() < rect1.getUpperLeft().getY()
        && rect2.getBottomRight().getY() > rect1.getBottomRight().getY()) {

      // Rect2 is contained in Rect1
      return ShapeRelationship.CONTAINMENT;
    } else {
      return ShapeRelationship.NONE;
    }
  }
}
