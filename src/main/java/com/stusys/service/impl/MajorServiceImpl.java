package com.stusys.service.impl;

import com.stusys.dao.MajorMapper;
import com.stusys.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Simon on 2018/12/3.
 */

@Service
public class MajorServiceImpl implements MajorService {
    @Autowired
    private MajorMapper majorMapper;
    public Integer getNewMajorId(Integer departmentId){
        Integer newestMajorId=majorMapper.getNewestMajorId(departmentId);
        if(newestMajorId==null)
            return Integer.parseInt(departmentId+"01");
        return newestMajorId+1;
    }
}
