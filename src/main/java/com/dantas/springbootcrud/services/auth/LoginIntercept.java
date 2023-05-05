package com.dantas.springbootcrud.services.auth;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.dantas.springbootcrud.services.CookieService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LoginIntercept implements HandlerInterceptor {
    // os métodos a seguir rodarão para todas as URLs menos as definidas no
    // LoginInterceptAppconfig

    @Override // preHandle roda antes do Controller
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        if (CookieService.getCookie(request, "userId") != null) {
            return true;
        }
        response.sendRedirect("/login");
        return false;
    }

    // @Override // postHandle roda imediatamente depois do Controller
    // public void postHandle(HttpServletRequest request, HttpServletResponse
    // response, Object handler,
    // ModelAndView modelAndView) throws Exception {
    // System.out.print("Post Handle method is Calling");
    // }

    // @Override // afterCompletion roda depois de completar o carregamento da
    // página
    // public void afterCompletion(HttpServletRequest request, HttpServletResponse
    // response, Object handler,
    // Exception exception) throws Exception {
    // System.out.print("Request and response is completed");
    // }

}
