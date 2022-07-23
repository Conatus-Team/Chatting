package conatus.domain.entity;

import conatus.ChattingApplication;

import javax.persistence.*;

import conatus.domain.event.ChattingJoined;
import conatus.domain.event.ChattingQuitted;
import conatus.domain.event.GroupJoined;
import conatus.domain.event.GroupQuitted;
import conatus.domain.repository.ChattingRoomRepository;
import lombok.Data;

@Entity
@Table(name = "ChattingRoom_table")
@Data
public class ChattingRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    private Long groupId;

    @PostPersist
    public void onPostPersist() {
        ChattingQuitted chattingQuitted = new ChattingQuitted(this);
        chattingQuitted.publishAfterCommit();

        ChattingJoined chattingJoined = new ChattingJoined(this);
        chattingJoined.publishAfterCommit();
    }

    public static ChattingRoomRepository repository() {
        ChattingRoomRepository chattingRoomRepository = ChattingApplication.applicationContext.getBean(
            ChattingRoomRepository.class
        );
        return chattingRoomRepository;
    }

    public static void joinChatting(GroupJoined groupJoined) {
        /** Example 1:  new item 
        ChattingRoom chattingRoom = new ChattingRoom();
        repository().save(chattingRoom);

        */

        /** Example 2:  finding and process
        
        repository().findById(groupJoined.get???()).ifPresent(chattingRoom->{
            
            chattingRoom // do something
            repository().save(chattingRoom);


         });
        */

    }

    public static void quitChatting(GroupQuitted groupQuitted) {
        /** Example 1:  new item 
        ChattingRoom chattingRoom = new ChattingRoom();
        repository().save(chattingRoom);

        */

        /** Example 2:  finding and process
        
        repository().findById(groupQuitted.get???()).ifPresent(chattingRoom->{
            
            chattingRoom // do something
            repository().save(chattingRoom);


         });
        */

    }
}
