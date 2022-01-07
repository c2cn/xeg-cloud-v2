package com.xeg.servers.base.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xeg.cores.base.http.JsonResult;
import com.xeg.cores.base.http.JsonResultUtils;
import com.xeg.cores.base.utils.BeanUtils;
import com.xeg.servers.base.api.BaseService;
import com.xeg.servers.base.bean.vo.SystemConfigVO;
import com.xeg.servers.base.domain.entity.SystemConfig;
import com.xeg.servers.base.domain.repository.SystemConfigRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Description：//TODO
 * @Author：xulp
 * @Date：2021/10/25 17:22
 */
@RestController
@RequestMapping("/feign/base")
public class BaseServiceImpl implements BaseService {
    @Autowired
    private SystemConfigRepo systemConfigRepo;

    /**
     * 根据key查询系统配置信息
     *
     * @param sysKey 系统关键
     * @return {@link JsonResult}<{@link SystemConfigVO}>
     */
    @Override
    public JsonResult<SystemConfigVO> getSystemConfigByKey(String sysKey) {
        LambdaQueryWrapper<SystemConfig> wrapper = new LambdaQueryWrapper();
        wrapper.eq(SystemConfig::getSysKey, sysKey);
        SystemConfigVO vo = BeanUtils.copyObject(systemConfigRepo.getOne(wrapper), new SystemConfigVO());
        vo.convertToList();
        return JsonResultUtils.success(vo);
    }
}
