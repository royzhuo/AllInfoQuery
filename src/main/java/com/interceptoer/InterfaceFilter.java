package com.interceptoer;

import org.json.JSONObject;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//servlet 过滤器
public class InterfaceFilter implements Filter {


    public void init(FilterConfig filterConfig) throws ServletException {

    }


    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String token = servletRequest.getParameter("username");
        System.out.println("---------------------token---------------" + token);

        PrintWriter out = servletResponse.getWriter();
//                httpServletRequest.getRequestDispatcher("www/view/login.html").forward(httpServletRequest,httpServletResponse);
//                httpServletResponse.sendRedirect("/www/view/login.html");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", false);
        jsonObject.put("msg", "token过期了");
        out.print(jsonObject.toString());
        filterChain.doFilter(servletRequest, servletResponse);
    }


    public void destroy() {

    }
}
