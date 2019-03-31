package com.nuvalence.shaperelationship.rectangle.rules;

import com.nuvalence.shaperelationship.enums.ShapeRelationship;
import com.nuvalence.shaperelationship.rectangle.dto.Rectangle;
import com.nuvalence.shaperelationship.rules.RelationshipRule;

public class EqualAreaRuleImpl implements RelationshipRule<Rectangle> {

  @Override
  public ShapeRelationship calculateRelationship(Rectangle shape1, Rectangle shape2) {
    if(shape1.getArea() == shape2.getArea()) {
      return ShapeRelationship.EQUAL_AREA;
    } else {
      return ShapeRelationship.NONE;
    }
  }
}
