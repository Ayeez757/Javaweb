package cn.ayeez.exception;

import cn.ayeez.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler
    public Result handleException(Exception e){
        log.info("全局异常处理......",e);
        return Result.error("出错啦~");
    }

    @ExceptionHandler
    public Result handleDuplicateKeyException(DuplicateKeyException e){
        log.info("全局异常处理......2",e);
        String message = e.getMessage();
        int index = message.indexOf("Duplicate entry");
        String str = message.substring(index);
        String[] split=str.split(" ");
        String msg = split[2] + "已存在";
        return Result.error(msg);
    }


}
