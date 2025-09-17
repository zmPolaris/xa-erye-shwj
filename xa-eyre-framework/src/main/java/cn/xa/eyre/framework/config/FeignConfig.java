package cn.xa.eyre.framework.config;

import cn.xa.eyre.framework.config.openfegin.FeignResponseDecoder;
import feign.Feign;
import feign.Logger;
import feign.codec.Decoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class FeignConfig {
    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder() {
        return Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder());
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL; // 上线后改为BASIC或NONE
    }

//    @Bean
    public Decoder feignDecoder(ObjectFactory<HttpMessageConverters> converters) {
        return new FeignResponseDecoder(
                new ResponseEntityDecoder(new SpringDecoder(converters))
        );
    }
}

