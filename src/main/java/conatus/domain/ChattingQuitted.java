package conatus.domain;

import conatus.domain.*;
import conatus.infra.AbstractEvent;
import java.util.Date;
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
