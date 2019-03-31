package com.nuvalence.shaperelationship.rectangle.controller;

import com.nuvalence.shaperelationship.enums.ShapeRelationship;
import com.nuvalence.shaperelationship.rectangle.dto.RectangleRelationshipRequest;
import com.nuvalence.shaperelationship.rectangle.dto.RectangleRelationshipResponse;
import com.nuvalence.shaperelationship.rectangle.service.RectangleRelationService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RectangleController {
  private final RectangleRelationService service;

  @Autowired
  public RectangleController(RectangleRelationService service) {
    this.service = service;
  }

  @RequestMapping(path = "/analyze", method = RequestMethod.POST)
  public ResponseEntity<?> analyze(@RequestBody @Valid RectangleRelationshipRequest request) {
    ShapeRelationship relationship =
        service.analyze(request.getRectangle1(), request.getRectangle2());

    return ResponseEntity.ok(new RectangleRelationshipResponse(relationship));
  }
}
