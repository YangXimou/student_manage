package com.stusys.service;

import com.stusys.vo.ResultVO;

/**
 * Created by Simon on 2018/12/4.
 */
public interface LoginService {
    public int login(Integer id,String password,String userType);
}
