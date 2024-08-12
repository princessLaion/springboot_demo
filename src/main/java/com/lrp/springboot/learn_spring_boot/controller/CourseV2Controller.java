package com.lrp.springboot.learn_spring_boot.controller;

import com.lrp.springboot.learn_spring_boot.model.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseV2Controller {


    /**
     * method is to limit the HTTP method to GET only.
     *
     * Output:
     * [
     * {
     * "id": 1,
     * "name": "Learn AWS",
     * "description": "Learn Cloud Practitioner"
     * },
     * {
     * "id": 1,
     * "name": "Learn DevOps",
     * "description": "DevOps 101"
     * }
     * ]
     * @return
     */

    //Another Option: @RequestMapping(method = RequestMethod.GET, path = "/coursesv2")
    @GetMapping(path = "/coursesv2")
    public List<Course> retrieveCourses() {
        return List.of(
                new Course(1, "dddd Learn AWS", "Learn Cloud Practitioner"),
                new Course(2, "Learn DevOps", "DevOps 101")

                );
    }

}
