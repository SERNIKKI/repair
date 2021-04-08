package com.qpj.week01.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "PermissionFilter",urlPatterns = {"/repair/*","*.jsp","/*"},initParams = {
        @WebInitParam(name = "ignores", value = "/login.jsp;/check.jsp;/Login;/css;/ajaxupload;/bootstrap-table;" +
                "/img;/js;/json;/jsp;/upload;/webfonts;/image.jsp;/android/login")})
public class PermissionFilter implements Filter {
    private String excludedPage;
    private String[] excludedPages;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        excludedPage = filterConfig.getInitParameter("ignores");
        if(excludedPage!=null&&excludedPage.length()>0){
            System.out.println("运行到我");
            excludedPages = excludedPage.split(";");
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        /**
         * servletRequest和servletResponse是HttpServletRequest,HttpServletResponse的父类
         */
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse resp = (HttpServletResponse)servletResponse;
        HttpSession session = req.getSession();

        // 获取请求的url资源名称  /system/userList.jsp
        String servletPath = req.getServletPath();

        System.out.println("PermissionFilter 执行了");
        System.out.println("当前请求的资源为:"+servletPath);

        System.out.println("开始=====================");
        for(String item :excludedPages){
            System.out.println("item: " + item);
            if(servletPath.contains(item)){
                // 当前的请求url资源，是属于不验证的资源，直接放行。
                filterChain.doFilter(req,resp);
                return;// 后面的验证代码不再执行了。
            }
        }
        String username = (String)session.getAttribute("username");
        String contextPath = req.getContextPath();
        //session中如果无信息，说明没有登陆
        if(servletPath.startsWith("/android")){
            filterChain.doFilter(req,resp);
        }
        if(username == null||username.isEmpty()){
            req.getSession().setAttribute("msg","未登录！，无法访问系统资源");
            //转发或者重定向到登陆页面
            resp.sendRedirect(contextPath + "/login.jsp");
        }else {
            //说明登陆成功,符合条件可以放行
            filterChain.doFilter(req,resp);
        }
    }

    @Override
    public void destroy() {

    }
}
