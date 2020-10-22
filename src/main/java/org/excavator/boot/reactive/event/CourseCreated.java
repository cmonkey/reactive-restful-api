package org.excavator.boot.reactive.event;

import lombok.Getter;
import org.excavator.boot.reactive.entity.Course;
import org.springframework.context.ApplicationEvent;

@Getter
public class CourseCreated extends ApplicationEvent {
    public CourseCreated(Course course){
        super(course);
    }
}
