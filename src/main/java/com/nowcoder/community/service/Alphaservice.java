package com.nowcoder.community.service;

import com.nowcoder.community.dao.AlphaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
//@Scope("prototype")  //每次getBean构建新的实例
public class Alphaservice {

    @Autowired
    @Qualifier("alphaHibernate")
    private AlphaDao alphaDao;



    @PostConstruct //构造器之后的调用
    public void init(){
        System.out.println("初始化AlphaService");
    }

    public Alphaservice(){
        System.out.println("实例化AlphaService");
    }

    @PreDestroy //销毁对象之前调用
    public void destrcy(){
        System.out.println("销毁AlphaService");
    }


    public String find(){
        return alphaDao.select();
    }
}
