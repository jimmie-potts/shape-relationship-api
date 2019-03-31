package com.nuvalence.shaperelationship.rectangle.service;

import com.nuvalence.shaperelationship.enums.ShapeRelationship;
import com.nuvalence.shaperelationship.rectangle.dto.Rectangle;
import com.nuvalence.shaperelationship.rectangle.rules.AdjacentRuleImpl;
import com.nuvalence.shaperelationship.rectangle.rules.ContainmentRuleImpl;
import com.nuvalence.shaperelationship.rectangle.rules.EqualAreaRuleImpl;
import com.nuvalence.shaperelationship.rectangle.rules.EqualEdgeRuleImpl;
import com.nuvalence.shaperelationship.rectangle.rules.IntersectionRuleImpl;
import com.nuvalence.shaperelationship.rectangle.rules.RotationRuleImpl;
import com.nuvalence.shaperelationship.rules.RelationshipRule;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class RectangleRelationServiceImpl implements RectangleRelationService {
  List<RelationshipRule> rules;

  public RectangleRelationServiceImpl() {}

  @Override
  public void buildRulesSet(Set<ShapeRelationship> relationshipsToEvaluate) {
    this.rules = new ArrayList<>();

    if (relationshipsToEvaluate == null || relationshipsToEvaluate.isEmpty()) {
      this.rules.add(new ContainmentRuleImpl());
      this.rules.add(new IntersectionRuleImpl(new ContainmentRuleImpl()));
      this.rules.add(new AdjacentRuleImpl());
      this.rules.add(new EqualAreaRuleImpl());
      this.rules.add(new EqualEdgeRuleImpl());
      this.rules.add(new RotationRuleImpl());
    } else {
      for (ShapeRelationship r : relationshipsToEvaluate) {
        switch (r) {
          case CONTAINMENT:
            rules.add(new ContainmentRuleImpl());
            break;
          case ADJANCENT:
            rules.add(new AdjacentRuleImpl());
            break;
          case INTERSECTION:
            rules.add(new IntersectionRuleImpl(new ContainmentRuleImpl()));
            break;
          case ROTATED:
            rules.add(new RotationRuleImpl());
            break;
          case EQUAL_AREA:
            rules.add(new EqualAreaRuleImpl());
            break;
          case EQUAL_EDGE_LENGTH:
            rules.add(new EqualEdgeRuleImpl());
            break;
        }
      }
    }
  }

  @Override
  public Set<ShapeRelationship> evaluate(Rectangle rectangle1, Rectangle rectangle2) {

    Set<ShapeRelationship> relationships = new HashSet<>();

    for (RelationshipRule rule : rules) {
      ShapeRelationship relationship = rule.calculateRelationship(rectangle1, rectangle2);

      if (relationship != ShapeRelationship.NONE) {
        relationships.add(relationship);
      }
    }

    if (relationships.isEmpty()) {
      relationships.add(ShapeRelationship.NONE);
    }

    return relationships;
  }
}
