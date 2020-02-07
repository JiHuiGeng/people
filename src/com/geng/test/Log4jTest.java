package com.geng.test;

import org.apache.log4j.Logger;

/**
 * Log4jTest
 */
public class Log4jTest {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Log4jTest.class);
        logger.info("这是一个info级别的日志");
    }
}
