package conatus.infra.controller;

import javax.transaction.Transactional;

import conatus.domain.dto.ChattingMessageDto;
import conatus.domain.entity.ChattingMessage;
import conatus.domain.repository.ChattingMessageRepository;
import conatus.domain.service.ChattingMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.*;


@RestController
//@RequestMapping(value = "/chattingMessages")
@Transactional
@RequiredArgsConstructor
public class ChattingMessageController {

    private final SimpMessageSendingOperations sendingOperations;
    private final ChattingMessageService chattingMessageService;


    @MessageMapping("/chat/message")
    public void enter(ChattingMessageDto message) {
        System.out.println(message);
        if (ChattingMessageDto.MessageType.ENTER.equals(message.getType())) {
            message.setMessage(message.getNickname()+"님이 입장하였습니다.");
        }

        // 메시지 보내기
        sendingOperations.convertAndSend("/topic/chat/room/"+message.getRoomId(),message);

        // 메시지 저장
        if (ChattingMessageDto.MessageType.TALK.equals(message.getType())) {
            chattingMessageService.saveMessage(message);
        }
    }

    // 페이징+정렬
    @GetMapping("/chat/message/pagesort")
    @ResponseBody
    public Page<ChattingMessageDto> findPageSort(Long roomId, int page, int size, @RequestParam(defaultValue = "id") String sortColumn, @RequestParam(defaultValue = "asc")String sortOrder) {
        Page<ChattingMessageDto> paging = this.chattingMessageService.getAllChatDataPageSort(roomId, page, size, sortColumn, sortOrder);
        return paging;

    }
}
