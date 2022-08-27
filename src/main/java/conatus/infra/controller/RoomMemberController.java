package conatus.infra.controller;

import java.util.List;

import javax.transaction.Transactional;

import conatus.domain.dto.ChattingRoomDto;
import conatus.domain.service.ChattingRoomService;
import conatus.domain.service.RoomMemberService;
import lombok.RequiredArgsConstructor;

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
public class RoomMemberController {

    private final RoomMemberService roomMemberService;

    // 나중에 카프카로 바꿔야 함
    @PostMapping("/join")
    public ChattingRoomDto joinRoom( Long groupId,  Long userId){
        return roomMemberService.joinRoom(groupId, userId);
    }




}
