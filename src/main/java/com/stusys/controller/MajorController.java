package com.stusys.controller;

import com.stusys.service.MajorService;
import com.stusys.service.ManagerService;
import com.stusys.util.ResultVOUtil;
import com.stusys.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Simon on 2018/12/6.
 */
@RestController
@RequestMapping("/major")
public class MajorController {
    @Autowired
    private MajorService majorService;
    @RequestMapping("/getNewMajorId")
    public ResultVO getNewMajorId(Integer departmentId){
        Integer newMajorId=majorService.getNewMajorId(departmentId);
        if(newMajorId!=null)
            return ResultVOUtil.success(newMajorId);
        return ResultVOUtil.error("返回新专业编号失败");
    }
}
