package conatus.domain.event;


import conatus.infra.AbstractEvent;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GroupJoined extends AbstractEvent {

//    private Long id;
//    private Long groupId;
//    private Long userId;
//    private String category="";
//    private String groupName="";

    private Member member;

    public GroupJoined(Member aggregate) {
        super(aggregate);
        member = aggregate;
    }

    public GroupJoined() {
        super();
    }

    @Data
    public class Member {
        LocalDateTime createdTime;
        LocalDateTime updatedTime;
        Long id;
        Boolean isDeleted = Boolean.FALSE;
        Long userId;
        String nickname;
        Boolean isLeader = Boolean.FALSE;
        Long groupId;
    }

}
