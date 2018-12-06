package com.stusys.controller;

import com.stusys.service.ClassService;
import com.stusys.service.MajorService;
import com.stusys.util.ResultVOUtil;
import com.stusys.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Simon on 2018/12/6.
 */
@RestController
@RequestMapping("/class")
public class ClassController {
    @Autowired
    private ClassService classService;
    @RequestMapping("/getNewClassId")
    public ResultVO getNewClassId(Integer grade,Integer majorId){
        Integer newClassId=classService.getNewClassId(grade,majorId);
        if(newClassId!=null)
            return ResultVOUtil.success(newClassId);
        return ResultVOUtil.error("返回新班级编号失败");
    }
}
