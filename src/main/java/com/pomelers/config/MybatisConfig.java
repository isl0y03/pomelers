package com.pomelers.config;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.TypeHandler;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import com.pomelers.domain.kbn.Visibility;
import com.pomelers.mapper.VisibilityTypeHandler;

@org.springframework.context.annotation.Configuration
public class MybatisConfig implements ConfigurationCustomizer {

    @Bean
    public TypeHandler<Visibility> visibilityTypeHandler() {
        return new VisibilityTypeHandler();
    }

    @Override
    public void customize(final Configuration configuration) {
        configuration.getTypeHandlerRegistry().register(visibilityTypeHandler());

    }

}
