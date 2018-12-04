package com.stusys.controller;

import com.stusys.service.LoginService;
import com.stusys.util.ResultVOUtil;
import com.stusys.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Simon on 2018/12/4.
 */
@RestController
@RequestMapping("/shiro")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @PostMapping("/login")
    public ResultVO login(Integer id,String password,String userType){
        int result=loginService.login(id,password,userType);
        if(result==0)
            return ResultVOUtil.success();
        if(result==-1)
            return ResultVOUtil.error("该用户不存在！");
        return ResultVOUtil.error("密码错误！");
    }
//    @RequestMapping("/testStr")
//    public String testStringParams(String str){
//        System.out.println("获取到的字符串参数值为："+str);
//        return str;
//    }
//
//    @PostMapping("/testPostStr")
//    public String testPostStr(String str){
//        System.out.println("获取到的POST请求的字符串参数值为："+str);
//        return str;
//    }
//    @RequestMapping("/testInt")
//    public Integer testStringParams(Integer id){
//        System.out.println("获取到的整型参数值为："+id);
//        return id;
//    }
}
