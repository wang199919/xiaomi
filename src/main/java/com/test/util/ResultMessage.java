package com.test.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author: roy
 * @date: 2023/7/13 9:36
 * @description:
 */
@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class ResultMessage {
    private  String code;
    private  String msg;
    private  Object data;


    public  static  ResultMessage success(String code, String msg){
    return new  ResultMessage(code,msg,null);
    }

    public  static  ResultMessage success(String code, String msg,Object data){
        return new  ResultMessage(code,msg,data);
    }
    public  static  ResultMessage failure(String code, String msg){
        return new  ResultMessage(code,msg,null);
    }

    public  static  ResultMessage failure(String code, String msg,Object data){
        return new  ResultMessage(code,msg,data);
    }
}
