package com.group.chatting.vo;

//package com.group.chatting.config;
//
//import lombok.*;
//
//import javax.persistence.*;
//
//@ToString
//@Getter
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//@Table(name="group_chat")
//@Entity
//public class Chatting {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY) //MySQL의 AUTO_INCREMENT를 사용
//    private Long id;
//
//    @Column(length = 200, nullable = false)
//    private String userName;
//    @Column(length = 200, nullable = false)
//    private String UserMessage;
//}


//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@NoArgsConstructor


import lombok.*;

import javax.persistence.*;

@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="group_chat")
@Entity //table과 link된 class임을 나타냄.
        //기본 값으로 클래스의 카멜 케이스의 이름을 언더스코어 네이밍으로 바꿈(이거 나중에 수정할 것)
public class UserVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //MySQL의 AUTO_INCREMENT를 사용
    private int userId;

    @Column(length = 200, nullable = false)
    private String userName;
    @Column(length = 500, nullable = false)
    private String userMessage;


    @Builder
    public UserVO(String userName, String userMessage){
        this.userName = userName;
        this.userMessage = userMessage;
    }



//    public void setUserId(int userId){
//        this.userId = userId;
//    }


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

