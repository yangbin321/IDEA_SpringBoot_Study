package cn.itcast.controller;

import cn.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;

/**
 * @author Yangbin
 * @create 2020-03-02 19:19
 * @Description 常用的注解
 */

@Controller
@RequestMapping(path = "/anno")
@SessionAttributes(value = "msg")
public class AnnoController {

    @RequestMapping(path = "/testRequestParam")
    public String testRequestParam(@RequestParam(value = "name") String username){
        System.out.println("执行了。。。。。");
        System.out.println(username);
        return "success";
    }

    /**
     * 获取请求体的内容
     * @param body
     * @return
     */
    @RequestMapping(path = "/testRequestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println("执行了。。。。。");
        System.out.println(body);
        return "success";
    }

    /**
     * PathVariable注解
     * @param id
     * @return
     */
    @RequestMapping(path = "/testPathVariable/{sid}")
    public String testPathVariable(@PathVariable(name = "sid") String id){
        System.out.println("执行了。。。。。");
        System.out.println(id);
        return "success";
    }

    /**
     * ModelAttribute注解
     * @param
     * @return
     */
    @RequestMapping(value = "/testModelAttribute")
    public String testModelAttribute(User user){
        System.out.println("testModelAttribute执行了。。。。。");
        System.out.println(user);
        return "success";
    }

    @ModelAttribute
    public User show(String uname){
        System.out.println("show方法执行了");
        //通过用户名查询数据库
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        return user;
    }

    /**
     * SessionAttribute的注解
     * @param
     * @return
     */
    @RequestMapping(value = "/testSessionAttribute")
    public String testSessionAttribute(Model model){
        System.out.println("testSessionAttribute执行了。。。。。");
        model.addAttribute("msg","妹妹");
        return "success";
    }

    /**
     *获取
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/getSessionAttribute")
    public String getSessionAttribute(ModelMap modelMap){
        System.out.println("getSessionAttribute。。。。。");
        String msg = (String) modelMap.get("msg");
        System.out.println(msg);
        return "success";
    }

    /**
     * 删除
     * @param status
     * @return
     */
    @RequestMapping(value = "/deleteSessionAttribute")
    public String deleteSessionAttribute(SessionStatus status){
        System.out.println("getSessionAttribute。。。。。");
        status.setComplete();
        return "success";
    }
}
