package org.excavator.boot.reactive.repository

import java.util.UUID

import org.excavator.boot.reactive.entity.Category
import org.springframework.data.jpa.repository.JpaRepository

trait ICategoryRepository extends JpaRepository[Category, UUID]{

}
