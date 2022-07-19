package domain;
import javax.persistence.*;

import com.chat.chatting_local.ChattingLocalApplication;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Date;


@Entity
@Table(name="Chatting_table")
public class Chatting  {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)


    private Long chattingId;


    private Date sendDate;


    private Long userId;


    private String content;


    private Long groupId;

//    @PostPersist
//    public void onPostPersist(){
//        ChattingExited chattingExited = new ChattingExited();
//        BeanUtils.copyProperties(this, chattingExited);
//        chattingExited.publishAfterCommit();
//
//    }

    public Long getChattingId() {
        return chattingId;
    }

    public void setChattingId(Long chattingId) {
        this.chattingId = chattingId;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }



    public static ChattingRepository repository(){
        ChattingRepository chattingRepository = ChattingLocalApplication.applicationContext.getBean(ChattingRepository.class);
        return chattingRepository;
    }




}
