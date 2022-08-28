package conatus.domain.entity;


import lombok.*;

import java.util.List;

import javax.persistence.*;

@Data
@Table(name="user")
@Entity //table과 link된 class임을 나타냄.
//기본 값으로 클래스의 카멜 케이스의 이름을 언더스코어 네이밍으로 바꿈(이거 나중에 수정할 것)
public class User extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //MySQL의 AUTO_INCREMENT를 사용
    private Long id;

    @Column(name="is_deleted", nullable = false)
    private boolean isDeleted = Boolean.FALSE; // 디폴트 false

    @Column(name="user_id", nullable = false)
    private Long userId;

    @Column(name="user_name", nullable = false, length = 100)
    private String userName;

    @Column(name="user_nickname",nullable = true, length = 100)
    private String userNickname;

    @Column(name="email",nullable = false, length = 100, unique = true)
    private String email;


    @OneToMany(mappedBy = "user")
    List<RoomMember> roomList;
}

