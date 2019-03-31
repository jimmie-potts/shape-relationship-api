package com.nuvalence.shaperelationship.rectangle.rules;

import com.nuvalence.shaperelationship.enums.ShapeRelationship;
import com.nuvalence.shaperelationship.rectangle.dto.Rectangle;
import com.nuvalence.shaperelationship.rules.RelationshipRule;

public class AdjacentRuleImpl implements RelationshipRule<Rectangle> {

  @Override
  public ShapeRelationship calculateRelationship(Rectangle rect1, Rectangle rect2) {
    if (rect1.getBottomRight().getX().equals(rect2.getUpperLeft().getX())
        || rect1.getUpperLeft().getX().equals(rect2.getBottomRight().getX())) {
      if (hasSharedWall(
          rect1.getBottomRight().getY(),
          rect1.getUpperLeft().getY(),
          rect2.getBottomRight().getY(),
          rect2.getUpperLeft().getY())) {
        return ShapeRelationship.ADJACENT;
      }
    }
    if (rect1.getBottomRight().getY().equals(rect2.getUpperLeft().getY())
        || rect1.getUpperLeft().getY().equals(rect2.getBottomRight().getY())) {
      if (hasSharedWall(
          rect1.getUpperLeft().getX(),
          rect1.getBottomRight().getX(),
          rect2.getUpperLeft().getX(),
          rect2.getBottomRight().getX())) {
        return ShapeRelationship.ADJACENT;
      }
    }
    return ShapeRelationship.NONE;
  }

  protected boolean hasSharedWall(int a, int b, int x, int y) {
    if (b > x || y > a) {
      return true;
    }
    return false;
  }
}
