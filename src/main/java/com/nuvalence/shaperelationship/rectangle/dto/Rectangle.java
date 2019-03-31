package com.nuvalence.shaperelationship.rectangle.dto;

import com.nuvalence.shaperelationship.dto.ShapeCoordinate;
import com.nuvalence.shaperelationship.rectangle.validator.ValidCoordinates;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Valid
@ValidCoordinates(upperLeft = "upperLeft", bottomRight = "bottomRight")
public class Rectangle {
  @NotNull private ShapeCoordinate upperLeft;
  @NotNull private ShapeCoordinate bottomRight;

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
