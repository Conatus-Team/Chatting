package conatus.domain.entity;


import lombok.*;

import javax.persistence.*;

@Data
@Table(name="user")
@Entity //table과 link된 class임을 나타냄.
//기본 값으로 클래스의 카멜 케이스의 이름을 언더스코어 네이밍으로 바꿈(이거 나중에 수정할 것)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //MySQL의 AUTO_INCREMENT를 사용
    private Long userId;

    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String userMessage;


    @Builder
    public User(String userName, String userMessage){
        this.userName = userName;
        this.userMessage = userMessage;
    }



    public void setUserName(String userName){
        this.userName = userName;
    }


    public void setUserMessage(String userMessage){
        this.userMessage = userMessage;
    }

    @Override
    public String toString(){
        return "UserVo{"+
                //"userId="+userId+
                "userName='" +userName+"'"+
                ", userMessage='"+userMessage+
                '\'' +
                '}';
    }
}

