package com.stusys.dao;

import com.stusys.dto.ClassDto;
import com.stusys.pojo.Class;
import com.stusys.pojo.Major;

import java.util.List;

public interface ClassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Class record);

    int insertSelective(Class record);

    Class selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Class record);

    int updateByClassIdSelective(Class record);

    int updateByPrimaryKey(Class record);

    String selectName(Integer classId);

    List<ClassDto> selectAllBasePlus();

    ClassDto selectDetailPlusByClassId(Integer classId);

}