package xin.chunming.controller.advice;

import com.auth0.jwt.exceptions.SignatureVerificationException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import xin.chunming.pojo.Result;

@RestControllerAdvice
public class controllerAdvice {
    @ExceptionHandler(ConstraintViolationException.class)
    public Result register_regerr(Exception exp) {
        return Result.error(exp.getMessage().isEmpty() ? "失败" : exp.getMessage());
    }

    @ExceptionHandler(SignatureVerificationException.class)
    public Result verify(Exception exp) {
        return Result.error("token invalid!!");
    }
}
