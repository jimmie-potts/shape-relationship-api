package com.nuvalence.shaperelationship.rectangle.dto;

import com.nuvalence.shaperelationship.enums.ShapeRelationship;
import java.util.Set;

public class RectangleRelationshipResponse {
  private Set<ShapeRelationship> shapeRelationships;

  private RectangleRelationshipResponse() {}

  public RectangleRelationshipResponse(Set<ShapeRelationship> shapeRelationships) {
    this.shapeRelationships = shapeRelationships;
  }

  public Set<ShapeRelationship> getShapeRelationships() {
    return shapeRelationships;
  }

  public void setShapeRelationships(Set<ShapeRelationship> shapeRelationships) {
    this.shapeRelationships = shapeRelationships;
  }

  @Override
  public String toString() {
    return "RectangleRelationshipResponse{" + "shapeRelationships=" + shapeRelationships + '}';
  }
}
