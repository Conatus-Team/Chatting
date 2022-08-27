package conatus.infra;

import conatus.domain.service.ChattingRoomService;
import conatus.config.kafka.KafkaProcessor;

import javax.transaction.Transactional;

import conatus.domain.event.GroupJoined;
import conatus.domain.event.GroupQuitted;
import conatus.domain.repository.ChattingMessageRepository;
import conatus.domain.repository.ChattingRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    ChattingMessageRepository chattingRepository;

    @Autowired
    ChattingRoomRepository chattingRoomRepository;

    public final ChattingRoomService chattingRoomService;


    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {
        System.out.println("=========================================");
        System.out.println("=========================================");
        System.out.println("eventString = " + eventString);
        System.out.println("=========================================");
        System.out.println("=========================================");
    }


    /* GroupJoined
      {
        "eventType":"GroupJoined",
        "timestamp":1661587343841,
        "member":{
          "createdTime":{
            "nano":806394400,"year":2022,"monthValue":8,"dayOfMonth":27,"hour":17,"minute":2,"second":23,"month":"AUGUST","dayOfWeek":"SATURDAY","dayOfYear":239,"chronology":{"id":"ISO","calendarType":"iso8601"}
          },
          "updatedTime":{
            "nano":806394400,"year":2022,"monthValue":8,"dayOfMonth":27,"hour":17,"minute":2,"second":23,"month":"AUGUST","dayOfWeek":"SATURDAY","dayOfYear":239,"chronology":{"id":"ISO","calendarType":"iso8601"}
          },
          "id":6,
          "isDeleted":false,
          "userId":3,
          "nickname":"ttt",
          "isLeader":false,
          "groupId":2
         }
      }
    */
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverGroupJoined_JoinChatting(@Payload GroupJoined groupJoined) {
        if (!groupJoined.validate()){
            System.out.println("=========================================");
            System.out.println("=========================================");
            System.out.println("not validate");
            System.out.println("=========================================");
            System.out.println("=========================================");
            return;
        }
        GroupJoined event = groupJoined;


        System.out.println("=========================================");
        System.out.println("=========================================");
        System.out.println(event);
        System.out.println("=========================================");
        System.out.println("=========================================");

        // Sample Logic //
//        chattingRoomService.joinRoom(event);

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
