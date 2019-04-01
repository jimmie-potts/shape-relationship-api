package com.nuvalence.shaperelationship.rectangle.rules;

import com.nuvalence.shaperelationship.enums.ShapeRelationship;
import com.nuvalence.shaperelationship.rectangle.dto.Rectangle;
import com.nuvalence.shaperelationship.rules.RelationshipRule;

public class IntersectionRuleImpl implements RelationshipRule<Rectangle> {
  private final RelationshipRule<Rectangle> containmentRule;

  public IntersectionRuleImpl(RelationshipRule<Rectangle> containmentRule) {
    this.containmentRule = containmentRule;
  }

  @Override
  public ShapeRelationship calculateRelationship(Rectangle rect1, Rectangle rect2) {
    if (rect1.getUpperLeft().getX() < rect2.getBottomRight().getX()
        && rect1.getBottomRight().getX() > rect2.getUpperLeft().getX()
        && rect1.getUpperLeft().getY() > rect2.getBottomRight().getY()
        && rect1.getBottomRight().getY() < rect2.getUpperLeft().getY()
        && containmentRule.calculateRelationship(rect1, rect2) != ShapeRelationship.CONTAINMENT) {
      return ShapeRelationship.INTERSECTION;
    } else {
      return ShapeRelationship.NONE;
    }
  }
}
