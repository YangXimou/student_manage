package com.stusys.controller;

import com.stusys.service.DepartmentService;
import com.stusys.util.ResultVOUtil;
import com.stusys.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Simon on 2018/12/6.
 */
@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @RequestMapping("/getNewDepartmentId")
    public ResultVO getNewDepartmentId(){
        Integer newDepartmentId=departmentService.getNewDepartmentId();
        if(newDepartmentId!=null)
            return ResultVOUtil.success(newDepartmentId);
        return ResultVOUtil.error("返回新学院编号失败");
    }
}
