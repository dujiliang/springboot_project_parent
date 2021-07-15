package com.djl.satoken.handler;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import cn.hutool.core.exceptions.ValidateException;
import com.djl.satoken.utils.R;
import com.djl.satoken.utils.ReturnCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.Set;


/**
 * @Author：dcy
 * @Description: 全局的的异常拦截器（拦截所有的控制器）
 * @Date: 2019/9/6 13:25
 */
@RestControllerAdvice
@Order(-1)
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 校验异常
     *
     * @param validException
     * @return
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(ValidateException.class)
    public R<String> validExceptionHandler(ValidateException validException) {
        log.warn("validExceptionHandler [{}]", validException.toString());
//        validException.printStackTrace();
        return R.error(ReturnCode.TOKEN_ERROR.getCode(), validException.getMessage());
    }

    /**
     * 基本数据类型，验证错误
     *
     * @param exception
     * @return
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(ValidationException.class)
    public R<String> validationExceptionHandler(ValidationException exception) {
        log.warn("validationExceptionHandle [{}]", exception.toString());
//        exception.printStackTrace();
        if (exception instanceof ConstraintViolationException) {
            ConstraintViolationException exs = (ConstraintViolationException) exception;
            Set<ConstraintViolation<?>> violations = exs.getConstraintViolations();
            for (ConstraintViolation<?> item : violations) {
                return R.error(ReturnCode.CHECK_ERROR.getCode(), item.getMessage());
            }
        }
        return R.error(ReturnCode.CHECK_ERROR.getCode(), exception.getMessage());
    }

    /**
     * token相关异常
     *
     * @param exception
     * @return
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(NotLoginException.class)
    public R<String> handlerNotLoginException(NotLoginException exception) {
        log.warn("handlerNotLoginException [{}]", exception.toString());
        // 打印堆栈，以供调试
        exception.printStackTrace();
        // 判断场景值，定制化异常信息
        String message = "";
        switch (exception.getType()) {
            case NotLoginException.NOT_TOKEN:
                message = "未提供token";
                break;
            case NotLoginException.INVALID_TOKEN:
                message = "token无效";
                break;
            case NotLoginException.TOKEN_TIMEOUT:
                message = "token已过期";
                break;
            case NotLoginException.BE_REPLACED:
                message = "token已被顶下线";
                break;
            case NotLoginException.KICK_OUT:
                message = "token已被踢下线";
                break;
            default:
                message = "当前会话未登录";
                break;
        }
        return R.error(ReturnCode.TOKEN_ERROR.getCode(), message);
    }

    /**
     * 没有角色
     * @param exception
     * @return
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(NotRoleException.class)
    public R<String> handlerNotRoleException(NotRoleException exception) {
        log.warn("handlerNotRoleException [{}]", exception.toString());
        return R.error(ReturnCode.USER_NOROLE_LOCKED_ERROR.getCode(), exception.getRole());
    }

    /**
     * 没有权限
     * @param exception
     * @return
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(NotPermissionException.class)
    public R<String> handlerNotPermissionException(NotPermissionException exception) {
        log.warn("handlerNotPermissionException [{}]", exception.toString());
        return R.error(ReturnCode.USER_NOPERMISSION_LOCKED_ERROR.getCode(), exception.getCode());
    }

    /**
     * 所有异常信息
     *
     * @param exception
     * @return
     * @throws Exception
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public R<String> exceptionHandler(Exception exception) {
        log.error("exceptionHandle [{}]", exception.toString());
        exception.printStackTrace();
        return R.error(ReturnCode.OTHER_ERROR.getCode(), exception.getMessage());
    }


}
