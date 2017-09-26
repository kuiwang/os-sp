package com.scott.dev.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.scott.dev.common.AppConstant;

/**
 * Controller 基类
 */
public class BaseController {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 操作成功标识
     */
    public static final String SUCCESS = AppConstant.CONST_PROCESS_SUCCESS;

    /**
     * 操作失败标识
     */
    public static final String FAILED = AppConstant.CONST_PROCESS_FAILED;

    /**
     * 直接输出时的字符编码
     */
    public static final String CHARSET = AppConstant.CHARSET_UTF8;

}
