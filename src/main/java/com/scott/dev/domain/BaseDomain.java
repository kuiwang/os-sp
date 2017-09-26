package com.scott.dev.domain;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Domain对象基类
 */
public class BaseDomain implements Serializable {

    private static final long serialVersionUID = 1809437478796265606L;

    protected Logger logger = LoggerFactory.getLogger(getClass());

}
