package com.nuvalence.shaperelationship.rectangle.dto;

public class RectangleRelationshipRequest {
  private Rectangle rectangle1;
  private Rectangle rectangle2;

  private RectangleRelationshipRequest() {}

  public RectangleRelationshipRequest(Rectangle rectangle1, Rectangle rectangle2) {
    this.rectangle1 = rectangle1;
    this.rectangle2 = rectangle2;
  }

  public Rectangle getRectangle1() {
    return rectangle1;
  }

  public Rectangle getRectangle2() {
    return rectangle2;
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
