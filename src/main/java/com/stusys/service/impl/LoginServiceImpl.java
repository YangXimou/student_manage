package com.stusys.service.impl;

import com.stusys.dao.ManagerMapper;
import com.stusys.dao.StudentMapper;
import com.stusys.dao.TeacherMapper;
import com.stusys.pojo.Manager;
import com.stusys.pojo.Student;
import com.stusys.pojo.Teacher;
import com.stusys.service.LoginService;
import com.stusys.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Simon on 2018/12/4.
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ManagerMapper managerMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    //    验证登录信息是否正确
//    0表示账号密码都正确，-1表示账号不存在，-2表示密码错误
    public int login(Integer id,String password,String userType){
        String pwd=null;
        if("student".equals(userType)){
            pwd=studentMapper.getPassword(id);
        }
        if("teacher".equals(userType)) {
            pwd=teacherMapper.getPassword(id);
        }
        if("manager".equals(userType)){
            pwd=managerMapper.getPassword(id);
        }
        if(pwd!=null) {
            if (password.equals(pwd))
                return 0;
            else
                return -2;
        }
        return -1;
    }
}
