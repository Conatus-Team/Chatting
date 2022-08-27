package conatus.infra.controller;

import java.util.List;

import javax.transaction.Transactional;

import conatus.domain.dto.ChattingRoomDto;
import conatus.domain.service.ChattingRoomService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/chat")
@RequiredArgsConstructor
@Transactional
public class ChattingRoomController {

    private final ChattingRoomService chattingRoomService;

    // 나중에 카프카로 변경
    // 방 생성  
    @PostMapping("/room")
    public ChattingRoomDto createRoom( Long groupId,  Long userId, String groupName, String category){
        return chattingRoomService.createRoom(groupId, userId, groupName, category);
    }



    @ApiOperation(value="방 생성 - 테스트용", notes="방 생성 - 테스트용")
    @PostMapping("/room/test")
    public ChattingRoomDto createRoomTemp( Long groupId,  Long userId, String groupName, String category){

        return chattingRoomService.createRoom(groupId, userId, groupName, category);
    }

    @ApiOperation(value="userId에 해당하는 방 찾기", notes="방 찾기")
    @GetMapping("/room")
    public List<ChattingRoomDto> findAllRoomByUserId(@RequestHeader(value="Authorization") Long userId){
        return chattingRoomService.findAllRoomByUserId(userId);
    }



}
