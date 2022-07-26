package conatus.domain.event;

import conatus.infra.AbstractEvent;
import lombok.Data;

@Data
public class GroupJoined extends AbstractEvent {

    private Long id;
    private Long groupId;
    private Long userId;
    private String category;
    // keep

}
