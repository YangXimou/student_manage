package com.stusys.service.impl;

import com.stusys.dao.DepartmentMapper;
import com.stusys.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Simon on 2018/12/3.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;
    public Integer getNewDepartmentId(){
        Integer newestDepartmentId=departmentMapper.getNewestDepartmentId();
        if(newestDepartmentId==null)
            return 11;
        return newestDepartmentId+1;
    }

}
