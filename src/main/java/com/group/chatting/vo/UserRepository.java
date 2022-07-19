package com.group.chatting.vo;
import org.springframework.data.jpa.repository.JpaRepository;

//CRUD자동으로 해줌
public interface UserRepository extends JpaRepository<UserVO, Integer> {

}
