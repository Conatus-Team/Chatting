package conatus.domain;

import conatus.domain.*;
import conatus.infra.AbstractEvent;
import java.util.Date;
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
