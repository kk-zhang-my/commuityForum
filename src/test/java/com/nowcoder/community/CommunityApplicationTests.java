package com.nowcoder.community;

import com.nowcoder.community.dao.AlphaDao;
import com.nowcoder.community.dao.AlphaDaoImplMybaits;
import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.service.Alphaservice;
import net.minidev.json.JSONUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
class CommunityApplicationTests implements ApplicationContextAware {
	private ApplicationContext applicationContext;




	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Test
	void contextLoads() {
		System.out.println(applicationContext);
		AlphaDao alpha = applicationContext.getBean(AlphaDao.class);
		System.out.println(alpha.select());

		alpha = applicationContext.getBean("alphaHibernate",AlphaDao.class);
		System.out.println(alpha.select());

		alpha = (AlphaDao) applicationContext.getBean("alphaHibernate");
		System.out.println(alpha.select());
	}


	@Test
	public void tetBeanMagement(){
		Alphaservice alphaservice = applicationContext.getBean(Alphaservice.class);
		System.out.println(alphaservice);

		alphaservice = applicationContext.getBean(Alphaservice.class);
		System.out.println(alphaservice);

	}

	@Test
	public void testBeanConfig(){
		SimpleDateFormat simpleDateFormat = applicationContext.getBean(SimpleDateFormat.class);
		System.out.println(simpleDateFormat.format(new Date()));
	}


	@Autowired
	@Qualifier("alphaHibernate")
	private AlphaDao alphaDao; // 这句话的意思是使用依赖注入把AlphaDao注入给这个属性，然后我们就行进行使用了


	@Autowired
	private Alphaservice alphaservice;


	@Autowired
	private SimpleDateFormat simpleDateFormat;

	@Test
	public void testDI(){
		System.out.println(alphaDao);
		System.out.println(alphaservice);
		System.out.println(simpleDateFormat);
	}


}
