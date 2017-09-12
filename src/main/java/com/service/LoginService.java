package com.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {
    public String getUsername(){
        return "小明";
    }

    public Map<String ,String> getPeoples(){
        Map<String,String> peopers=new HashMap<String, String>();
        peopers.put("p1","小明");
        return peopers;
    }
}
