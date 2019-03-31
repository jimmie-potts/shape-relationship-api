package com.nuvalence.shaperelationship.rectangle.rules;

import com.nuvalence.shaperelationship.enums.ShapeRelationship;
import com.nuvalence.shaperelationship.rectangle.dto.Rectangle;
import com.nuvalence.shaperelationship.rules.RelationshipRule;

public class AdjacentRuleImpl implements RelationshipRule<Rectangle> {

  @Override
  public ShapeRelationship calculateRelationship(Rectangle rect1, Rectangle rect2) {
    if (rect1.getBottomRight().getX() == rect2.getUpperLeft().getX()
        || rect1.getUpperLeft().getX() == rect2.getBottomRight().getX()) {
      if (rect1.getUpperLeft().getY() < rect2.getBottomRight().getY()
          || rect2.getUpperLeft().getY() < rect1.getBottomRight().getY()) {
        return ShapeRelationship.NONE;
      } else {
        int[] shared =
            getSharedCoordinates(
                rect1.getBottomRight().getY(),
                rect1.getUpperLeft().getY(),
                rect2.getBottomRight().getY(),
                rect2.getUpperLeft().getY());

        return ShapeRelationship.ADJANCENT;
      }
    } else if (rect1.getBottomRight().getY() == rect2.getUpperLeft().getY()
        || rect1.getUpperLeft().getY() == rect2.getBottomRight().getY()) {
      if(rect1.getBottomRight().getX() < rect2.getUpperLeft().getX() ||
          rect2.getBottomRight().getX() < rect1.getUpperLeft().getX()) {
        return ShapeRelationship.NONE;
      } else {
        int[] shared =
            getSharedCoordinates(
                rect1.getUpperLeft().getX(),
                rect1.getBottomRight().getX(),
                rect2.getUpperLeft().getX(),
                rect2.getBottomRight().getX());
      }
      return ShapeRelationship.ADJANCENT;
    } else {
      return ShapeRelationship.NONE;
    }

//    if (rect1.getBottomRight().getX() == rect2.getUpperLeft().getX()
//        || rect1.getUpperLeft().getX() == rect2.getBottomRight().getX()
//        || rect1.getBottomRight().getY() == rect2.getUpperLeft().getY()
//        || rect1.getUpperLeft().getY() == rect2.getBottomRight().getY()) {
//      return ShapeRelationship.ADJANCENT;
//    } else {
//      return ShapeRelationship.NONE;
//    }
  }
  // (0, 7)  (3, 5)
  public int[] getSharedCoordinates(int a, int b, int x, int y) {
    int start = 0;
    int end = 0;

    if (b > x) {
      if (a > x) {
        start = a;
      } else {
        start = x;
      }
    } else if (y > a) {
      if (x > a) {
        start = x;
      } else {
        start = a;
      }
    }

    if (a < y) {
      if (b < y) {
        end = b;
      } else {
        end = y;
      }
    } else if (x < b) {
      if (y < b) {
        end = y;
      } else {
        end = b;
      }
    }

    return new int[] {start, end};
  }
}
