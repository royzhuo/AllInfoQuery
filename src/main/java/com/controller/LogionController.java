package com.controller;

import com.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class LogionController {

    @Autowired
    private LoginService loginService;
    @RequestMapping(value = "api/getUsername",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> getUsername(@RequestParam(value = "username0",required = false)String userName){
        if (userName!=null){
            System.out.println("username:"+userName);
        }
        return loginService.getPeoples();
    }

    @RequestMapping(value = "api/goLogin",method = RequestMethod.GET)
    public String goLogin(@RequestParam(value = "username1",required = false)String userName){
        if (userName!=null){
            System.out.println("username:"+userName);
        }
        return "login";
    }

    @RequestMapping(value = "api2/goLogin",method = RequestMethod.GET)
    public String goLogin2(@RequestParam(value = "username",required = false)String userName){
        if (userName!=null){
            System.out.println("username2:"+userName);
        }
        return "login";
    }

}
