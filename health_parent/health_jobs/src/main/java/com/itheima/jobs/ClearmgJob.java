package com.itheima.jobs;

import com.itheima.dao.CheckSetmealDao;
import com.itheima.utils.QiNiuUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClearmgJob {

    @Autowired
    private CheckSetmealDao checkSetmealDao;

    private static final Logger log = LoggerFactory.getLogger(ClearmgJob.class);

    /**
     * 定时任务执行的方法
     * 每天凌晨4点
     */
    public  void clean7niuImgJob(){
        log.info("开始执行清理照片任务");
        //1.查询七牛云的所有图片
        List<String> picsIn7Niu = QiNiuUtils.listFile();
        log.info("7牛上共有{}张图片", picsIn7Niu.size());
        //2. 查询数据库套餐表中所有的图片名
        List<String> picsInDb = checkSetmealDao.selectImgs();
        log.info("数据库中共有{}张图片", null==picsInDb?0:picsInDb.size());
        //3. 七牛上的图片减掉数据库的图片，剩下的就是垃圾图片
        picsIn7Niu.removeAll(picsInDb);
        String[] need2Delete = picsIn7Niu.toArray(new String[]{});
        log.info("需要删除的图片有{}张", need2Delete.length);
        //4. 调用7牛删除垃圾图片
        QiNiuUtils.removeFiles(need2Delete);
        //5. 记录log日志
        log.info("清理7牛垃圾图片任务完成");
    }


}
