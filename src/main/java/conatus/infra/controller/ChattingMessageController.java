package conatus.infra.controller;

import javax.transaction.Transactional;

import conatus.domain.entity.ChattingMessage;
import conatus.domain.repository.ChattingMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/chattingMessages")
@Transactional
@RequiredArgsConstructor
public class ChattingMessageController {

    private final SimpMessageSendingOperations sendingOperations;
    private final ChattingMessageRepository chattingMessageRepository;


    @MessageMapping("/")
    public void enter(ChattingMessage message) {
        System.out.println(message);

        // 메시지 보내기
        sendingOperations.convertAndSend("/topic/chat/room/"+message.getGroupId(),message);

    }
}
