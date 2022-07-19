package com.group.chatting.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

// Data 어노테이션은 getter, setter를 자동 생성
@Data
// AllArgsConstructor 어노테이션은 생성자를 자동 생성
@AllArgsConstructor
public class SocketVO {
    // 유저의 이름을 저장하기 위한 변수
    private String userName;

    // 메시지의 내용을 저장하기 위한 변수
    private String userMessage;
}
