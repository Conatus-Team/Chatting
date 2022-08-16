package conatus.domain.service;

import java.util.List;
import java.util.Vector;

import org.springframework.stereotype.Service;

import conatus.domain.dto.ChattingRoomDto;
import conatus.domain.entity.ChattingRoom;
import conatus.domain.entity.RoomMember;
import conatus.domain.entity.User;
import conatus.domain.repository.ChattingRoomRepository;
import conatus.domain.repository.RoomMemberRepository;
import conatus.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChattingRoomService {
	private final UserRepository userRepository;
	private final RoomMemberRepository roomMemberRepository;
	private final ChattingRoomRepository chattingRoomRepository;
	
	
    //유저가 가입한 채팅방 불러오기
    public List<ChattingRoomDto> findAllRoomByUserId(Long userId) {
    	// 유저 찾기
    	User user = userRepository.findByUserId(userId);
    	
    	// 유저가 가입한 방 목록 얻기
    	List<RoomMember> roomMemberList = user.getRoomList();
    	
    	// DTO로 바꾸기    	
    	List<ChattingRoomDto> rooms = new Vector<ChattingRoomDto>();
    	for (RoomMember roomMember : roomMemberList) {
    		ChattingRoomDto tmp = new ChattingRoomDto(roomMember.getChattingRoom());
    		rooms.add(tmp);
    	}
    	
        return rooms;
    }

    //채팅방 생성
    public ChattingRoomDto createRoom(Long groupId, Long userId, String groupName, String category) {
    	// 유저 찾기
    	User user = userRepository.findByUserId(userId);
    	
    	// 채팅방 객체 생성
        ChattingRoom chattingRoom = new ChattingRoom();
        chattingRoom.setGroupId(groupId);
        chattingRoom.setGroupName(groupName);
        chattingRoom.setCategory(category);
        chattingRoom.setLeader(user);
        
        // 채팅방 객체 저장
        ChattingRoom savedChattingRoom = chattingRoomRepository.save(chattingRoom);
        
        // 그룹에 유저 저장하기
        RoomMember roomMember = new RoomMember(user, savedChattingRoom);
        roomMemberRepository.save(roomMember);
        
        // DTO로 만들기
        ChattingRoomDto chattingRoomDto = new ChattingRoomDto(savedChattingRoom);
        
        return chattingRoomDto;
       
    }
}
