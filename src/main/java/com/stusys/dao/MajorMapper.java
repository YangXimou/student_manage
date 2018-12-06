package com.stusys.dao;

import com.stusys.dto.MajorDto;
import com.stusys.pojo.Department;
import com.stusys.pojo.Major;

import java.util.List;

public interface MajorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Major record);

    int insertSelective(Major record);

    Major selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Major record);

    int updateByMajorIdSelective(Major record);

    int updateByPrimaryKey(Major record);

    String selectName(Integer majorId);

    List<Major> selectAllBase();

    MajorDto selectByMajorId(Integer majorId);

    Integer getNewestMajorId(Integer departmentId);
}