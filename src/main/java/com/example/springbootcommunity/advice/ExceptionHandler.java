package com.example.springbootcommunity.advice;

import com.example.springbootcommunity.exception.CustomizeException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    ModelAndView handle(HttpServletRequest request, Throwable e, Model model){
        HttpStatus status= getStatus(request);
        if(e instanceof CustomizeException){
            model.addAttribute("message",e.getMessage());
        }else {
            model.addAttribute("message", "服务冒烟了，请稍后再试");
        }
        return new ModelAndView("error");
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode=(Integer) request.getAttribute("javax.sevlet.error.status_code");
        if(statusCode==null){
            return HttpStatus.INTERNAL_SERVER_ERROR;

        }
        return HttpStatus.valueOf(statusCode);
    }
}
