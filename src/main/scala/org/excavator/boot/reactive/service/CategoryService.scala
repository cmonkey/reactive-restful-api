package org.excavator.boot.reactive.service

import java.util.UUID
import java.util.stream.Collectors

import org.excavator.boot.reactive.mapper.CategoryMapper
import org.excavator.boot.reactive.repository.ICategoryRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.util.Assert

@Service
class CategoryService(repository:ICategoryRepository, mapper:CategoryMapper) {

  val log = LoggerFactory.getLogger(classOf[CategoryService])

  def getById(id: UUID) = {
    Assert.notNull(id, "The given id must not be null")

    log.debug("Try to get Category with id {}", id)

    val category = repository.getOne(id)

    if(null == category){
      log.error("Category with id {} does not exist.", id)
      null
    }

    log.debug("Category {} with id {} was found.", category.getTitle(), id)

    category
  }

  def getCategories() = {
    repository.findAll.stream.map( c => mapper.entityToDto(c))
    .collect(Collectors.toList)
  }

}
