package com.example.kamioka;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Objects;
import java.util.UUID;

public class CustomHandlerInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("CustomHandlerInterceptor.preHandle");
        System.out.println("handler = " + handler);
        for ( String n : Collections.list(request.getAttributeNames())) {
            System.out.println("\t> " + n + " = " + request.getAttribute(n));
        }
        request.setAttribute("Request-Id", UUID.randomUUID().toString());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("CustomHandlerInterceptor.postHandle");
        System.out.println("handler = " + handler);
        System.out.println("modelAndView = " + modelAndView);
        response.setHeader("Request-Id", Objects.toString(request.getAttribute("Request-Id"), null));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("CustomHandlerInterceptor.afterCompletion");
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("CustomHandlerInterceptor.afterConcurrentHandlingStarted");
    }
}
