package com.workintech.course.exceptions;

import com.workintech.course.entity.Course;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

public class CourseValidation {
    public static void checkCourseIsValid(Course course) {
        if((course.getCredit() < 0 || course.getCredit() > 4) || course.getName() == null || course.getName().isEmpty()) {
            throw new CourseException("Course credentials are not valid", HttpStatus.BAD_REQUEST);
        }
    }

    public static void isIdValid(int id) {
        if(id <= 0) {
            throw new CourseException("Id is not valid ", HttpStatus.BAD_REQUEST);
        }
    }

    public static void isDuplicateNameFound(List<Course> courses, String name) {
        Optional<Course> foundCourse = courses.stream().filter(c -> c.getName().equals(name)).findFirst();
        if(foundCourse.isPresent()) {
            throw new CourseException("Course is already exist " + name, HttpStatus.BAD_REQUEST);
        }
    }
}
