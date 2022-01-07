package com.xeg.cores.mysql;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.xeg.cores.base.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author ArchieDing
 * @since 2020/09/02
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "version", Integer.class, 0);
        this.strictInsertFill(metaObject, "createTime", Long.class, DateUtil.getTimestamp());
        this.strictInsertFill(metaObject, "updateTime", Long.class, DateUtil.getTimestamp());
        this.strictInsertFill(metaObject, "deleted", String.class, "N");
        //TODO 数据结构优化
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "isDel", Integer.class, 0);



    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updateTime", Long.class, DateUtil.getTimestamp());
    }
}
