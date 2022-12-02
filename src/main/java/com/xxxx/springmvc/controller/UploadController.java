package com.xxxx.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class UploadController {

    /**
     * 文件上传
     * 在形参上使用@RequestParam("myfile"） MultipartFile file 接收上传的文件
     * mufile代表的是表单元素的name属性值
     *
     * @param request
     * @param file
     * @return
     */
    @RequestMapping("uploadFile")
    public String uploadFile(HttpServletRequest request, @RequestParam("myfile") MultipartFile file) {
//        //得到文件上传的request对象
//        MultipartHttpServletRequest multipartHttpServletRequest= (MultipartHttpServletRequest) request;
//        //得到上传得到文件
//        File file= (File) multipartHttpServletRequest.getFile("myfile");
        if (file.isEmpty()) {
            request.setAttribute("msg", "file is empty!");
            return "result";
        }
        save(file, request);

        return "result";
    }

    public void save(MultipartFile file, HttpServletRequest request) { //得到上传的文件名
        String originalFilename = file.getOriginalFilename();
        //得到文件后缀
        String siffx = originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileName = System.currentTimeMillis() + siffx;


        //得到项目真实路径
        String realPath = request.getServletContext().getRealPath("/");
        //设置文件存放路径
        File filePath = new File(realPath + "/upload");
        //判断文件目录是否存在
        if (!filePath.exists()) {
            //新建目录
            filePath.mkdir();
        }

        try {
            file.transferTo(new File(filePath, fileName));
            request.setAttribute("msg", "success!");
        } catch (IOException e) {
            request.setAttribute("msg", "failed!");
            e.printStackTrace();
        }
    }

    @RequestMapping("uploadFiles")
    public String uploadFiles(HttpServletRequest request, @RequestParam("myfiles") List<MultipartFile> files) {
//        //得到文件上传的request对象
//        MultipartHttpServletRequest multipartHttpServletRequest= (MultipartHttpServletRequest) request;
//        //得到上传得到文件
//        File file= (File) multipartHttpServletRequest.getFile("myfile");
        if (files != null && files.size() > 0) {
            for (MultipartFile file : files) {
                if (file.isEmpty()) {
                    request.setAttribute("msg", "file is empty!");
                    return "result";
                }
                save(file, request);
            }
        }

        return "result";
    }

}
