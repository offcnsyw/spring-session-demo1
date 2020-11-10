package com.offcn.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class SessionController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/setSession/{message}")
    public String setSession(@PathVariable("message") String message, HttpSession session){
        //将后期到的数据存入到session中
        session.setAttribute("msg",message);
        //返回成功
        return "port:"+port;
    }

    @GetMapping("/getSession")
    public String getSession(HttpSession session){
        //获取session中的数据
        Object object = session.getAttribute("msg");
        //创建一个字符串
        String msg = "";
        if(object != null){
            msg = object.toString();
        }else{
            msg = "null";
        }
        //返回
        return "端口:"+port+",session中的数据:"+msg;
    }
}
