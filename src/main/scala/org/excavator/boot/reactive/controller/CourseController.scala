package org.excavator.boot.reactive.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.{GetMapping, RestController}

@RestController
class CourseController {

  @GetMapping(Array("/"))
  def get() = {
    ResponseEntity.ok().body("Course Service is running.")
  }


}
