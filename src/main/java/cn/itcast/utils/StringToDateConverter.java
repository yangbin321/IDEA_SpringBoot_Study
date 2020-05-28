package cn.itcast.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Yangbin
 * @create 2020-03-01 22:16
 * @Description 把字符串转日期
 */
public class StringToDateConverter implements Converter<String, Date> {

    /**
     *
     * @param source    传进来的字符
     * @return
     */
    @Override
    public Date convert(String source) {
        //判断
        if(source ==null){
            throw new RuntimeException("请您传入数据");
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            //把字符串转换成日期
            return df.parse(source);
        } catch (Exception e) {
            throw new RuntimeException("数据类型转换出现错误");
        }
    }
}
