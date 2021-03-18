package org.lanqiao.config;

import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;
import org.lanqiao.utils.Result;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    //使用json对象时，@RequestBody 会进入这个异常。
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleValidException(MethodArgumentNotValidException e) {
        //将错误信息返回给前台
        List<FieldError> fieldErrorList = e.getBindingResult().getFieldErrors();
        Map<String,String> map = new HashMap<>();
        for (FieldError fieldError : fieldErrorList) {
            map.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        //转换json字符串
        return Result.error(Objects.requireNonNull(JSONObject.toJSONString(map)));
    }

    //使用表单提交时，会进入这个异常。
    @ResponseBody
    @ExceptionHandler(BindException.class)
    public Result handleValidException(BindException e) {
        //将错误信息返回给前台
        List<FieldError> fieldErrorList = e.getBindingResult().getFieldErrors();
        Map<String,String> map = new HashMap<>();
        for (FieldError fieldError : fieldErrorList) {
            map.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        //转换json字符串
        return Result.error(Objects.requireNonNull(JSONObject.toJSONString(map)));
    }
}