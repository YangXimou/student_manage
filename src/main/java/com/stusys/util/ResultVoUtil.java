package com.stusys.util;

import com.stusys.enums.ResultEnum;
import com.stusys.vo.ResultDataVO;
import com.stusys.vo.ResultVO;

/**
 * Created by Simon on 2018/12/3.
 */
public class ResultVoUtil {
    public static ResultVO success(){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(ResultEnum.SUCCESS.getCode());
        resultVO.setMsg(ResultEnum.SUCCESS.getMessage());
        return resultVO;
    }
    public static ResultDataVO success(Object object){
        ResultDataVO resultDataVO=new ResultDataVO();
        resultDataVO.setCode(ResultEnum.SUCCESS.getCode());
        resultDataVO.setMsg(ResultEnum.SUCCESS.getMessage());
        resultDataVO.setData(object);
        return resultDataVO;
    }
}
