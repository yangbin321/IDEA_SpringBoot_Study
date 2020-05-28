package cn.itcast.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Yangbin
 * @create 2020-03-05 20:39
 * @Description 异常处理器
 */
public class SysExceptionResolver implements HandlerExceptionResolver {
    /**
     * 处理异常的业务逻辑
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @return
     */
    @Override
    public ModelAndView resolveException
    (HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        //获取到异常的对象
        SysException e = null;
        if (ex instanceof SysException){
            //如果是异常，就进行强转
            e = (SysException)ex;
        }else {
            //如果不是，就提示信息
            e = new SysException("系统正在维护中。。。。。");
        }
        //创建ModelAndView对象
        ModelAndView mv = new ModelAndView();
        mv.addObject("errorMsg",e.getMessage());
        mv.setViewName("error");
        //返回
        return mv;
    }
}
