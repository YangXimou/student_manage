package com.stusys.controller;

import com.stusys.service.StudentService;
import com.stusys.util.ResultVoUtil;
import com.stusys.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Simon on 2018/12/2.
 */
@Controller
public class DemoController {
    @Autowired
    private StudentService studentService;
    @RequestMapping("/sayhello")
    @ResponseBody
    public ResultVO sayhello(){
        System.out.println("hello");
        studentService.justTest();
        return ResultVoUtil.success("hello");
    }
}
