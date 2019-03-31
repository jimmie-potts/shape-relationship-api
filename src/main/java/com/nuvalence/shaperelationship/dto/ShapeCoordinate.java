package com.nuvalence.shaperelationship.dto;

public class ShapeCoordinate {
  private Integer x;
  private Integer y;

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
