package com.nuvalence.shaperelationship.rectangle.rules;

import com.nuvalence.shaperelationship.enums.ShapeRelationship;
import com.nuvalence.shaperelationship.rectangle.dto.Rectangle;
import com.nuvalence.shaperelationship.rules.RelationshipRule;

public class EqualEdgeRuleImpl implements RelationshipRule<Rectangle> {

  @Override
  public ShapeRelationship calculateRelationship(Rectangle shape1, Rectangle shape2) {
    if(shape1.getPerimeter() == shape2.getPerimeter()) {
      return ShapeRelationship.EQUAL_EDGE_LENGTH;
    } else {
      return ShapeRelationship.NONE;
    }
  }
}
