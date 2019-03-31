package com.nuvalence.shaperelationship.rectangle.rules;

import com.nuvalence.shaperelationship.enums.ShapeRelationship;
import com.nuvalence.shaperelationship.rectangle.dto.Rectangle;
import com.nuvalence.shaperelationship.rules.RelationshipRule;

public class RotationRuleImpl implements RelationshipRule<Rectangle> {

  @Override
  public ShapeRelationship calculateRelationship(Rectangle shape1, Rectangle shape2) {
    if(shape1.getLength() == shape2.getWidth() && shape1.getWidth() == shape2.getLength()){
      return ShapeRelationship.ROTATED;
    } else {
      return ShapeRelationship.NONE;
    }
  }
}
