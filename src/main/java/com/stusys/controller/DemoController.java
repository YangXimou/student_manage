package com.stusys.controller;

import com.stusys.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Simon on 2018/12/2.
 */
@RestController
public class DemoController {
    @Autowired
    private StudentService studentService;
    @RequestMapping("/sayhello")
    public String sayhello(){
        System.out.println("hello");
        studentService.justTest();
        return "hello";
    }
}
