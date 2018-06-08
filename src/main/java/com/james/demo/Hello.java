package com.james.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by James_hu on 2018/6/1
 **/
@RestController
public class Hello {
    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public String hello(){
        return "hello sringboot";
    }
}
