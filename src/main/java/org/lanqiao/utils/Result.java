package org.lanqiao.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import net.minidev.json.JSONArray;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T> {
    private Integer code;
    private String message;
    private Object data;

    public Result() {
        this.code = 200;
        this.message = "操作成功";
    }

    /**
     * 用于@valid错误处理
     * @param code 错误码 
     * @param message 错误提示信息
     */
    public Result(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    /**
     * 用于封装返回数据
     * @param code 返回码
     * @param message 提示信息
     */
    public Result(Integer code,String message,Object data){
        this.code = code;
        this.message = message;
        this.data = data;
    }
    //系统错误
    public static  Result<String> error(String message){
        return new Result<>(400,message);
    }
    //操作成功，返回数据
    public static  Result<Object> success(Object data){
        return new Result<>(200,"success",data);
    }
    //操作成功，无返回数据
    public static  Result<Object> success(){
        return new Result<>(200,"success");
    }
    //操作失败，返回数据
    public static  Result<Object> fail(Object data){
        return new Result<>(200,"fail",data);
    }
    //操作失败，无返回数据
    public static  Result<Object> fail(){
        return new Result<>(200,"fail");
    }
}