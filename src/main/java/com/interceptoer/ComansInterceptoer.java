package com.interceptoer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONObject;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


public class ComansInterceptoer implements HandlerInterceptor {
    public boolean preHandle(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("preHandle");


        Map<String,Object> map=new HashMap<String, Object>();
        httpServletResponse.setHeader("Content-type", "text/html;charset=UTF-8");
        httpServletResponse.setCharacterEncoding("utf-8");
        map.put("success",false);
        map.put("msg","没有token");
        String username=httpServletRequest.getParameter("username");
        if (username!=null){
            if (username.equals("roy")){

                return true;
            }else{
                PrintWriter out=httpServletResponse.getWriter();
//                httpServletRequest.getRequestDispatcher("www/view/login.html").forward(httpServletRequest,httpServletResponse);
//                httpServletResponse.sendRedirect("/www/view/login.html");
                JSONObject jsonObject=new JSONObject();
                jsonObject.put("success",false);
                jsonObject.put("msg","token过期了");
                out.print(jsonObject.toString());
                return false;
            }
        }else{
            PrintWriter out=httpServletResponse.getWriter();
            ObjectMapper jsonObj=new ObjectMapper();
            String result=jsonObj.writeValueAsString(map);
            out.print(result);


            return false;
        }

    }

    public void postHandle(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    public void afterCompletion(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("afterCompletion");
    }
}
