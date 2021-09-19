package com.itheima.controller;

import com.itheima.constant.MessageConstant;
import com.itheima.entity.Result;
import com.itheima.pojo.Setmeal;
import com.itheima.service.CheckSetmealService;
import com.itheima.utils.QiNiuUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("setmeal")
public class SetmealController {
    //注入service
    @Autowired
    private CheckSetmealService checkSetmealService;

    private static  final Logger log= LoggerFactory.getLogger(SetmealController.class);

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

    @PostMapping("/add")
    public Result add(@RequestBody Setmeal setmeal ,@RequestParam List<Integer> checkgroupIds ){
        //调用sevice干活
        checkSetmealService.add(setmeal,checkgroupIds);
        return new Result(true,MessageConstant.ADD_SETMEAL_SUCCESS);
    }
}
