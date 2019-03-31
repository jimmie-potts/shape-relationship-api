package com.nuvalence.shaperelationship.rules;

import com.nuvalence.shaperelationship.enums.ShapeRelationship;

public interface RelationshipRule<T> {
  ShapeRelationship calculateRelationship(T shape1, T shape2);
}
