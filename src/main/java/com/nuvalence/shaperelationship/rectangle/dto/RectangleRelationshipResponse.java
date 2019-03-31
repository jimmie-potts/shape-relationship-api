package com.nuvalence.shaperelationship.rectangle.dto;

import com.nuvalence.shaperelationship.enums.ShapeRelationship;

public class RectangleRelationshipResponse {
  private ShapeRelationship shapeRelationship;

  private RectangleRelationshipResponse() {}

  public RectangleRelationshipResponse(ShapeRelationship shapeRelationship) {
    this.shapeRelationship = shapeRelationship;
  }

  public ShapeRelationship getShapeRelationship() {
    return shapeRelationship;
  }

  public void setShapeRelationship(ShapeRelationship shapeRelationship) {
    this.shapeRelationship = shapeRelationship;
  }

  @Override
  public String toString() {
    return "RectangleRelationshipResponse{" + "shapeRelationship=" + shapeRelationship + '}';
  }
}
