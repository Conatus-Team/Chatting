package com.sample.stomp.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.stomp.model.UserVO;

//CRUD자동으로 해줌
public interface UserRepository extends JpaRepository<UserVO, Integer> {

}
