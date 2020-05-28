package cn.itcast.exception;

/**
 * @author Yangbin
 * @create 2020-03-05 20:33
 * @Description 自定义异常类
 */

public class SysException extends Exception{

    //存贮提示信息的
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    //构造方法
    public SysException(String message) {
        this.message = message;
    }
}
