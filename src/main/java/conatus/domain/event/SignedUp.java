
package conatus.domain.event;

import conatus.domain.entity.User;
import conatus.infra.AbstractEvent;
import lombok.Data;


@Data
public class SignedUp extends AbstractEvent {

    private Long userId;
    private String email;
    private String userName;
    private String userNickname;


    public SignedUp(User aggregate) {
        super(aggregate);
    }
    public SignedUp() {
        super();
    }
    // keep

//    // 이벤트를 엔티티로 만들기
//    public User toEntity(){
//        return User.builder()
//                .userId(userId)
//                .userNickname(userNickname)
//                .build();
//    }

}
