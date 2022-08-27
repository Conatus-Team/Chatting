package conatus.domain.service;

import conatus.domain.dto.ChattingRoomDto;
import conatus.domain.entity.ChattingRoom;
import conatus.domain.entity.RoomMember;
import conatus.domain.entity.User;
import conatus.domain.repository.ChattingRoomRepository;
import conatus.domain.repository.RoomMemberRepository;
import conatus.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class RoomMemberService {
    private final UserRepository userRepository;
    private final RoomMemberRepository roomMemberRepository;
    private final ChattingRoomRepository chattingRoomRepository;


    public ChattingRoomDto joinRoom(Long groupId, Long userId) {
        // 유저 찾기
        User user = userRepository.findByUserId(userId);

        // 채팅방 찾기
        ChattingRoom chattingRoom = chattingRoomRepository.findByGroupId(groupId).get();


        // 그룹에 유저 저장하기
        RoomMember roomMember = new RoomMember(user, chattingRoom);
        roomMemberRepository.save(roomMember);

        // DTO로 만들기
        ChattingRoomDto chattingRoomDto = new ChattingRoomDto(chattingRoom);

        return chattingRoomDto;
    }
}
