package com.stusys.service.impl;

import com.stusys.dao.ClassMapper;
import com.stusys.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Simon on 2018/12/3.
 */
@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    private ClassMapper classMapper;
    public Integer getNewClassId(Integer grade, Integer majorId){
        Integer newClassId=classMapper.getNewestClassId(grade,majorId);
        if(newClassId==null)
            return Integer.valueOf(grade.toString().substring(2)+majorId+"1");
        return newClassId+1;
    }
}
