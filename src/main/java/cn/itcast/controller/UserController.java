package cn.itcast.controller;

import cn.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Yangbin
 * @create 2020-03-02 22:04
 * @Description
 */

@Controller
@RequestMapping("/user")
public class UserController {

    /**
     *string类型
     * @return
     */
    @RequestMapping("/testString")
    public String testSteing(Model model){
        System.out.println("执行了。。。。。。。。。。。。。");
        //模拟数据库
        User user = new User();
        user.setUsername("咩咩");
        user.setPassword("123QWE");
        user.setAge(19);
        //model对象
        model.addAttribute("user",user);

        return "success";
    }

    /**
     * void类型
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("执行了。。。。。。。。。。。。。");
        //编写请求转发的程序
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);

        //重定向
//        response.sendRedirect(request.getContextPath()+"/index.jsp");

        //设置中文乱码问题
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //直接会进行相应
        response.getWriter().print("你好吗？");
        return;
    }


    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        System.out.println("执行了。。。。。。。。。。。。。");

        //创建ModelAndView对象
        ModelAndView mView = new ModelAndView();

        //模拟数据库
        User user = new User();
        user.setUsername("嘿嘿嘿");
        user.setPassword("456");
        user.setAge(38);

        //把user对象存储到mView钟，也会把对象存储到request中
        mView.addObject("user",user);

        mView.setViewName("success");
        return mView;
    }

    /**
     *模拟异步请求相应
     */
    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){
        System.out.println("你的testAjax执行了!!!!!!!!!!");
        System.out.println(user);
        //模拟数据库查询
        user.setUsername("BB");
        user.setAge(18);
        //做响应
        return user;
    }
}
