package com.example.websocket.controller;

import com.example.websocket.service.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class SocketController {

    @Autowired
    private WebSocketService webSocketService;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/webSocket")
    public ModelAndView socket(){
        ModelAndView modelAndView = new ModelAndView("/webSocket");
        return modelAndView;
    }
}
