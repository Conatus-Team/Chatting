package conatus.domain.entity;

import conatus.ChattingApplication;
import conatus.domain.event.ChattingExited;
import java.util.Date;
import javax.persistence.*;

import conatus.domain.repository.ChattingRepository;
import lombok.Data;

@Entity
@Table(name = "Chatting_table")
@Data
public class Chatting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long chattingId;

    private Date sendDate;

    private Long userId;

    private String content;

    private Long groupId;

    @PostPersist
    public void onPostPersist() {
        ChattingExited chattingExited = new ChattingExited(this);
        chattingExited.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static ChattingRepository repository() {
        ChattingRepository chattingRepository = ChattingApplication.applicationContext.getBean(
            ChattingRepository.class
        );
        return chattingRepository;
    }
}
