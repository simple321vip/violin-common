package cn.violin.common.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class DocsifyConf {

    @Value("${constant.docsify-workspace}")
    private String DOCSIFY_WORKSPACE;
}
