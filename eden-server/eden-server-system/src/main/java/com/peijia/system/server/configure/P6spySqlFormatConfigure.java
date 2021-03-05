package com.peijia.system.server.configure;

import com.baomidou.dynamic.datasource.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.p6spy.engine.spy.appender.MessageFormattingStrategy;
import com.peijia.common.util.DateUtil;
import java.time.LocalDateTime;

/**
 * @author Peijia
 * @className P6spySqlFormatConfigure
 * @desc P6spy打印SQL输出日志
 * @create 2021/3/5 14:54
 */
public class P6spySqlFormatConfigure implements MessageFormattingStrategy {

    @Override
    public String formatMessage(int connectionId, String now, long elapsed, String category, String prepared, String sql, String url) {
        return StringUtils.isNotBlank(sql) ? DateUtil.formatFullTime(LocalDateTime.now(), DateUtil.FULL_TIME_SPLIT_PATTERN)
            + " | 耗时 " + elapsed + " ms | SQL 语句：" + StringPool.NEWLINE + sql.replaceAll("[\\s]+", StringPool.SPACE) + ";" : StringPool.EMPTY;
    }
}
