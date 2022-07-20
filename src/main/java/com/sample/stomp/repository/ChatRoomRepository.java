package com.sample.stomp.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.stomp.model.ChatRoom;


//CRUD자동으로 해줌
public interface ChatRoomRepository extends JpaRepository<ChatRoom, Integer> {

}
