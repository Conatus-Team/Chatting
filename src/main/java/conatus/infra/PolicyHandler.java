package conatus.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import conatus.config.kafka.KafkaProcessor;
import conatus.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    ChattingRepository chattingRepository;

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
