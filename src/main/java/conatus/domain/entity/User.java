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
    
    private Long userId;

    @Column(nullable = false)
    private String userName;



    @OneToMany(mappedBy = "user")
    List<RoomMember> roomList; 
}

