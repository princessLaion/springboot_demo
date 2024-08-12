package com.lrp.springboot.learn_spring_boot.controller;

import com.lrp.springboot.learn_spring_boot.model.Course;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CourseV1Controller {


    /**
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
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, path = "/coursesv1")
    public List<Course> retrieveCourses() {
        return List.of(
                new Course(1, "Learn AWS", "Learn Cloud Practitioner"),
                new Course(1, "Learn DevOps", "DevOps 101")

                );
    }

}
