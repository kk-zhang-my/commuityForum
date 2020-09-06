package com.nowcoder.community;


import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;
import java.util.List;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class mapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectUser(){
        User user = userMapper.selectById(101);
        System.out.println(user);

        user = userMapper.selectByName("liubei");
        System.out.println(user);

        user = userMapper.selectByEmail("nowcoder101@sina.com");
        System.out.println(user);

    }

    @Test
    public void testInsertUser(){
        User user = new User();
        user.setUsername("zhangsan");
        user.setPassword("123456");

        user.setSalt("abd");
        user.setEmail("test@qq.com");
        user.setHeaderUrl("http://www.baidu.com/101.png");
        user.setCreateTime(new Date());

        int row = userMapper.insertUser(user);
        System.out.println(row);

    }


    @Test
    public void updateUser(){
        int row = userMapper.updateStatus(150,1);
        System.out.println("row" + row);

        int r = userMapper.updateHead(101,"http://www.wangyi.com/50.png");
        System.out.println("r" + r);

        int c = userMapper.updatepassword(150,"4");
        System.out.println("c" + c);


    }

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    public void testDiscussPost(){
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(149,0,10);
        for(DiscussPost post:list){
            System.out.println(post);
        }
        int rows = discussPostMapper.selectDiscussPostRows(149);
        System.out.println(rows);

    }









}


