package com.xeg.cores.base.logger;

/**
 * @author ArchieDing
 * @since 2020/09/07
 */
public interface ISystemLogService {
    /**
     * 保存系统日志
     *
     * @param dto
     */
    void saveSystemLog(SystemLogDTO dto);
}
