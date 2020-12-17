package com.yunbao.websocket.controller;

import com.yunbao.websocket.websocket.MyWebsocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: djl
 * @Date: 2020/7/11 10:32
 * @Version 1.0
 */

@Controller
@RequestMapping("/socket")
public class SocketController {

    @Autowired
    private MyWebsocketServer webSocketServer;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/webSocket")
    public ModelAndView socket() {
        ModelAndView mav=new ModelAndView("websocket_page");
       // mav.addObject("userId", userId);
        return mav;
//        return "/websocket_page";
    }
}
