package com.nuvalence.shaperelationship.rectangle.dto;

import com.nuvalence.shaperelationship.dto.ShapeCoordinate;

public class Rectangle {
  private ShapeCoordinate upperLeft;
  private ShapeCoordinate bottomRight;

  private Rectangle() {}

  public Rectangle(ShapeCoordinate upperLeft, ShapeCoordinate bottomRight) {
    this.upperLeft = upperLeft;
    this.bottomRight = bottomRight;
  }

  public ShapeCoordinate getUpperLeft() {
    return upperLeft;
  }

  public ShapeCoordinate getBottomRight() {
    return bottomRight;
  }

  @Override
  public String toString() {
    return "Rectangle{" + "upperLeft=" + upperLeft + ", bottomRight=" + bottomRight + '}';
  }
}
