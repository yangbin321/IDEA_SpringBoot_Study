package cn.itcast.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileDescriptor;
import java.util.List;
import java.util.UUID;

/**
 * @author Yangbin
 * @create 2020-03-03 22:20
 * @Description
 */

@Controller
@RequestMapping("/user")
public class UserController {

    /**
     *SpringMVC文件上传
     * @return
     */
    @RequestMapping("/fileupload2")
    public String fileupload2(HttpServletRequest request,MultipartFile upload) throws Exception {

        System.out.println("SpringMVC文件上传....");
        //上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断路径是否存在
        File file = new File(path);
        if (!file.exists()){
            //创建文件夹
            file.mkdirs();
        }
        //说明上传文件项
        //获取上传文件项的名称
        String fieldname = upload.getOriginalFilename();
        //将文件的名称设置唯一值
        String uuid = UUID.randomUUID().toString().replace("-", "");
        fieldname = uuid+"_"+fieldname;
        //完成文件上传
        System.out.println("123");
        upload.transferTo(new File(path,fieldname));

        return "success";
    }

    /**
     *文件上传
     * @return
     */
    @RequestMapping("/fileupload1")
    public String fileupload1(HttpServletRequest request) throws Exception {
        System.out.println("文件上传....");

        //上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断路径是否存在
        File file = new File(path);
        if (!file.exists()){
            //创建文件夹
            file.mkdirs();
        }
        //解析request对象，获取上传文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解析request
        List<FileItem> items = upload.parseRequest(request);
        //遍历
        for (FileItem item : items){
            //进行判断，当前item对象是否是上传文件项
            if(item.isFormField()){
                //说明是普通表单向
            }else {
                //说明上传文件项
                //获取上传文件项的名称
                String fieldName = item.getName();
//                String fieldName = item.getFieldName();

                //将文件的名称设置唯一值
                String uuid = UUID.randomUUID().toString().replace("-", "");
                fieldName = uuid+"_"+fieldName;
                System.out.println(fieldName);
                //完成文件上传
                item.write(new File(path,fieldName));
                //删除临时文件
                item.delete();
            }
        }
        return "success";
    }
}
