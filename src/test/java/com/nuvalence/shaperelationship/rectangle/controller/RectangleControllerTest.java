package com.nuvalence.shaperelationship.rectangle.controller;

import static org.mockito.ArgumentMatchers.any;

import com.nuvalence.shaperelationship.dto.ShapeCoordinate;
import com.nuvalence.shaperelationship.rectangle.dto.Rectangle;
import com.nuvalence.shaperelationship.rectangle.dto.RectangleRelationshipRequest;
import com.nuvalence.shaperelationship.rectangle.service.RectangleRelationService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RunWith(MockitoJUnitRunner.class)
public class RectangleControllerTest {
  @Mock RectangleRelationService service;

  @Test
  public void evaluate() {
    // Assemble
    RectangleController rectangleController = new RectangleController(service);

    Rectangle rect1 = new Rectangle(new ShapeCoordinate(0, 5), new ShapeCoordinate(5, 0));
    Rectangle rect2 = new Rectangle(new ShapeCoordinate(0, 5), new ShapeCoordinate(5, 0));
    RectangleRelationshipRequest request = new RectangleRelationshipRequest(rect1, rect2, null);

    // Act
    ResponseEntity response = rectangleController.evaluate(request);

    // Assert
    Mockito.verify(service).buildRulesSet(null);
    Mockito.verify(service).evaluate(any(Rectangle.class), any(Rectangle.class));
    Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    Assert.assertTrue(response.hasBody());
  }
}
