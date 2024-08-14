package com.lrp.springboot.learn_spring_boot.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.lrp.springboot.learn_spring_boot.model.StudentRecord;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for dynamic show / hide of fields.
 */
@RestController
public class StudentController {
    private static StudentRecord student = new StudentRecord("John Smith", "Engineering", "2022");

    /**
     * Only shows name and course fields.
     *
     * @return
     */
    @GetMapping("/students/filter")
    public MappingJacksonValue showFilteredFields () {
        MappingJacksonValue mappingJacksonValue = getMappingForFieldsToDisplay(student, "name", "course");

        return mappingJacksonValue;
    }

    //DOESN'T WORK if StudentRecord bean contains JsonFilter annotation.
    @GetMapping("/students")
    public MappingJacksonValue showAllFields () {
        //This won't work as we specify JsonFilter at the Bean.
        // return  new StudentRecord("Maria Clara", "Law", "2023");

        MappingJacksonValue mappingJacksonValue = getMappingForFieldsToDisplay(student, "name", "course", "schoolYear");

        return mappingJacksonValue;
    }

    private MappingJacksonValue getMappingForFieldsToDisplay(StudentRecord student, String... fieldsToDisplay) {
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(student);

        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("StudentRecordFilter",
                SimpleBeanPropertyFilter.filterOutAllExcept(fieldsToDisplay)
        );
        mappingJacksonValue.setFilters(filterProvider);

        return mappingJacksonValue;
    }

}
