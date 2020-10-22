package org.excavator.boot.reactive.mapper

import org.excavator.boot.reactive.entity.{Course, CreateCourse}

class CourseMapper {
  def entityToDto(c: Course)  = c

  def commandToEntity(command: CreateCourse) = command

}
