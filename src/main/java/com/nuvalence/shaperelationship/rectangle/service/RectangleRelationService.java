package com.nuvalence.shaperelationship.rectangle.service;

import com.nuvalence.shaperelationship.enums.ShapeRelationship;
import com.nuvalence.shaperelationship.rectangle.dto.Rectangle;
import java.util.Set;

public interface RectangleRelationService {
  void buildRulesSet(Set<ShapeRelationship> relationshipsToEvaluate);

  Set<ShapeRelationship> evaluate(Rectangle rectangle1, Rectangle rectangle2);
}
