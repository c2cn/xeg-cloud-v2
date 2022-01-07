package com.xeg.cores.base.logger;

import com.xeg.cores.base.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Description //TODO
 * @Author Qi Ding
 * @Date 2021/2/25 8:38 下午
 * @Version 1.0
 */
@Slf4j
@Service
public class SystemLogService implements ISystemLogService {

    @Async
    @Override
    public void saveSystemLog(SystemLogDTO dto) {
        log.info("{}", JsonUtils.toJson(dto));
    }
}
