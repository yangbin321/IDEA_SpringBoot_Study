package cn.itcast.controller;

import cn.itcast.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Yangbin
 * @create 2020-03-05 19:59
 * @Description
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testException")
    public String testException()throws Exception{
        System.out.println("testException执行了。。。。。");

        try {
            //模拟异常
            int a = 10/0;
        } catch (Exception e) {
            e.printStackTrace();
            //抛出自己定义的异常信息
            throw new SysException("查询所有用户出现错误了。。。。");
        }

        return "success";
    }
}
