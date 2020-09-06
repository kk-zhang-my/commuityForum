package com.nowcoder.community.dao;

import com.nowcoder.community.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User selectById(int id);//根据id查user

    User selectByName(String username);

    User selectByEmail(String email);

    int insertUser(User user); // 返回插入的行数，对象为user

    int updateStatus(int id, int status);//返回的修改数据条数  以id为修改条件，改的状态码，把最新状态传入进去

    int updateHead(int id, String headerUrl);

    int updatepassword(int id, String password);











}
