package cn.violin.common.config;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 用户操作日志管理
 * 
 * @author G
 */
@Component
//@Aspect
public class LogAopConfig {
    private Logger log = LoggerFactory.getLogger(LogAopConfig.class);
}
