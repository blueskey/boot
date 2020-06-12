package com.my.controller;


import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/")
public class MyTestController {

    @ApiOperation(value = "测试", notes = "提示接口使用者注意事项")
    @RequestMapping(value = "/test",method = RequestMethod.POST)
    @ApiImplicitParam(dataType = "string",name = "name",value = "姓名",required = true)
    public String test(String name) {
        return "hello: " + name;
    }
}
