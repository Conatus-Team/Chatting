//package conatus.infra;
//
//import conatus.domain.service.RoomMemberService;
//import lombok.RequiredArgsConstructor;
//import conatus.domain.event.SignedUp;
//import conatus.domain.service.ChattingRoomService;
////import conatus.infra.config.KafkaProcessor;
//
//
//import conatus.domain.event.GroupJoined;
//import conatus.domain.repository.ChattingMessageRepository;
//import conatus.domain.repository.ChattingRoomRepository;
//import conatus.domain.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.stream.annotation.StreamListener;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.stereotype.Service;
//import javax.transaction.Transactional;
//
//
//@RequiredArgsConstructor
//@Service
//@Transactional
//public class PolicyHandler {
//
//    @Autowired
//    ChattingMessageRepository chattingRepository;
//
//    @Autowired
//    ChattingRoomRepository chattingRoomRepository;
//
//    public final ChattingRoomService chattingRoomService;
//    public final UserService userService;
//    public final RoomMemberService roomMemberService;
//
//    @StreamListener(KafkaProcessor.INPUT)
//    public void whatever(@Payload String eventString) {
//
//        System.out.println("eventString = " + eventString);
//    }
//
//
//    // 유저 회원가입 이벤트
//    // 유저 등록
//    @StreamListener(KafkaProcessor.INPUT)
//    public void postUser(@Payload SignedUp signedUp) {
//        if (!signedUp.validate()) return;
//        System.out.println("====================================");
//        System.out.println("====================================");
//        System.out.println("SignedUp");
//        System.out.println("====================================");
//        System.out.println("====================================");
//        userService.postUser(
//                signedUp.getUserId(),
//                signedUp.getEmail(),
//                signedUp.getUserName(),
//                signedUp.getUserNickname()
//        );
//
//    }
//
//
//
//    /* GroupJoined
//      {
//        "eventType":"GroupJoined",
//        "timestamp":1661587343841,
//        "member":{
//          "createdTime":{
//            "nano":806394400,"year":2022,"monthValue":8,"dayOfMonth":27,"hour":17,"minute":2,"second":23,"month":"AUGUST","dayOfWeek":"SATURDAY","dayOfYear":239,"chronology":{"id":"ISO","calendarType":"iso8601"}
//          },
//          "updatedTime":{
//            "nano":806394400,"year":2022,"monthValue":8,"dayOfMonth":27,"hour":17,"minute":2,"second":23,"month":"AUGUST","dayOfWeek":"SATURDAY","dayOfYear":239,"chronology":{"id":"ISO","calendarType":"iso8601"}
//          },
//          "id":6,
//          "isDeleted":false,
//          "userId":3,
//          "nickname":"ttt",
//          "isLeader":false,
//          "groupId":2
//         }
//      }
//    */
//    @StreamListener(KafkaProcessor.INPUT)
//    public void wheneverGroupJoined_JoinChatting(@Payload GroupJoined groupJoined) {
//        if (!groupJoined.validate()){
//            return;
//        }
//        GroupJoined joinMember = groupJoined;
//
//        System.out.println("=========================================");
//        System.out.println("=========================================");
//        System.out.println(joinMember);
//        System.out.println("=========================================");
//        System.out.println("=========================================");
//
//        // Sample Logic //
//        roomMemberService.joinRoom(joinMember.getGroupId(), joinMember.getUserId());
//
//    }
//
////    @StreamListener(KafkaProcessor.INPUT)
////    public void wheneverGroupQuitted_QuitChatting(
////        @Payload GroupQuitted groupQuitted
////    ) {
////        if (!groupQuitted.validate()) return;
////        GroupQuitted event = groupQuitted;
////        System.out.println(
////            "\n\n##### listener QuitChatting : " +
////            groupQuitted.toJson() +
////            "\n\n"
////        );
////
////        // Sample Logic //
////        ChattingRoom.quitChatting(event);
////    }
////    // keep
//
//}
