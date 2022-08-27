package conatus.domain.event;

import conatus.domain.entity.ChattingRoom;
import conatus.infra.AbstractEvent;
import lombok.Data;

@Data
public class ChattingJoined extends AbstractEvent {

    private Long id;

    public ChattingJoined(ChattingRoom aggregate) {
        super(aggregate);
    }

    public ChattingJoined() {
        super();
    }
    // keep

}
