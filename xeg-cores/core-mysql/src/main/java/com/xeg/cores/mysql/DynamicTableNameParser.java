package com.xeg.cores.mysql;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.core.parser.SqlInfo;
import com.xeg.cores.base.context.UserHolder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.apache.ibatis.reflection.MetaObject;

/**
 * @author ArchieDing
 * @since 2020/09/02
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class DynamicTableNameParser implements ISqlParser {

    private String tenantDatabasePrefix;

    public DynamicTableNameParser(String tenantDatabasePrefix) {
        this.tenantDatabasePrefix = tenantDatabasePrefix;
    }

    @Override
    public SqlInfo parser(MetaObject metaObject, String sql) {
        if (allowProcess(metaObject)) {
            String tenantCode = UserHolder.getTenant();
            if (StrUtil.isEmpty(tenantCode)) {
                return null;
            }

            String schemaName = StrUtil.format("{}_{}", tenantDatabasePrefix, tenantCode);
            // 想要 执行sql时， 切换到 切换到自己指定的库， 直接修改 setSchemaName
            String parsedSql = ReplaceSql.replaceSql(schemaName, sql);
            return SqlInfo.newInstance().setSql(parsedSql);
        }
        return null;
    }


    /**
     * 判断是否允许执行
     * <p>例如：逻辑删除只解析 delete , update 操作</p>
     *
     * @param metaObject 元对象
     * @return true
     */
    private boolean allowProcess(MetaObject metaObject) {
        return true;
    }
}
