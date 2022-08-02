package conatus.infra.controller;

import java.util.List;

import javax.transaction.Transactional;

import conatus.domain.dto.ChattingRoomDto;
import conatus.domain.repository.ChattingRoomRepository;
import conatus.domain.service.ChattingRoomService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "/chat")
@RequiredArgsConstructor
@Transactional
public class ChattingRoomController {

	private final ChattingRoomService chattingRoomService;
	
	// 나중에 카프카로 변경
	@PostMapping("/room")
    public ChattingRoomDto createdRoom(@RequestBody Long groupId, Long userId, String groupName, String category){
        return chattingRoomService.createRoom(groupId, userId, groupName, category);
    }
	
	@GetMapping("/room/user/{id}")
    public List<ChattingRoomDto> findAllRoomByUserId(@PathVariable Long userId){
        return chattingRoomService.findAllRoomByUserId(userId);
    }
}
