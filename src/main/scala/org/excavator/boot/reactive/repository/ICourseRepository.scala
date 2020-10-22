package org.excavator.boot.reactive.repository

import java.util.UUID

import org.excavator.boot.reactive.entity.Course
import org.springframework.data.jpa.repository.JpaRepository

trait ICourseRepository extends JpaRepository[Course, UUID]{

}
