package conatus.domain.middle;


import conatus.domain.event.GroupCreated;
import conatus.domain.event.GroupJoined;
import conatus.domain.event.SignedUp;
import conatus.domain.service.ChattingRoomService;
import conatus.domain.service.RoomMemberService;
import conatus.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/chatting/connect_middle")
public class GetMiddleController {
    public final UserService userService;
    public final RoomMemberService roomMemberService;
    public final ChattingRoomService chattingRoomService;

    // 구독 : (Auth)회원가입
    @PostMapping("/SignedUp")
    public void postUser(@RequestBody SignedUp signedUp) {
        if (!signedUp.validate()) return;
        userService.postUser(
                signedUp.getUserId(),
                signedUp.getEmail(),
                signedUp.getUserName(),
                signedUp.getUserNickname()
        );
    }

    // 구독 : (Group)그룹 생성
    @PostMapping("GroupCreated")
    public void postGroup(@RequestBody GroupCreated groupCreated) {
        if (!groupCreated.validate()) return;

        System.out.println("=========================================");
        System.out.println("=========================================");
        System.out.println(groupCreated);
        System.out.println("=========================================");
        System.out.println("=========================================");

        // 채팅방 및 최초 멤버 생성
        chattingRoomService.createRoom(
                groupCreated.getGroupId(),
                groupCreated.getUserId(),
                groupCreated.getName(),
                groupCreated.getCategory()
        );


    }


    // 구독 : (Group)그룹가입
    @PostMapping("/GroupJoined")
    public void postMember(@RequestBody GroupJoined groupJoined) {
        if (!groupJoined.validate()) return;
        GroupJoined.Member joinMember = groupJoined.getMember();

        System.out.println("=========================================");
        System.out.println("=========================================");
        System.out.println(groupJoined);
        System.out.println("=========================================");
        System.out.println("=========================================");

        // Sample Logic //
        roomMemberService.joinRoom(joinMember.getGroupId(), joinMember.getUserId());
    }

}
