package com.example.kamioka;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

public class CustomHandlerInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("CustomHandlerInterceptor.preHandle");
        System.out.println("handler = " + handler);
        // preHandle()でレスポンスにRequest-Idを付与する。
        // →なぜ、postHandle()では無いのか？→ファイルダウンロードのようなケースでは、postHandle()はヘッダ処理の「後」に行われるため
        response.addHeader("Request-Id", UUID.randomUUID().toString());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("CustomHandlerInterceptor.postHandle");
        System.out.println("handler = " + handler);
        System.out.println("modelAndView = " + modelAndView);
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
