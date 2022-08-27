package conatus.domain.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import conatus.domain.dto.ChattingMessageDto;
import conatus.domain.entity.ChattingMessage;
import conatus.domain.entity.ChattingRoom;
import conatus.domain.entity.User;
import conatus.domain.repository.ChattingMessageRepository;
import conatus.domain.repository.ChattingRoomRepository;
import conatus.domain.repository.RoomMemberRepository;
import conatus.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Vector;
import java.util.function.Function;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChattingMessageService {
    private final UserRepository userRepository;
    private final RoomMemberRepository roomMemberRepository;
    private final ChattingRoomRepository chattingRoomRepository;
    private final ChattingMessageRepository chattingMessageRepository;



    public ChattingMessageDto saveMessage(ChattingMessageDto chattingMessageDto){
        Optional<ChattingRoom> room = chattingRoomRepository.findById(chattingMessageDto.getRoomId());
        ChattingMessage chattingMessage = new ChattingMessage();

        chattingMessage.setUserId(chattingMessageDto.getUserId());
        chattingMessage.setMessage(chattingMessageDto.getMessage());
        chattingMessage.setChattingRoom(room.get());

        chattingMessageRepository.save(chattingMessage);

        return chattingMessageDto;
    }

    public ChattingMessageDto toDto(ChattingMessage chattingMessage) {

        ChattingMessageDto chattingMessageDto = ChattingMessageDto.from(chattingMessage);
        User user = userRepository.findByUserId(chattingMessage.getUserId());
        System.out.println(user.getUserNickname());
        chattingMessageDto.setNickname(user.getUserNickname());
        return chattingMessageDto;

    }

    // 모든 채팅 내역 보내기 (페이징+정렬 적용)
     @Transactional(readOnly = true)
    public Page<ChattingMessageDto> getAllChatDataPageSort(Long roomId, int page, int size, String sortColumn, String sortOrder) {
         if(sortColumn.equals("roomUUID")) {
             sortColumn = "id";
         }

         // 컬럼 정렬
         Sort sort = Sort.by(sortColumn);

         // 오름차순 or 내림차순
         if (sortOrder.equals("asc")) {
             sort = sort.ascending();
         } else {
             sort = sort.descending();
         }

         // id 순서대로 보내기
         if (!sortColumn.equals("id")) {
             sort = sort.and(Sort.by("id").ascending());
         }

         Pageable pageable= PageRequest.of(page, size, sort);

         Page<ChattingMessageDto> result = this.chattingMessageRepository.findByChattingRoomId(roomId,  pageable).map(this::toDto);

//         Page<ChattingMessageDto> result = new Vector<ChattingMessageDto>;
//         Page<ChattingMessage> chattingMessagePage = this.chattingMessageRepository.findByChattingRoomId(roomId,  pageable);
//         for (ChattingMessage data: chattingMessagePage) {
//             ChattingMessageDto dto = ChattingMessageDto.from(data);
//             User user = userRepository.findByUserId(data.getUserId());
//             dto.setNickname(user.getUserNickname());
//         }
         return result;
    }
}
