package org.excavator.boot.reactive

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class CourseApplication
object CourseApplication {

  def main(args: Array[String]): Unit = {
    SpringApplication.run(classOf[CourseApplication], args:_*)
  }
}
