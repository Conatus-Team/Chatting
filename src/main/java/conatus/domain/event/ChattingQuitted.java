package conatus.domain.event;

import conatus.domain.entity.ChattingRoom;
import conatus.infra.AbstractEvent;
import lombok.Data;

@Data
public class ChattingQuitted extends AbstractEvent {

    private Long id;

    public ChattingQuitted(ChattingRoom aggregate) {
        super(aggregate);
    }

    public ChattingQuitted() {
        super();
    }
    // keep

}
