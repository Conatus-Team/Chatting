package conatus.domain.entity;

import conatus.ChattingApplication;
import conatus.domain.event.ChattingExited;
import java.util.Date;
import javax.persistence.*;

import conatus.domain.repository.ChattingMessageRepository;
import lombok.Data;
import lombok.Getter;

@Entity
@Table(name = "chatting_message")
@Data
@Getter
public class ChattingMessage extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    private String content;

    @ManyToOne
    @JoinColumn(name = "chatting_room_id")
    private ChattingRoom chattingRoom;

    @PostPersist
    public void onPostPersist() {
        ChattingExited chattingExited = new ChattingExited(this);
        chattingExited.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static ChattingMessageRepository repository() {
        ChattingMessageRepository chattingMessageRepository = ChattingApplication.applicationContext.getBean(
            ChattingMessageRepository.class
        );
        return chattingMessageRepository;
    }
}
