package com.nuvalence.shaperelationship.rectangle.service;

import com.nuvalence.shaperelationship.enums.ShapeRelationship;
import com.nuvalence.shaperelationship.rectangle.dto.Rectangle;
import com.nuvalence.shaperelationship.rectangle.rules.AdjacentRuleImpl;
import com.nuvalence.shaperelationship.rectangle.rules.ContainmentRuleImpl;
import com.nuvalence.shaperelationship.rectangle.rules.IntersectionRuleImpl;
import com.nuvalence.shaperelationship.rules.RelationshipRule;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class RectangleRelationServiceImpl implements RectangleRelationService {
  private final List<RelationshipRule> rules;

  public RectangleRelationServiceImpl() {
    this.rules = new ArrayList<>();
    this.rules.add(new ContainmentRuleImpl());
    this.rules.add(new IntersectionRuleImpl());
    this.rules.add(new AdjacentRuleImpl());
  }

  @Override
  public ShapeRelationship analyze(Rectangle rectangle1, Rectangle rectangle2) {
    ShapeRelationship relationship = ShapeRelationship.NONE;
    for (RelationshipRule rule : rules) {
      relationship = rule.calculateRelationship(rectangle1, rectangle2);
      if (relationship != ShapeRelationship.NONE) {
        return relationship;
      }
    }

    return relationship;
  }
}
