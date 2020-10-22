package org.excavator.boot.reactive.controller

import java.net.URI

import javax.validation.Valid
import org.excavator.boot.reactive.entity.CreateCourse
import org.excavator.boot.reactive.service.CourseService
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.{CrossOrigin, GetMapping, PostMapping, RequestBody, RestController}

@RestController
class CourseController(courseService: CourseService) {

  val log = LoggerFactory.getLogger(classOf[CourseController])

  @GetMapping(Array("/"))
  def get() = {
    ResponseEntity.ok().body("Course Service is running.")
  }

  @CrossOrigin
  @PostMapping(Array("/course"))
  def addCourse(@RequestBody @Valid command:CreateCourse) = {
    log.info("Create new course request received, [title: {}]", command.getTitle)

    val course = courseService.createCourse(command)

    ResponseEntity.created(URI.create("/course/" + course.getId.toString)).body(course.getId)
  }



}
