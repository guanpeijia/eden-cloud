package com.peijia.common.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * @author Peijia
 * @className QueryRequest
 * @desc
 * @create 2021/3/5 17:12
 */
@Data
public class QueryRequest implements Serializable {

    private static final long serialVersionUID = -4869594085374385813L;
    /**
     * 当前页面数据量
     */
    private int pageSize = 10;
    /**
     * 当前页码
     */
    private int pageNum = 1;
    /**
     * 排序字段
     */
    private String field;
    /**
     * 排序规则，asc升序，desc降序
     */
    private String order;
}
