package com.nuvalence.shaperelationship.rectangle.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.nuvalence.shaperelationship.dto.ShapeCoordinate;
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
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RectangleRelationServiceImplTest {
  @Mock RelationshipRule mockRule;

  @Test
  public void buildRulesSet_withNull() {
    // Assemble
    RectangleRelationServiceImpl service = new RectangleRelationServiceImpl();
    Set<ShapeRelationship> relationshipsToEvaluate = null;

    // Act
    service.buildRulesSet(relationshipsToEvaluate);

    // Assert
    Assert.assertEquals(6, service.rules.size());
  }

  @Test
  public void buildRulesSet_withEmpty() {
    // Assemble
    RectangleRelationServiceImpl service = new RectangleRelationServiceImpl();
    Set<ShapeRelationship> relationshipsToEvaluate = new HashSet<>();

    // Act
    service.buildRulesSet(relationshipsToEvaluate);

    // Assert
    Assert.assertEquals(6, service.rules.size());
  }

  @Test
  public void buildRulesSet_withContainment() {
    // Assemble
    RectangleRelationServiceImpl service = new RectangleRelationServiceImpl();
    Set<ShapeRelationship> relationshipsToEvaluate = new HashSet<>();
    relationshipsToEvaluate.add(ShapeRelationship.CONTAINMENT);

    // Act
    service.buildRulesSet(relationshipsToEvaluate);

    // Assert
    Assert.assertEquals(1, service.rules.size());
    Assert.assertEquals(ContainmentRuleImpl.class, service.rules.get(0).getClass());
  }

  @Test
  public void buildRulesSet_withIntersection() {
    // Assemble
    RectangleRelationServiceImpl service = new RectangleRelationServiceImpl();
    Set<ShapeRelationship> relationshipsToEvaluate = new HashSet<>();
    relationshipsToEvaluate.add(ShapeRelationship.INTERSECTION);

    // Act
    service.buildRulesSet(relationshipsToEvaluate);

    // Assert
    Assert.assertEquals(1, service.rules.size());
    Assert.assertEquals(IntersectionRuleImpl.class, service.rules.get(0).getClass());
  }

  @Test
  public void buildRulesSet_withAdjacent() {
    // Assemble
    RectangleRelationServiceImpl service = new RectangleRelationServiceImpl();
    Set<ShapeRelationship> relationshipsToEvaluate = new HashSet<>();
    relationshipsToEvaluate.add(ShapeRelationship.ADJANCENT);

    // Act
    service.buildRulesSet(relationshipsToEvaluate);

    // Assert
    Assert.assertEquals(1, service.rules.size());
    Assert.assertEquals(AdjacentRuleImpl.class, service.rules.get(0).getClass());
  }

  @Test
  public void buildRulesSet_withEqualArea() {
    // Assemble
    RectangleRelationServiceImpl service = new RectangleRelationServiceImpl();
    Set<ShapeRelationship> relationshipsToEvaluate = new HashSet<>();
    relationshipsToEvaluate.add(ShapeRelationship.EQUAL_AREA);

    // Act
    service.buildRulesSet(relationshipsToEvaluate);

    // Assert
    Assert.assertEquals(1, service.rules.size());
    Assert.assertEquals(EqualAreaRuleImpl.class, service.rules.get(0).getClass());
  }

  @Test
  public void buildRulesSet_withEqualEdge() {
    // Assemble
    RectangleRelationServiceImpl service = new RectangleRelationServiceImpl();
    Set<ShapeRelationship> relationshipsToEvaluate = new HashSet<>();
    relationshipsToEvaluate.add(ShapeRelationship.EQUAL_EDGE_LENGTH);

    // Act
    service.buildRulesSet(relationshipsToEvaluate);

    // Assert
    Assert.assertEquals(1, service.rules.size());
    Assert.assertEquals(EqualEdgeRuleImpl.class, service.rules.get(0).getClass());
  }

  @Test
  public void buildRulesSet_withRotation() {
    // Assemble
    RectangleRelationServiceImpl service = new RectangleRelationServiceImpl();
    Set<ShapeRelationship> relationshipsToEvaluate = new HashSet<>();
    relationshipsToEvaluate.add(ShapeRelationship.ROTATED);

    // Act
    service.buildRulesSet(relationshipsToEvaluate);

    // Assert
    Assert.assertEquals(1, service.rules.size());
    Assert.assertEquals(RotationRuleImpl.class, service.rules.get(0).getClass());
  }

  @Test
  public void buildRulesSet_withFourRules() {
    // Assemble
    RectangleRelationServiceImpl service = new RectangleRelationServiceImpl();
    Set<ShapeRelationship> relationshipsToEvaluate = new HashSet<>();
    relationshipsToEvaluate.add(ShapeRelationship.INTERSECTION);
    relationshipsToEvaluate.add(ShapeRelationship.ROTATED);
    relationshipsToEvaluate.add(ShapeRelationship.EQUAL_EDGE_LENGTH);
    relationshipsToEvaluate.add(ShapeRelationship.CONTAINMENT);

    // Act
    service.buildRulesSet(relationshipsToEvaluate);

    // Assert
    Assert.assertEquals(4, service.rules.size());
  }

  @Test
  public void evaluate_withNoRelation() {
    // Assemble
    RectangleRelationServiceImpl service = new RectangleRelationServiceImpl();
    when(mockRule.calculateRelationship(any(Rectangle.class), any(Rectangle.class)))
        .thenReturn(ShapeRelationship.NONE);

    List<RelationshipRule> rules = new ArrayList<>();
    rules.add(mockRule);
    service.rules = rules;

    Rectangle rect1 = new Rectangle(new ShapeCoordinate(0, 10), new ShapeCoordinate(10, 0));
    Rectangle rect2 = new Rectangle(new ShapeCoordinate(0, 10), new ShapeCoordinate(10, 0));

    // Act
    Set<ShapeRelationship> result = service.evaluate(rect1, rect2);

    // Assert
    Mockito.verify(mockRule).calculateRelationship(any(Rectangle.class), any(Rectangle.class));
    Assert.assertEquals(1, result.size());
    Assert.assertTrue(result.contains(ShapeRelationship.NONE));
  }

  @Test
  public void evaluate_withRelation() {
    // Assemble
    RectangleRelationServiceImpl service = new RectangleRelationServiceImpl();
    when(mockRule.calculateRelationship(any(Rectangle.class), any(Rectangle.class)))
        .thenReturn(ShapeRelationship.CONTAINMENT);

    List<RelationshipRule> rules = new ArrayList<>();
    rules.add(mockRule);
    service.rules = rules;

    Rectangle rect1 = new Rectangle(new ShapeCoordinate(0, 10), new ShapeCoordinate(10, 0));
    Rectangle rect2 = new Rectangle(new ShapeCoordinate(0, 10), new ShapeCoordinate(10, 0));

    // Act
    Set<ShapeRelationship> result = service.evaluate(rect1, rect2);

    // Assert
    Mockito.verify(mockRule).calculateRelationship(any(Rectangle.class), any(Rectangle.class));
    Assert.assertEquals(1, result.size());
    Assert.assertTrue(result.contains(ShapeRelationship.CONTAINMENT));
  }
}
