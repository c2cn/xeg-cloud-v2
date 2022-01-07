package com.xeg.servers.task.impl;

import com.xeg.cores.base.http.JsonResult;
import com.xeg.cores.base.utils.BeanUtils;
import com.xeg.cores.base.utils.HttpUtils;
import com.xeg.servers.base.bean.dto.IdStringDTO;
import com.xeg.servers.base.bean.dto.XegTextDTO;
import com.xeg.servers.task.api.TaskService;
import com.xeg.servers.task.domain.entity.XegText;
import com.xeg.servers.task.domain.repository.XegTextRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.http.HTTP;

/**
 * @Description：//TODO
 * @Author：xulp
 * @Date：2021/10/25 17:22
 */
@RestController
@RequestMapping("/feign/task")
public class TaskServiceImpl implements TaskService {
    @Autowired
    private XegTextRepo xegTextRepo;

    /**
     * 测试方法
     */
    @Override
    public JsonResult<String> testServerStart(IdStringDTO dto) {
        return JsonResult.success("TaskService：" + dto.getId());

    }


    /**
     * 测试Mysql
     */
    @Override
    public JsonResult<String> testMysql(XegTextDTO dto) {
        return JsonResult.success("ChatService：" + xegTextRepo.save(BeanUtils.copyObject(dto, new XegText())));
    }
}
