package com.nuvalence.shaperelationship.rectangle.controller;

import com.nuvalence.shaperelationship.enums.ShapeRelationship;
import com.nuvalence.shaperelationship.rectangle.dto.RectangleRelationshipRequest;
import com.nuvalence.shaperelationship.rectangle.dto.RectangleRelationshipResponse;
import com.nuvalence.shaperelationship.rectangle.service.RectangleRelationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rectangle")
public class RectangleController {
  private final RectangleRelationService service;

  @Autowired
  public RectangleController(RectangleRelationService service) {
    this.service = service;
  }

  @RequestMapping(path = "/evaluate", method = RequestMethod.POST)
  @ApiOperation(
      value = "Evaluate possible relationships between two Rectangles",
      notes = "To evaluate all possible Relationships, leave relationshipsToEvaluate null")
  @ApiResponses({
    @ApiResponse(code = 200, message = "Success", response = RectangleRelationshipResponse.class)
  })
  public ResponseEntity<?> evaluate(@RequestBody @Valid RectangleRelationshipRequest request) {
    service.buildRulesSet(request.getRelationshipsToEvaluate());

    Set<ShapeRelationship> relationships =
        service.evaluate(request.getRectangle1(), request.getRectangle2());

    return ResponseEntity.ok(new RectangleRelationshipResponse(relationships));
  }
}
