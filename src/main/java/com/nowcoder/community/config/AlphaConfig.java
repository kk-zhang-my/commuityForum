package com.nowcoder.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

@Configuration //普通类用这个注解
public class AlphaConfig {

    @Bean //第三方的Bean,simpleDateFormat名就是Bean的名字
    public SimpleDateFormat simpleDateFormat(){
        return new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        //这段话的意思是方法返回的对象装配到容器中

    }

}
