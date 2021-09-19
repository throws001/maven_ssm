package com.itheima.controller;

import com.itheima.constant.MessageConstant;
import com.itheima.entity.Result;
import com.itheima.utils.QiNiuUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping()
public class SemealController {

    private static  final Logger log= LoggerFactory.getLogger(SemealController.class);

    @PostMapping("/upload")
    /**
     * 上传文件回显~
     */
    public Result upload(MultipartFile imgFile ){
        //获取文件名
        String originalFilename = imgFile.getOriginalFilename();
        //截取后缀
        String substring = originalFilename.substring(originalFilename.lastIndexOf('.'));
        //使用uuid生成唯一的文件
        String uniquefilename= UUID.randomUUID().toString()+substring;
        //上传到7牛上
        try {
            QiNiuUtils.uploadViaByte(imgFile.getBytes(),uniquefilename);
        } catch (IOException e) {
           // e.printStackTrace();
            log.error("上传文件失败~~~");
            return new Result(false, MessageConstant.PIC_UPLOAD_FAIL);
        }

        Map<String,String> map=new HashMap<>();
        map.put("imgName",uniquefilename);
        map.put("domain",QiNiuUtils.DOMAIN);
        return new Result(true,MessageConstant.PIC_UPLOAD_SUCCESS,map);
    }
}
