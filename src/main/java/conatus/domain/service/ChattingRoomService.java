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
	
	
    //채팅방 불러오기
    public List<ChattingRoomDto> findAllRoomByUser(Long userId) {
    	User user = userRepository.findByUserId(userId);
    	List<RoomMember> roomMemberList = user.getRoomList();
    	
    	List<ChattingRoomDto> rooms = new Vector<ChattingRoomDto>();
    	for (RoomMember roomMember : roomMemberList) {
    		
    	}
    	
    	
    	
    	
        //채팅방 최근 생성 순으로 반환
//        List<ChattingRoom> result = new ArrayList<>(ChattingRooms.values());
//        Collections.reverse(result);
    	List<ChattingRoom> rooms = this.chattingRoomRepository.findAll();
    	List<ChattingRoomDto> result = new Vector<ChattingRoomDto>();
    	
    	for (int i = 0; i < rooms.size(); i++) {
    		ChattingRoomDto dto = new ChattingRoomDto();
    		dto.setRoomUUID(rooms.get(i).getRoomUUID());
    		result.add(dto);
    	}
        return result;
    }

    //채팅방 하나 불러오기
    public ChattingRoom findById(String roomId) {
        return ChattingRooms.get(roomId);
    }

    //채팅방 생성
    public ChattingRoom createRoom( ) {
        ChattingRoom ChattingRoom = ChattingRoom.create();
        ChattingRoomRepository.save(ChattingRoom);
//        ChattingRooms.put(ChattingRoom.getRoomUUID(), ChattingRoom);
        return ChattingRoom;
    }
}
