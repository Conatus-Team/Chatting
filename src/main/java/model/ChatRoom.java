package model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import domain.Chatting;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class ChatRoom {

    private String roomId;
    private String roomName; //groupname
    private Long groupId;


    public static ChatRoom create(String name) {
        Chatting chatting = new Chatting();
        ChatRoom room = new ChatRoom();
        room.roomId = UUID.randomUUID().toString();
        room.roomName = name;
        room.groupId = chatting.getGroupId();
        return room;
    }
}
