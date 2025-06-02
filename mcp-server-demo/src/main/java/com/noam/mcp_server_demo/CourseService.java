package com.noam.mcp_server_demo;

import jakarta.annotation.PostConstruct;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.logging.Logger;

@Service
public class CourseService {

    private static final Logger logger = Logger.getLogger(CourseService.class.getName());
    private List<Course> courses = List.of(
            new Course("Java", "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"),
            new Course("Spring", "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"),
            new Course("React", "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"),
            new Course("Angular", "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX")
    );

    @PostConstruct
    public void init(){
        try{
//            courses.addAll();
            logger.info("Courses initialized: " + courses.size());
        }catch (Exception e){
            logger.severe("Error initializing courses: " + e.getMessage());
        }
    }

    @Tool(name="get_courses", description = "Get a list of courses")
    public List<Course> getCourses(){
        logger.info("getCourses() called");
        return courses;
    }

    @Tool(name="get_course", description = "Get a single course by title")
    public Course getCourse(String title){
        logger.info("getCourse() called");
        return courses.stream().filter(c -> c.title().equals(title)).findFirst().orElse(null);
    }
}
