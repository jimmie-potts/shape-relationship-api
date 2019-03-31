package com.nuvalence.shaperelationship.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Valid
public class ShapeCoordinate {
  @NotNull private Integer x;
  @NotNull private Integer y;

  private ShapeCoordinate() {}

  public ShapeCoordinate(Integer x, Integer y) {
    this.x = x;
    this.y = y;
  }

  public Integer getX() {
    return x;
  }

  public Integer getY() {
    return y;
  }
}
