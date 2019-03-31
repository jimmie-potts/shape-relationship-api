package com.nuvalence.shaperelationship.rectangle.service;

import com.nuvalence.shaperelationship.enums.ShapeRelationship;
import com.nuvalence.shaperelationship.rectangle.dto.Rectangle;

public interface RectangleRelationService {
  ShapeRelationship analyze(Rectangle rectangle1, Rectangle rectangle2);
}
