package org.excavator.boot.reactive.service

import java.util.stream.Collectors

import org.excavator.boot.reactive.mapper.CourseMapper
import org.excavator.boot.reactive.repository.ICourseRepository
import org.excavator.boot.reactive.entity.{Course, CreateCourse}
import org.excavator.boot.reactive.event.CourseCreated
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import org.springframework.util.Assert

@Service
class CourseService(courseRepository:ICourseRepository, publisher:ApplicationEventPublisher, mapper:CourseMapper) {

  val log = LoggerFactory.getLogger(classOf[CourseService])

  def createCourse(command:CreateCourse) = {
    Assert.notNull(command, "The given command must not be null")

    log.debug("Try to create new course {} requested by {}", command.getTitle, command.getCreatedByUserId)
    val course = mapper.commandToEntity(command)

    val savedCourse = courseRepository.save(course).asInstanceOf[Course]

    //log.debug("Course {} saved to database Created timestamp {}", savedCourse.getId, savedCourse.getDateCreated())

    publisher.publishEvent(new CourseCreated(savedCourse))

    savedCourse
  }

  def getCourses() = {
    courseRepository.findAll().stream.map(c => mapper.entityToDto(c)).collect(Collectors.toList)
  }

}
