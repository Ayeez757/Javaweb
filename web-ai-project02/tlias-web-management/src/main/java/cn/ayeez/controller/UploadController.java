package cn.ayeez.controller;

import cn.ayeez.pojo.Result;
import cn.ayeez.utils.AliyunOSSOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {

//    @PostMapping("/upload")
//    public Result upload(String name, String age, MultipartFile file) throws IOException {
//
//        log.info("上传文件{}{}{}", name, age, file.getOriginalFilename());
//
//        //获取原始文件名字
//        String originalFilename =file.getOriginalFilename();
//        //裁剪出文件后缀名
//        String extension=originalFilename.substring(originalFilename.lastIndexOf("."));
//
//        file.transferTo(new File("D:\\Develop\\Java\\Code\\JavaWeb\\web-ai-project02" +
//                "\\tlias-web-management\\src\\main\\resources" +
//                "\\static\\images\\"+ UUID.randomUUID()+ extension));
//
//        return Result.success();
//    }

    @Autowired
    AliyunOSSOperator aliyunOSSOperator;

    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws Exception {

        String url = aliyunOSSOperator.upload(file.getBytes(), file.getOriginalFilename());


        return Result.success(url);
    }

}
