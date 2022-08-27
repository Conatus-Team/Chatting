package conatus.domain.dto;

import conatus.domain.entity.ChattingRoom;
import lombok.Builder;
import lombok.Data;

@Data
public class ChattingRoomDto {

    private Long id;

    private Long groupId;

    private String groupName;

    private String category;

    @Builder
    public ChattingRoomDto(ChattingRoom chattingRoom){
        this.id = chattingRoom.getId();
        this.groupId = chattingRoom.getGroupId();
        this.groupName = chattingRoom.getGroupName();
        this.category = chattingRoom.getCategory();


    }
}
