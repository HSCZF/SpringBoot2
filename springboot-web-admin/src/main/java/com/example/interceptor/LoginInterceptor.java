package com.example.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 拦截器：登录检查功能
 * 1、配置好拦截器拦截哪些请求
 * 2、把这些配置放在容器中：com.example.config.AdminWebConfig 容器配置
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 目标方法执行之前
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestURI = request.getRequestURI();
        log.info("拦截请求的路径是：{}", requestURI);
        // 登录检查之前
        HttpSession session = request.getSession();

        Object loginUser = session.getAttribute("loginUser");

        if (loginUser != null) {
            // 放行
            return true;
        }
        // 拦截，未登录，跳转到登陆页面
        request.setAttribute("msg", "请先登录");
        //response.sendRedirect("/");
        request.getRequestDispatcher("/").forward(request, response);

        return false;
    }

    /**
     * 目标方法执行完成之后
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle执行：{}", modelAndView);
    }

    /**
     * 页面渲染
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion执行异常：{}", ex);
    }
}
