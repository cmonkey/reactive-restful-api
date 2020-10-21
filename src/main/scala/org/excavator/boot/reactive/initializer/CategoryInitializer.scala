package org.excavator.boot.reactive.initializer

import java.util

import org.excavator.boot.reactive.entity.Category
import org.excavator.boot.reactive.repository.ICategoryRepository
import org.slf4j.LoggerFactory
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component

@Component
class CategoryInitializer(repository:ICategoryRepository) extends ApplicationListener[ApplicationReadyEvent]{

  val log = LoggerFactory.getLogger(classOf[CategoryInitializer])

  log.info("Run CategoryInitializer ....")

  override 
  def onApplicationEvent(applicationReadyEvent:ApplicationReadyEvent) = {
    if(repository.count > 0){
      log.info("Category items already created.")
    }else{
      val categorise = new util.ArrayList[Category](){
        add(new Category("Bootcamp"))
        add(new Category("Circuit Training"))
        add(new Category("Gymanastics"))
        add(new Category("Outdoor"))
        add(new Category("Weight Training"))
      }

      categorise.forEach(category => {
        repository.save(category)
        log.info("Category []i saved. ID: {}", category.getTitle, category.getId)
      })
    }

  }
}
