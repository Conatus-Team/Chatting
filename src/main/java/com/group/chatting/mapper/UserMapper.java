package com.group.chatting.mapper;
import java.util.List;

import com.group.chatting.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

//@Mapper
@Repository
public class UserMapper {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<UserVO> listForBeanPropertyRowMapper(){
        System.out.println("select");
        String query = "SELECT *FROM group_chat";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<UserVO>(UserVO.class));
    }
    public int insert(UserVO user){
        System.out.println("insert");
        System.out.println(user);
        String query = "INSERT INTO group_chat(user_name,user_message) VALUES(?,?)";
        return jdbcTemplate.update(query, user.getUserName(),user.getUserMessage());
    }
}
