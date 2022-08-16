package conatus.infra.controller;

import javax.transaction.Transactional;

import conatus.domain.dto.ChattingMessageDto;
import conatus.domain.entity.ChattingMessage;
import conatus.domain.repository.ChattingMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
//@RequestMapping(value = "/chattingMessages")
@Transactional
@RequiredArgsConstructor
public class ChattingMessageController {

    private final SimpMessageSendingOperations sendingOperations;
    private final ChattingMessageRepository chattingMessageRepository;


    @MessageMapping("/chat/message")
    public void enter(ChattingMessageDto message) {
        System.out.println(message);
        if (ChattingMessageDto.MessageType.ENTER.equals(message.getType())) {
            message.setMessage(message.getNickname()+"님이 입장하였습니다.");
        }
        
        // 메시지 보내기
        sendingOperations.convertAndSend("/topic/chat/room/"+message.getGroupId(),message);

    }
}
