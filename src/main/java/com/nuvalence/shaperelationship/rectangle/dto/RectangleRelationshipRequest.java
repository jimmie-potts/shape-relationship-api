package com.nuvalence.shaperelationship.rectangle.dto;

import com.nuvalence.shaperelationship.enums.ShapeRelationship;
import java.util.Set;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Valid
public class RectangleRelationshipRequest {
  @Valid @NotNull private Rectangle rectangle1;
  @Valid @NotNull private Rectangle rectangle2;
  private Set<ShapeRelationship> relationshipsToEvaluate;

  private RectangleRelationshipRequest() {}

  public RectangleRelationshipRequest(
      Rectangle rectangle1, Rectangle rectangle2, Set<ShapeRelationship> relationshipsToEvaluate) {
    this.rectangle1 = rectangle1;
    this.rectangle2 = rectangle2;
    this.relationshipsToEvaluate = relationshipsToEvaluate;
  }

  public Rectangle getRectangle1() {
    return rectangle1;
  }

  public Rectangle getRectangle2() {
    return rectangle2;
  }

  public Set<ShapeRelationship> getRelationshipsToEvaluate() {
    return relationshipsToEvaluate;
  }

  @Override
  public String toString() {
    return "RectangleRelationshipRequest{"
        + "rectangle1="
        + rectangle1
        + ", rectangle2="
        + rectangle2
        + '}';
  }
}
