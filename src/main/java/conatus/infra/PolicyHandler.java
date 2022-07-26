package conatus.infra;

import conatus.config.kafka.KafkaProcessor;

import javax.transaction.Transactional;

import conatus.domain.entity.ChattingRoom;
import conatus.domain.event.GroupJoined;
import conatus.domain.event.GroupQuitted;
import conatus.domain.repository.ChattingMessageRepository;
import conatus.domain.repository.ChattingRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    ChattingMessageRepository chattingMessageRepository;

    @Autowired
    ChattingRoomRepository chattingRoomRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverGroupJoined_JoinChatting(
        @Payload GroupJoined groupJoined
    ) {
        if (!groupJoined.validate()) return;
        GroupJoined event = groupJoined;
        System.out.println(
            "\n\n##### listener JoinChatting : " + groupJoined.toJson() + "\n\n"
        );

        // Sample Logic //
        ChattingRoom.joinChatting(event);
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverGroupQuitted_QuitChatting(
        @Payload GroupQuitted groupQuitted
    ) {
        if (!groupQuitted.validate()) return;
        GroupQuitted event = groupQuitted;
        System.out.println(
            "\n\n##### listener QuitChatting : " +
            groupQuitted.toJson() +
            "\n\n"
        );

        // Sample Logic //
        ChattingRoom.quitChatting(event);
    }
    // keep

}
