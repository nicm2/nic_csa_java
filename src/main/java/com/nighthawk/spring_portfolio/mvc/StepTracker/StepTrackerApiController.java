package com.nighthawk.spring_portfolio.mvc.StepTracker;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping("/api/step")
public class StepTrackerApiController {

    /** GET isLeapYear endpoint
     * ObjectMapper throws exceptions on bad JSON
     *  @throws JsonProcessingException
     *  @throws JsonMappingException
     */
    @GetMapping("/addDailySteps/{number_of_steps}")
    public ResponseEntity<JsonNode> getaddDailySteps(@PathVariable int number_of_steps) throws JsonMappingException, JsonProcessingException {
      // Backend Year Object
      Step step_obj = new Step();
      step_obj.setStep(number_of_steps);  // evaluates Leap Year

      // Turn Year Object into JSON
      ObjectMapper mapper = new ObjectMapper(); 
      JsonNode json = mapper.readTree(step_obj.addDailyStepsToString()); // this requires exception handling

      return ResponseEntity.ok(json);  // JSON response, see ExceptionHandlerAdvice for throws
    }

}
